// https://leesh111112.tistory.com/212
// https://neohtux.tistory.com/200

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (getLength(N) < K) {
            System.out.println(-1);
            return;
        }

        int ret = binarySearch();
        int r = K - getLength(ret - 1);
        String num = Integer.toString(ret);
        System.out.println(num.charAt(r - 1));
    }

    public static int binarySearch() {
        int low = 1;
        int high = N;

        int ret = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (getLength(mid) < K) {
                low = mid + 1;
            } else {
                ret = mid;
                high = mid - 1;
            }
        }

        return ret;
    }

    public static int getLength(int m) {
        // 1 ~ 9        (9 - 1) + 1 * 1 = 10 - 1 * 1
        // 10 ~ 99      (99 - 10) + 1 * 2 = 100 - 10 * 2
        // 100 ~ 999    (999 - 100) + 1 * 3 = 1000 - 100 * 3
        // => 숫자의 개수 * 자릿수

        int cnt = 0;
        int k = 1;
        int i = 10;

        for ( ; i <= m; i *= 10, k++) {
            cnt += (i - i / 10) * k;
        }
        cnt += (m - i / 10 + 1) * k;

        return cnt;
    }
}
