class Solution {
    public String getMap(int n, int m1, int m2) {
        char[] map = new char[n];
        char[] element = { ' ', '#' };
        int r;
        
        int idx = n;
        while (idx > 0) {
            if (m1 > 0 || m2 > 0) {
                r = m1 % 2 + m2 % 2 > 0 ? 1 : 0;
                map1[--idx] = element[r];
                m1 /= 2;
                m2 /= 2;
            } else {
                map1[--idx] = element[0];
            }
        }
        return String.valueOf(map);
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            answer[i] = getMap(n, arr1[i], arr2[i]);
        }
        return answer;
    }
}
