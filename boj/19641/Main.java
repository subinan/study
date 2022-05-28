import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	static int N, root, cnt;
	static ArrayList<Integer>[] adj;
	static int[][] ans;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1]; // 인접 리스트
		ans = new int[N + 1][2];
		visit = new boolean[N + 1];
		StringTokenizer st;
		
		int a, b;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			adj[a] = new ArrayList<>();
			while (true) {
				b = Integer.parseInt(st.nextToken());
				if (b == -1) break;
				adj[a].add(b);
			}
			Collections.sort(adj[a]);
		}
		
		root = Integer.parseInt(br.readLine());
		cnt = 1;
		dfs(root);
		
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			sb.append(i + " " + ans[i][0]+ " " + ans[i][1] + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int node) {
		visit[node] = true;
		ans[node][0] = cnt++;

		for (int i = 0; i < adj[node].size(); i++) {
			if (!visit[adj[node].get(i)]) {
				dfs(adj[node].get(i));
			}
		}

		ans[node][1] = cnt++;
	}
}
