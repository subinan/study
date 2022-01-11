class Solution {
    public int solution(String s) {
        String[] num_alpha = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < 10; i++)
            s = s.replaceAll(num_alpha[i], num[i]);
        int answer = Integer.parseInt(s);
        return answer;
    }
}
