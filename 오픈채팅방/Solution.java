import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[0].charAt(0) == 'L') {
                continue;
            }
            map.put(split[1], split[2]);
        }
        
        ArrayList<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] split = r.split(" ");
            if (split[0].charAt(0) == 'E') {
                answer.add(map.get(split[1]) + "님이 들어왔습니다.");
            } else if (split[0].charAt(0) == 'L') {
                answer.add(map.get(split[1]) + "님이 나갔습니다.");
            } 
        }
        return answer.toArray(new String[answer.size()]);
    }
}
