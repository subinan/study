import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        
        // 두 글자씩 끊어서 다중집합의 원소로 만들기
        char c1, c2;
        for (int i = 1; i < str1.length(); i++) {
            c1 = str1.charAt(i - 1);
            c2 = str1.charAt(i);
            if ('a' <= c1 && c1 <= 'z' && 'a' <= c2 && c2 <= 'z') {
                arr1.add(c1 + "" + c2);
            }
        }
        
        for (int i = 1; i < str2.length(); i++) {
            c1 = str2.charAt(i - 1);
            c2 = str2.charAt(i);
            if ('a' <= c1 && c1 <= 'z' && 'a' <= c2 && c2 <= 'z') {
                arr2.add(c1 + "" + c2);
            }
        }
        
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();
        
        // 교집합 구하기
        for (String s : arr1) {
            if (arr2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }
        
        // 합집합 구하기
        for (String s : arr2) {
            union.add(s);
        }
        
        // 자카드 유사도 구하기
        double a = intersection.size();
        double b = union.size();
        if (b == 0) {
            return 65536;
        }
        return (int)(a / b * 65536.0);
    }
}
