class Solution {
    public int solution(int[] numbers) {
        int ans = 0;
        int add = 0;
        
        for(int n:numbers)
            add += n;
        ans = 45 - add;
        return ans;
    }
}
