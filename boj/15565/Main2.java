import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0;
        int cnt = input[0] % 2;
        int ans = N + 1;
        while (high < N) {
            if (cnt >= K) {
                ans = Math.min(ans, high - low + 1);
                cnt -= input[low++] % 2;
            }
            else {
                cnt += input[++high] % 2;
            }
        }
        if (ans == N + 1)
            ans = -1;
        System.out.println(ans);
    }
}
