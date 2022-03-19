import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < K; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                S.pop();
            } else {
                S.push(input);
            }
        }

        int ans = 0;
        while (!S.isEmpty()) {
            ans += S.pop();
        }

        System.out.println(ans);
    }
}
