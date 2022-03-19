// https://velog.io/@booorim98/BOJ-2504

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] input = st.nextToken().toCharArray();

        int ans = 0;
        int multiple = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case '(':
                    stack.push('(');
                    multiple *= 2;
                    break;
                case '[':
                    stack.push('[');
                    multiple *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        ans = 0;
                        break;
                    }
                    if (input[i - 1] == '(') {
                        ans += multiple;
                    }
                    stack.pop();
                    multiple /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        ans = 0;
                        break;
                    }
                    if (input[i - 1] == '[') {
                        ans += multiple;
                    }
                    stack.pop();
                    multiple /= 3;
                    break;

            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}
