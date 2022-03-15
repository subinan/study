// https://toastfactory.tistory.com/206

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, ans;
    static int[] arr;
    static char[] ch;
    static char[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        ch = br.readLine().toCharArray();
        
        map = new char[N][N];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; i < N; j++) {
                map[i][j] = ch[idx++];
            }
        }
        
        arr = new int[N];
        dfs(0);
    }
    
    public static void dfs(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
            System.exit(0);
            return;
        }
        
        for (int j = -10; j <= 10; j++) {
            arr[cnt] = j;
            if (check(cnt)) {
                dfs(cnt + 1);
            }
        }
    }
    
    public static boolean check(int idx) {
        for (int i = 0; i < idx; i++) {
            int sum = 0;
            for (int j = i; j <= idx; j++) {
                sum += arr[j];
                if (map[i][j] != (sum == 0 ? '0' : (sum > 0 ? '+' : '-'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
