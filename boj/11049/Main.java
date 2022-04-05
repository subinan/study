// https://velog.io/@turtle601/%EB%B0%B1%EC%A4%80-%ED%96%89%EB%A0%AC-%EA%B3%B1%EC%85%88-%EC%88%9C%EC%84%9C-11049%EB%B2%88
// https://cocoon1787.tistory.com/318

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix, dp;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        dp = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int x;
        for (int i = 1 ; i < N; i++) {
            for (int j = 0; i + j < N; j++) {
                x = i + j;
                dp[j][x] = INF;
                for (int k = j; k < x; k++) {
                    dp[j][x] = Math.min(dp[j][x], dp[j][k] + dp[k + 1][x] + matrix[j][0] * matrix[k][1] * matrix[x][1]);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
