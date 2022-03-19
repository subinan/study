class Solution {
    static int[] Num;
    static int N, T, answer;
    
    public int solution(int[] numbers, int target) {
        Num = numbers;
        N = numbers.length;
        T = target;
        
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == T) {
                answer++;
            }
            return;
        }
        
        dfs(idx + 1, sum + Num[idx]);
        dfs(idx + 1, sum - Num[idx]);
    }
}
