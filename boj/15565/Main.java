import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] input;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0;
        int count = 0; // lion count
        int ans = INF;
        while (high < N) {
            if (count < K) {
                count += input[high++] % 2;
            } else {
                ans = Math.min(ans, high - low);
                count -= input[low++] % 2;
            }
        }
        if (count >= K) {
            while (low < N && input[low] == 2) {
                low++;
            }
            ans = Math.min(ans, high - low);
        }

        if (ans == INF) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}
