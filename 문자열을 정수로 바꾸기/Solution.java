class Solution {
    public int solution(String s) {
        int answer = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) != '+') {
                answer *= 10;
                answer += (s.charAt(i) - '0');
            }
        }
        return answer * sign;
    }
}
