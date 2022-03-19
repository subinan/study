import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        for (int i : d) {
            if (i <= budget) {
                budget -= i;
                ++answer;
            }
        }
        return answer;
    }
}
