class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        int match = 0;
        int zero = 0;
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        for (int i = 0; i < 6; i++)
        { 
            for (int j = 0; j < 6; j++)
            {
                if (lottos[i] == win_nums[j])
                    ++match;
            }
            if (lottos[i] == 0)
                ++zero;
        }
        
        answer[0] = rank[match + zero];
        answer[1] = rank[match];
        return answer;
    }
}
