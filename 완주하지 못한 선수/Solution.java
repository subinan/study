import java.util.Arrays;

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
        int len = completion.length;
        int i;

        Arrays.sort(participant); 
        Arrays.sort(completion);
        for (i = 0; i < len; i++)
            if (!compare(participant[i], completion[i]))
                break;
        return participant[i];
    }
}
