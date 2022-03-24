import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static String p;
    static Deque<Integer> dq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            dq = new LinkedList<>();
            for (int i = 0; i < n; i++)
                dq.add(Integer.parseInt(st.nextToken()));
            AC();
        }

        System.out.print(sb.toString());
    }

    public static void AC() {
        boolean flag = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R')
                flag = !flag;
            else if (p.charAt(i) == 'D') {
                if (flag) {
                    if (dq.pollFirst() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
                else {
                    if (dq.pollLast() == null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        // print
        sb.append('[');
        while (dq.size() > 1) {
            if (flag) {
                sb.append(dq.pollFirst()).append(',');
            } else {
                sb.append(dq.pollLast()).append(',');
            }
        }
        if (dq.size() > 0) {
            if (flag) {
                sb.append(dq.pollFirst()).append("]\n");
            } else {
                sb.append(dq.pollLast()).append("]\n");
            }
        } else
            sb.append("]\n");
    }
}
