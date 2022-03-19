import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int l = lost.length;
        int r = reserve.length;
        int answer = n - l;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        int i = 0;
        int idx = 0;
        while (i < l && idx < r) {
            if (reserve[idx] == lost[i]) {
                ++answer;
                ++idx;
                ++i;
            }
            else if (reserve[idx] - lost[i] == 1) {
                if (i + 1 < l && reserve[idx] == lost[i + 1])
                    ++i;
                else {
                    ++idx;
                    ++answer;
                    ++i;
                }
            }
            else if (reserve[idx] - lost[i] == -1) {
                if (idx + 1 < r && reserve[idx + 1] == lost[i])
                    ++idx;
                else {
                    ++idx;
                    ++answer;
                    ++i;
                }
            }
            else if (lost[i] < reserve[idx])
                ++i;
            else if (reserve[idx] < lost[i])
                ++idx;
        }
        return answer;
    }

}
