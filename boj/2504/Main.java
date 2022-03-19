import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();

        int mul = 1;
        int result = 0;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {

                case '(':
                    stack.push('(');
                    mul *= 2;
                    break;

                case '[':
                    stack.push('[');
                    mul *= 3;
                    break;

                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        result = 0;
                        flag = false;
                        break;
                    }

                    if (in.charAt(i - 1) == '(') result += mul;
                    stack.pop();
                    mul /= 2;
                    break;

                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        result = 0;
                        flag = false;
                        break;
                    }

                    if (in.charAt(i - 1) == '[') result += mul;
                    stack.pop();
                    mul /= 3;
                    break;
            }
        }

        System.out.println(!flag || !stack.isEmpty() ? 0 : result);
    }
}
