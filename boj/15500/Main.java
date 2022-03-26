//https://velog.io/@cldhfleks2/15500

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static Stack<Integer> s1, s2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        s1 = new Stack<>();
        s2 = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            s1.push(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (K > 0) {
            while (!s1.isEmpty()) {
                if (s1.peek() == K) {
                    s1.pop();
                    sb.append("1 3\n");
                    K--;
                } else {
                    s2.push(s1.pop());
                    sb.append("1 2\n");
                }
                cnt++;
            }
            while (!s2.isEmpty()) {
                if (s2.peek() == K) {
                    s2.pop();
                    sb.append("2 3\n");
                    K--;
                } else {
                    s1.push(s2.pop());
                    sb.append("2 1\n");
                }
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.print(sb.toString());
    }
}
