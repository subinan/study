import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        Stack<Character> S = new Stack<>();
        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(' && input[i + 1] == ')') {
                ans += S.size();
                i++;
            } else if (input[i] == '(') {
                S.push(input[i]);
            } else {
                S.pop();
                ans++;
            }
        }

        System.out.println(ans);
    }
}
