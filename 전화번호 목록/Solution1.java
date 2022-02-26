// 해시맵 사용
// https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A0%84%ED%99%94%EB%B2%88%ED%98%B8-%EB%AA%A9%EB%A1%9D-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. HashMap을 선언한다.
        Map<String, Integer> map = new HashMap<>();
        
        // 2. 모든 전화번호를 HashMap에 넣는다.
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        
        // 3. 모든 전화번호의 substring이 HashMap에 존재하는지 확인한다.
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}

