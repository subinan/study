class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] b = { ' ', 'S', 'D', 'T' };
        
        int prev = 0, curr = 0;
        for (int i = 0; i < dartResult.length(); ) {
            int score = 0, bonus = 0;
            // get score
            while ('0' <= dartResult.charAt(i) && dartResult.charAt(i) <= '9') {
                score *= 10;
                score += dartResult.charAt(i) - '0';
                ++i;
            }
            // get bonus
            for (int j = 1; j <= 3; j++) {
                if (b[j] == dartResult.charAt(i)) {
                    bonus = j;
                    ++i;
                    break;
                }
            }
            curr = (int)Math.pow(score, bonus);
            answer += curr;
            // get option
            if (i < dartResult.length() && dartResult.charAt(i) == '*') {
                answer += prev + curr; // 이전 점수와 현재 점수 더하기
                curr *= 2;
                ++i;
            }
            else if (i < dartResult.length() && dartResult.charAt(i) == '#') {
                answer -= 2 * curr; // 현재 점수 빼기 (이미 더했으니 *2)
                curr *= -1;
                ++i;
            }
            prev = curr;
            System.out.println(answer);
        }
        return answer;
    }
}
