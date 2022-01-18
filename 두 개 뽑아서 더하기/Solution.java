class Solution {
    public int[] solution(int[] numbers) {
        Boolean[] chk = new Boolean[200];
        int len = numbers.length;
        int size = 0;
        int sum;
        
        for (int i = 0; i < 200; i++)
            chk[i] = false;
        
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                sum = numbers[i] + numbers[j];
                if (chk[sum] == false) {
                    ++size;
                    chk[sum] = true;
                }
            }
        }
        
        int[] answer = new int[size];
        int idx = 0;
        for (int i = 0; i < 200; i++)
        {
            if (chk[i] == true) {
                answer[idx] = i;
                ++idx;
            }
        }
        return answer;
    }
}
