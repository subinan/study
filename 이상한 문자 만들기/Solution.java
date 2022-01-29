class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        int cnt = 0;
        
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                cnt = -1;
            } else {
                str[i] = cnt % 2 == 0 ? Character.toUpperCase(str[i]) : Character.toLowerCase(str[i]);
            }
            ++cnt;
        }

        return String.valueOf(str);
    }
}
