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
        String ans = "";
        Boolean []exist = new Boolean[100000];
        int len = participant.length;

        for (int i = 0; i < len; i++)
            exist[i] = false;
        for (String c:completion) {
            for (int i = 0; i < len; i++) {
                if (exist[i] == false && compare(participant[i], c)) {
                    exist[i] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < len; i++)
            if (exist[i] == false)
                ans = participant[i];
        return ans;
    }
}
