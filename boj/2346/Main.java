// http://daplus.net/java-arraydeque%EA%B0%80-linkedlist%EB%B3%B4%EB%8B%A4-%EB%82%98%EC%9D%80-%EC%9D%B4%EC%9C%A0/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Deque<Info> dq;

    public static class Info {
        int idx;
        int input;

        Info(int idx, int input) {
            this.idx = idx;
            this.input = input;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        dq = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            dq.add(new Info(i, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        Info info = new Info(0, 0);
        while (dq.size() > 1) {
            if (info.input >= 0) {
                info = dq.removeFirst();
            } else {
                info = dq.removeLast();
            }
            sb.append(info.idx + " ");
            for (int i = 1; i < Math.abs(info.input); i++) {
                if (info.input >= 0) {
                    dq.offerLast(dq.removeFirst());
                } else {
                    dq.offerFirst(dq.removeLast());
                }
            }
        }
        sb.append(dq.pop().idx);
        System.out.println(sb.toString());
    }
}



// https://ltk3934.tistory.com/222?category=906235
//while (dq.size() > 1) {
//    Info info = dq.poll();
//    sb.append(info.idx).append(" ");
//
//    int move = info.input;
//    if (move < 0) {
//        while (move++ < 0) {
//            dq.addFirst(dq.pollLast());
//        }
//    } else {
//        while (--move > 0) {
//            dq.addLast(dq.pollFirst());
//        }
//    }
//}
