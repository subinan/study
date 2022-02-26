import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] sNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열 정렬
        Arrays.sort(sNumbers, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        String answer = "";
        for (int i = 0; i < numbers.length; i++) {
            answer += sNumbers[i];
        }
        
        // 0 예외처리
        if (answer.charAt(0) == '0') {
            answer = "0";
        }
        return answer;
    }
}
