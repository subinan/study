class Solution {
    public String solution(String s, int n) {
        char[] str = s.toCharArray();
        
        for (int i = 0; i < str.length; i++) {
            if ('A' <= str[i] && str[i] <= 'Z') {
                str[i] = (char)('A' + (str[i] - 'A' + n) % 26);
            } else if ('a' <= str[i] && str[i] <= 'z') {
                str[i] = (char)('a' + (str[i] - 'a' + n) % 26);
            }
        }
        return String.valueOf(str);
    }
}
