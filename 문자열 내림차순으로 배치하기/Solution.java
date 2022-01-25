import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] str = s.toCharArray();
        char[] ret = new char[s.length()];
        int idx = 0;
        
        Arrays.sort(str);
        for (int i = s.length() - 1; i >= 0; i--) {
            ret[idx++] = str[i];
        }
        return String.valueOf(ret);
    }
}
