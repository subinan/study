import java.util.*;

public class Solution { 
    public int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
    
        return ret;
    }
    
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> ans = new ArrayList<>();
        int prev = -1;
        
        for (int n : arr) {
            if (prev == n) {
                continue;
            }
            ans.add(n);
            prev = n;
        }
        return convertIntegers(ans);
    }
}
