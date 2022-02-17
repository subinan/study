import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int answer = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        return answer;
    }
}
