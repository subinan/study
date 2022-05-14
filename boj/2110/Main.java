// https://katfun.tistory.com/entry/백준-2110번-공유기-설치
// 집들 사이의 거리를 기준으로 이분 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(X);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int low = 1; // 두 집 사이의 거리 최솟값
        int high = X[N - 1] - X[0] + 1; // 두 집 사이의 거리 최댓값

        int ret = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (check(mid)) {
                ret = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ret;
    }

    public static boolean check(int dis) {
        int cnt = 1;
        int prev = 0;

        for (int i = 1; i < N; i++) {
            if (X[i] - X[prev] >= dis) {
                cnt++;
                prev = i;
            }
        }

        return (cnt >= C);
    }
}
