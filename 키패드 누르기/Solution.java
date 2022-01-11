class Solution {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int[] cur = {3, 3};
		int[] flag = {0, 0}; // check center -> 이동횟수 -1
		char[] alpha = {'R', 'L'};
		int idx;
		int move_l, move_r;

		for (int n:numbers)
		{
			if (n == 0)
				n = 11;
			idx = n % 3;
			if (idx == 2)
			{
				move_l = Math.abs(cur[1] - n / 3) + 1 - flag[1];
				move_r = Math.abs(cur[0] - n / 3) + 1 - flag[0];       
				idx = move_l > move_r ? 0 : (move_l == move_r && hand.equals("right") ? 0 : 1);
				flag[idx] = 1;
			}
			else
				flag[idx] = 0;
			cur[idx] = (n % 3 == 0) ? n / 3 - 1 : n / 3;
			answer += alpha[idx];
		}
		return answer;
	}
}
