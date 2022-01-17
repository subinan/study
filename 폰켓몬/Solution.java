class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int []kinds = new int[200001];
        int cnt = 0;

        for (int num : nums) {
            if (kinds[num] == 0)
                ++cnt;
            ++kinds[num];
        }
        answer = cnt > nums.length / 2 ? nums.length / 2 : cnt;
        return answer;
    }
}
