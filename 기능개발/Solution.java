import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int len = progresses.length;
        int[] day = new int[len];
        for (int i = 0; i < len; i++) {
            day[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int max = day[0], count = 0;
        for (int i = 1; i < len; i++) {
            if (max >= day[i]) {
                count++;
            } else {
                max = day[i];
                answer.add(count + 1);
                count = 0;
            }
        }
        answer.add(count + 1);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
