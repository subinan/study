import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] Set;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Set = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            Set[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Set);
        backtracking(0);
        System.out.println(ans);
    }

    public static void backtracking(int n) {
        if (n > N) {
            return;
        }

        if (ans < n) {
            ans = n;
        }

        for (int i = K - 1; i >= 0; i--) {
            backtracking(n * 10 + Set[i]);
        }
    }
}
