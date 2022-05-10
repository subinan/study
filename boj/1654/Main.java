import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long largest;
    static long[] A;
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        A = new long[K];

        for (int i = 0; i < K; i++) {
            A[i] = Long.parseLong(br.readLine());
            largest = Math.max(largest, A[i]);
        }

        System.out.println(binarySearch(N));
    }

    public static boolean count(long len) {
        long cnt = 0;

        for (int i = 0; i < K; i++) {
            cnt += (A[i] / len);
        }
        return (cnt >= N);
    }
  
    public static long binarySearch(int find) {
        long low = 1;
        long high = largest;

        long ret = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            
            if (count(mid)) {
                ret = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ret;
    }
}
