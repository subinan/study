class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        for ( ; n > 1; n -= 2) {
            sb.append("수박");
        }
        
        if (n == 1) {
            sb.append("수");
        }
        
        return sb.toString();
    }
}
