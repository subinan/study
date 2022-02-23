// https://girawhale.tistory.com/84

import java.util.*;

class Solution {
    int[] perm = new int[3]; // 우선순위 순열
    boolean[] visit = new boolean[3];
    Map<Character, Integer> priority = new HashMap<>();
    List<Long> numList = new ArrayList<>();
    List<Character> opList = new ArrayList<>();

    long answer = Integer.MIN_VALUE;

    public long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if ("+-*".contains(token)) opList.add(token.charAt(0));
            else numList.add(Long.parseLong(token));
        }
        
        permutation(0);
        return answer;
    }

    public void solve() {
        Stack<Long> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        numStack.push(numList.get(0));
        for (int i = 0, size = opList.size(); i < size; i++) {
            char op = opList.get(i);
            while (!opStack.isEmpty() && priority.get(opStack.peek()) >= priority.get(op)) {
                numStack.push(calc(numStack.pop(), numStack.pop(), opStack.pop()));
            }

            numStack.push(numList.get(i + 1));
            opStack.push(op);
        }

        while (numStack.size() > 1) {
            numStack.push(calc(numStack.pop(), numStack.pop(), opStack.pop()));
        }

        answer = Math.max(answer, Math.abs(numStack.pop()));
    }

    public void permutation(int idx) {
        if (idx == 3) {
            priority.put('+', perm[0]);
            priority.put('-', perm[1]);
            priority.put('*', perm[2]);

            solve();
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            perm[idx] = i;
            permutation(idx + 1);
            visit[i] = false;
        }
    }

    public long calc(long n1, long n2, char op) {
        if (op == '+') return n1 + n2;
        else if (op == '-') return n2 - n1;
        else return n1 * n2;
    }
}
