class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 0;
        int r;
        
        int tmp = n;
        while (tmp > 0) {
            tmp /= 3;
            ++idx;
        }

        while (n > 0) {
            r = n % 3;
            n /= 3;
            --idx;
            answer += (r * Math.pow(3, idx));
        }
        return answer;
    }
}
