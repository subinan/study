import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static class Stack {
        private int[] stack = new int[10000];
        private int size = 0;

        void push(int n) {
            if (size < 10000) {
                stack[size++] = n;
            }
        }

        void pop() {
            if (size == 0) {
                sb.append("-1\n");
            } else {
                sb.append(stack[--size] + "\n");
            }
        }

        void size() {
            sb.append(size + "\n");
        }

        void empty() {
            if (size == 0) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        void top() {
            if (size == 0) {
                sb.append("-1\n");
            } else {
                sb.append(stack[size - 1] + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack stack = new Stack();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            if (s.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (s.equals("pop")) {
                stack.pop();
            } else if (s.equals("size")) {
                stack.size();
            } else if (s.equals("empty")) {
                stack.empty();
            } else if (s.equals("top")) {
                stack.top();
            }
        }

        System.out.print(sb.toString());
    }
}
