import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        ArrayList<Integer> basket = new ArrayList<Integer>();
        int len;

        for(int m:moves) {
            --m;
            len = basket.size();
            for (int i = 0; i < n; i++) {
                if (len > 0 && basket.get(len - 1) == board[i][m]) {
                    answer += 2;
                    basket.remove(len - 1);
                    board[i][m] = 0;
                    break;
                }
                else if (board[i][m] != 0) {
                    basket.add(board[i][m]);
                    board[i][m] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
