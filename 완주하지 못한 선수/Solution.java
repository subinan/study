class Solution {
    public Boolean compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 != len2)
            return false;
        for (int i = 0; i < len1; i++)
            if (s1.charAt(i) != s2.charAt(i))
                   return false;
        return true;
    }
    public String solution(String[] participant, String[] completion) {
        Boolean []attend = new Boolean[100000];
        int len = completion.length;

        for (int i = 0; i < len; i++)
            attend[i] = false;
        for (String p:participant) {
            for (int i = 0; i < len; i++) {
                if (attend[i] == false && compare(p, completion[i])) {
                    attend[i] = true;
                    break;
                }
                if (i == len - 1)
                    return p;
            }
        }
        return "";
    }
}
