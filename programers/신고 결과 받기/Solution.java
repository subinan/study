import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 인덱스 해시맵
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }
        
        // 중복 제거하며 신고 카운트
        Set<String> set = new HashSet<>();
        int[] reported = new int[id_list.length];
        String[] s;
        for(String r : report) {
            if(!set.contains(r)) {
                set.add(r);
                s = r.split(" ");
                reported[map.get(s[1])]++;
            }
        }
        
        // 메일 수 카운트
        set.clear();
        int[] answer = new int[id_list.length];
        for (String r : report) {
            if(!set.contains(r)) {
                set.add(r);
                s = r.split(" ");
                if (reported[map.get(s[1])] >= k) {
                    answer[map.get(s[0])]++;
                }
            }
        }
        return answer;
    }
}
