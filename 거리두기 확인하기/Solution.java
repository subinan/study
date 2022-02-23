import java.util.LinkedList;
import java.util.Queue;

class Solution {
 final int N = 5;
 String[] Map;
 Queue<int[]> Q;

 int[] dy = { 0, 0, -1, 1 };
 int[] dx = { 1, -1, 0, 0 };

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            Map = places[i];
            answer[i] = solve();
        }
        return answer;
    }

    public int solve() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (Map[y].charAt(x) == 'P') {
                    if (!bfs(y, x)) return 0;
                }
            }
        }
        return 1;
    }

    public boolean bfs(int y, int x) {
        Q = new LinkedList<>();
        Q.add(new int[] { y, x, 0 });

        while (!Q.isEmpty()) {
            int[] curr = Q.poll();

            if (curr[2] == 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = curr[0] + dy[i];
                int nx = curr[1] + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || (ny == y) && (nx == x)) {
                    continue;
                }

                if (Map[ny].charAt(nx) == 'P') {
                    return false;
                } else if (Map[ny].charAt(nx) == 'O' && curr[2] < 2) {
                    Q.add(new int[] { ny, nx, curr[2] + 1 });
                }
            }
        }
        return true;
    }
}
