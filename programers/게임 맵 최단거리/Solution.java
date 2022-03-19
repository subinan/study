import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dr = {0, 0, 1, -1}, dc = {1, -1, 0, 0};
    int[][] map;
    boolean[][] visited;
    int R, C;

    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        map = maps;
        visited = new boolean[R][C];

        return bfs();
    }

    public int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int r = q.peek()[0];
            int c = q.peek()[1];
            int dis = q.peek()[2];
            q.poll();

            if (r == R - 1 && c == C - 1) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc, dis + 1 });
                }
            }
        }
        return -1;
    }
}
