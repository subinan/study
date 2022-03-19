class Solution {
    public int[] solution(int N, int[] stages) {
        int len = stages.length;
        int[] ans = new int[N];
        double[] rate = new double[N];
        int clear;
        int tries;
        
        for (int i = 0; i < N; i++) {
            tries = 0;
            for (int j = 0; j < len; j++) {
                if (stages[j] >= i + 1)
                    ++tries;
            }
            clear = 0;
            for (int j = 0; j < len; j++) {
                if (stages[j] > i + 1)
                    ++clear;
            }
            ans[i] = i;
            rate[i] = (double)(tries - clear) / tries;
        }
        
        int tmp;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (rate[ans[i]] < rate[ans[j]]) {
                    tmp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = tmp;
                } else if (rate[ans[i]] == rate[ans[j]]) {
                    if (ans[i] > ans[j]) {
                        tmp = ans[i];
                        ans[i] = ans[j];
                        ans[j] = tmp;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++)
            ++ans[i];
        
        return ans;
    }
}
