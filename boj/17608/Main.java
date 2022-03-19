import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int ans = 1;
        int curr, prev = stack.pop();
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr > prev) {
                ans++;
                prev = curr;
            }
        }

        System.out.println(ans);
    }
}
