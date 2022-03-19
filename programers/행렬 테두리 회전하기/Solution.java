class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows + 1][columns + 1];
        int value = 1;
        
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                board[i][j] = value++;
            }
        }
        
        int idx = 0;
        for (int[] query : queries) {
            int tmp = board[query[0]][query[1]];
            int min = tmp;
            
            // left
            for (int i = query[0] + 1; i <= query[2]; i++) {
                board[i - 1][query[1]] = board[i][query[1]];
                min = Math.min(min, board[i][query[1]]);
            }
            // bottom
            for (int i = query[1] + 1; i <= query[3]; i++) {
                board[query[2]][i - 1] = board[query[2]][i];
                min = Math.min(min, board[query[2]][i]);
            }
            // right
            for (int i = query[2] - 1; i >= query[0]; i--) {
                board[i + 1][query[3]] = board[i][query[3]];
                min = Math.min(min, board[i][query[3]]);
            }
            // top
            for (int i = query[3] - 1; i >= query[1]; i--) {
                board[query[0]][i + 1] = board[query[0]][i];
                min = Math.min(min, board[query[0]][i]);
            }
            board[query[0]][query[1] + 1] = tmp;
            answer[idx++] = min;
        }
        return answer;
    }
}
