import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] G;
    static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        G = new int[MAX];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            G[x] = g;
        }

        int low = 0;
        int high = K * 2 + 1 < MAX ? K * 2 + 1 : MAX;
        int sum = 0;
        for (int i = low; i < high; i++) {
            sum += G[i];
        }

        int ans = sum;
        while (high < MAX) {
            sum -= G[low++];
            sum += G[high++];
            ans = sum > ans ? sum : ans;
        }

        System.out.println(ans);
    }
}
