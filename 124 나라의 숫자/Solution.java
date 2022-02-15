class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] base = { 1, 2, 4 };
        
        n--;
        while (n > 2) {
            sb.append(base[n % 3]);
            n /= 3;
            n--;
        }
        sb.append(base[n % 3]);
        
        return sb.reverse().toString();
    }
}
