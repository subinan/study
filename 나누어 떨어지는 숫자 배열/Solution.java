import java.util.*;

class Solution {
    public int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
    
        return ret;
    }
    
    public int[] solution(int[] arr, int divisor) {
        List<Integer> ret = new ArrayList<>();
        
        for (int n : arr) {
            if (n % divisor == 0) {
                ret.add(n);
            }
        }
        
        if (ret.size() == 0) {
            ret.add(-1);
        }
        Collections.sort(ret);
        
        return convertIntegers(ret);
    }
}
