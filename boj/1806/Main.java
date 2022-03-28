import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] A;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0;
        int sum = A[0];
        int ans = N + 1;
        while (high < N) {
            // sum >= S -> 답이랑 비교, low++
            if (sum >= S) {
                ans = ans > high - low + 1 ? high - low + 1: ans;
                sum -= A[low++];
            }
            // sum < M -> high++
            else {
                sum += A[++high];
            }
        }
        if (ans == N + 1)
            ans = 0;
        System.out.println(ans);
    }
}
