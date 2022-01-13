class Solution {
    public int solution(int[] numbers) {
        int[] chk = new int[10];
        int ans = 0;
        
        for(int n:numbers)
            ++chk[n];
        
        for (int i = 0; i < 10; i++)
            ans += (chk[i] == 0 ? i : 0);
        
        return ans;
    }
}
