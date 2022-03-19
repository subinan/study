import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();

        while (n > 9) {
            list.add((int)(n % 10));
            n /= 10;
        }
        list.add((int)n);
        
        long answer = 0;
        Collections.sort(list, Collections.reverseOrder());
        for (int num : list) {
            answer *= 10;
            answer += num;
        }
        return answer;
    }
}
