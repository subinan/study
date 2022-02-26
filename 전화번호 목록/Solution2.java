// 트라이 사용

import java.util.Arrays;

class Solution {
    Trienode root = new Trienode();

    public class Trienode {
        Trienode[] children = new Trienode[10];
        boolean isEnd;

        boolean hasChild(char c) {
            return children[c - '0'] != null;
        }

        Trienode getChild(char c) {
            return children[c - '0'];
        }
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (String phone_number : phone_book) {
            if (insertTrieNode(phone_number)) {
                return false;
            }
        }
        return true;
    }

    public boolean insertTrieNode(String phone_number) {
        Trienode curr = root;

        int i;
        for (i = 0; i < phone_number.length(); i++) {
            if (!curr.hasChild(phone_number.charAt(i))) {
                curr.children[phone_number.charAt(i) - '0'] = new Trienode();
            }
            curr = curr.getChild(phone_number.charAt(i));
            if (curr.isEnd) {
                return true;
            }
        }
        curr.isEnd = true;

        if (curr.hasChild(phone_number.charAt(i - 1))) {
            return true;
        }
        return false;
    }
}
