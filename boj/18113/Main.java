import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, M, Largest;
    static int[] L;
    static boolean Find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        L = new int[N];
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(br.readLine());
            Largest = Math.max(L[i], Largest);
        }

        int ret = binarySearch();
        if (!Find) {
            ret = -1;
        }

        System.out.println(ret);
    }

    public static int binarySearch() {
        int low = 1;
        int high = Largest;

        int ret = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid)) {
                ret = mid;
                low = mid + 1;
                Find = true;
            } else {
                high = mid - 1;
            }
        }

        return ret;
    }

    public static boolean check(int p) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int kimbab = (L[i] >= 2 * K) ? (L[i] - 2 * K) : ((L[i] <= K) ? 0 : (L[i] - K));
            cnt += (kimbab / p);
        }

        return (cnt >= M);
    }
}
