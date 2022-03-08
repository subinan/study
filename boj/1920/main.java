import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        int find, low, high, mid;
        Boolean findAns;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            find = Integer.parseInt(st.nextToken());
            low = 0;
            high = N - 1;
            findAns = false;
            while (low <= high) {
                mid = (low + high) / 2;
                if (A[mid] == find) {
                    findAns = true;
                    break;
                } else if (A[mid] < find) {
                    low = mid + 1;
                } else if (A[mid] > find) {
                    high = mid - 1;
                }
            }
            if (findAns)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
