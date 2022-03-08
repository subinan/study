// https://velog.io/@junhok82/lowerbound-upperbound

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {
    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());
            sb.append(upperBound(find) - lowerBound(find)).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int lowerBound(int find) {
        int low = 0;
        int high = N;

        while (low < high) {
            int mid = (low + high) / 2;
          
            if (A[mid] < find) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
  
    public static int upperBound(int find) {
        int low = 0;
        int high = N;

        while (low < high) {
            int mid = (low + high) / 2;
          
            if (A[mid] <= find) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }
}
