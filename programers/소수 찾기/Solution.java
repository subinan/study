class Solution {
    boolean[] isNotPrime;
    
    public void checkPrime(int n) {
        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
    
    public int solution(int n) {
        int answer = 0;
        
        isNotPrime = new boolean[n + 1];
        checkPrime(n);
        
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                ++answer;
            }
        }
        
        return answer;
    }
}
