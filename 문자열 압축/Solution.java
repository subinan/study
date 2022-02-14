import java.util.*;

class Solution {
    // split 참고 코드: https://javaiyagi.tistory.com/470
    public List<String> split(String s, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            if (i % n == 0) {
                int end = i + n < s.length() ? i + n : s.length();
                list.add(s.substring(i, end));
            }
        }
        return list;
    }
    
    public static int getDigit(int n) {
        int ret = 1;
        
        while (n > 9) {
            n /= 10;
            ret++;
        }
        return ret;
    }
    
    public int solution(String s) {
        int answer = s.length();
        List<String> list;
        int count, compress;
        
        for (int i = 1; i <= s.length() - i; i++) {
            list = split(s, i);
            count = 0;
            compress = 1;
            
            for (int j = 0; j < list.size(); j++) {
                String prev = list.get(j);
                String curr = "";
                if (j + 1 < list.size()) {
                    curr = list.get(j + 1);
                }
                
                if (prev.equals(curr)) {
                    compress++;
                } else {
                    count += prev.length();
                    if (compress > 1) {
                        count += getDigit(compress);
                    }
                    compress = 1;
                }
            }
            answer = Math.min(answer, count);
        }
        return answer;
    }
}
