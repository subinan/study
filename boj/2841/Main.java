import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, P;
    static Stack<Integer>[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        S = new Stack[7];
        for (int i = 1; i < 7; i++) {
            S[i] = new Stack<>();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            while (!S[n].isEmpty() && S[n].peek() > p) {
                S[n].pop();
                ans++;
            }

            if (S[n].isEmpty() || (!S[n].isEmpty() && S[n].peek() < p)) {
                S[n].push(p);
                ans++;
            }
        }

        System.out.println(ans);
    }
}
