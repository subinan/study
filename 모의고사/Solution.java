class Solution {
    public int[] get_ans(int[] crt) {
        int max = -1;
        int len = 0;

        for (int c:crt) {
            if (c > max) {
                max = c;
                len = 1;
            }
            else if (c == max)
                ++len;
        }

        int ans[] = new int[len];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (max == crt[i])
                ans[idx++] = i + 1;
        }
        return ans;
    }
    public int[] solution(int[] answers) {
        int[] rand_mark1 = {1, 2, 3, 4, 5};
        int[] rand_mark2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] rand_mark3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] crt = new int[3];
        int i = 0;
    
        for (int a:answers) {
            crt[0] += rand_mark1[i % 5] == a ? 1: 0;
            crt[1] += rand_mark2[i % 8] == a ? 1: 0;
            crt[2] += rand_mark3[i % 10] == a ? 1: 0;
            ++i;
        }
        return get_ans(crt);
    }
}
