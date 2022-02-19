import java.util.*;
import java.lang.*;
import java.util.Map.Entry;

class Solution {
    HashMap<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
        // 문자열 오름차순 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        for (int c : course) {
            map = new HashMap<>();
            for (String order : orders) {
                combi(new StringBuilder(), order, 0, 0, c);
            }
            
            int max = 0;
            for (Entry<String, Integer> entry : map.entrySet()) {
                 max = Math.max(max, entry.getValue());
            }
        
            if (max == 1) {
                continue;
            }
            
            for (Entry<String, Integer> entry : map.entrySet()) {
                if (max == entry.getValue()) {
                    answer.add(entry.getKey());
                }
            }
        
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }

    public void combi(StringBuilder sb, String str, int cnt, int idx, int n) {      
        if (cnt == n) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for (int i = idx; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combi(sb, str, cnt + 1, i + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }
}

//https://fbtmdwhd33.tistory.com/249
