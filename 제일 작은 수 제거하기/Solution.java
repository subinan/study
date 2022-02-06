class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        int idx = 0;
        int min = Integer.MAX_VALUE;
        
        if (arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[arr.length - 1];
            for (int n : arr) {
                if (min > n) {
                    min = n;
                }
            }
            for (int n : arr) {
                if (n != min) {
                    answer[idx] = n;
                    idx++;
                }
            }
        }
        return answer;
    }
}
