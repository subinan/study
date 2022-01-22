class Solution {
    public String solution(int a, int b) {
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        for (int i = 1; i < month.length; i++) {
            month[i] = (month[i] + month[i - 1]) % 7;
        }
        
        return day[(month[a - 1] + b - 1) % 7];
    }
}
