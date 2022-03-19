class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        int width, height;
        for (int[] s : sizes) {
            width = Math.max(s[0], s[1]);
            height = Math.min(s[0], s[1]);
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxWidth * maxHeight;
    }
}
