import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int priority : priorities) {
            pq.add(priority);
        }
        
        int answer = 1; // 출력 순번
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                // 중요도가 가장 높은 문서 위치 찾기
                if (pq.peek() == priorities[i]) {
                    // location 위치일 경우 현재 출력 순번 리턴
                    if (i == location) { 
                        return answer;
                    }
                    // location 위치가 아닐 경우 출력 순번 증가, 다음 중요도 체크
                    answer++;
                    pq.poll();
                }
            }
        }
        return answer;
    }
}
