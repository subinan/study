// https://jisunshine.tistory.com/175

import java.util.*;

class Solution {
    // 상우하좌 (상하좌우 시계방향으로)
    int R, C;
    int[] dr = { 1, 0, -1, 0 }, dc = { 0, 1, 0, -1 };
    boolean[][][] isVisited;
    
    public int[] solution(String[] grid) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        R = grid.length;
        C = grid[0].length();
        
        isVisited = new boolean[R][C][4];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int d = 0; d < 4; d++) {
                    if (!isVisited[i][j][d])
                        answer.add(moveLight(grid, i, j, d ));
                }
            }
        }
        
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
    
    public int moveLight(String[] grid, int r, int c, int d) {
        int cnt = 0; // 이동거리
        
        while (true) {
            if (isVisited[r][c][d]) break;
            
            cnt++;
            isVisited[r][c][d] = true;
            
            if (grid[r].charAt(c) == 'L') {
                d = (d + 3) % 4;
            } else if (grid[r].charAt(c) == 'R') {
                d = (d + 1) % 4;
            }
            
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        
        return cnt;
    }
}
