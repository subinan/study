// https://st-lab.tistory.com/277

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);

        int low = 1; // 가능한 최소 거리
        int high = A[N - 1] - A[0] + 1; // 가능한 최대 거리

        while (low < high) {
            int mid = (low + high) / 2;
          
            if (getCount(mid) < C) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low - 1);
    }

    public static int getCount(int dis) {
      int count = 1;
      int prev = 0;

      for (int i = 1; i < N; i++) {
        if (A[i] - A[prev] >= dis) {
          prev = i;
          count++;
        }
      }
      return count;
    }
}
