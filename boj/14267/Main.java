// https://loosie.tistory.com/514

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] adj;
	static int[] wv;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			adj[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int a = 1; a <= n; a++) {
			int b = Integer.parseInt(st.nextToken());
			if(b != -1) {
				adj[b].add(a);
			}
		}
		
		wv = new int[n + 1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int man = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			wv[man] += w;
			
		}
		
		dfs(1);
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < n + 1; i++) {
			sb.append(wv[i] + " ");
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int idx) {
		for (int nxt : adj[idx]) {
			wv[nxt] += wv[idx];
			dfs(nxt);
		}
	}
}
