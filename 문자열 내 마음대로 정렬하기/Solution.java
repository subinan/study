import java.util.Comparator;
import java.util.Arrays;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int comp1 = Integer.compare(o1.charAt(n), o2.charAt(n));
                if (comp1 == 0) {
                    return o1.compareTo(o2);
                }
                return comp1;
            }
        });
        
        return strings;
    }
}
