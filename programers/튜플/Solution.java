// https://train-validation-test.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%ED%8A%9C%ED%94%8C-Java-%EC%9E%90%EB%B0%94

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(String s) {
        String[] set = s.replaceAll("[{}]", " ").trim().split(" , ");
        Arrays.sort(set, (a, b)->(a.length() - b.length()));
        Set<Integer> hs = new HashSet<>();

        int[] answer = new int[set.length];
        int idx = 0;
        for(String element : set){
            for(String num : element.split(",")){
                int n  = Integer.parseInt(num);
                if(!hs.contains(n)) {
                    hs.add(n);
                    answer[idx++] = n;
                }
            }
        }
        return answer;
    }
}
