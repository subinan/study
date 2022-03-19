class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int n = absolutes.length;

        for (int i = 0; i < n; i++)
            answer += (absolutes[i] * (signs[i] ? 1 : -1));
        return answer;
    }
}
