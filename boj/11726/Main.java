import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        DP = new int[N + 1];

        DP[0] = 1;
        DP[1] = 1;
        for (int i = 2; i <= N; i++) {
            // 2*(n-1) 타일의 앞에 2*1 한 개 붙이는 경우
            // +
            // 2*(n-2) 타일의 앞에 1*2 두 개 붙이는 경우
            DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
        }

        System.out.println(DP[N]);
    }
}
