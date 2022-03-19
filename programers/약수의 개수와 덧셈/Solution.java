class Solution {
    public int getDivisorCount(int n) {
        int ret = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n)
                ++ret;
            else if (n % i == 0)
                ret += 2;
        }
        return ret;
    }
    public int solution(int left, int right) {
        int answer = 0;
        int n;
        
        for (int i = left; i <= right; i++) {
            n = getDivisorCount(i);
            if (n % 2 == 0)
                answer += i;
            else
                answer -= i;
        }
        return answer;
    }
}
