class Solution {
    public Boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;

        for (int i = 0; i < len - 2; i++)
            for (int j = i + 1; j < len - 1; j++)
                for (int k = j + 1; k < len; k++)
                    if (isPrime(nums[i] + nums[j] + nums[k]))
                        ++answer;
        return answer;
    }
}
