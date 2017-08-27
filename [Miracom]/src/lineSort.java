
// 줄세우기 https://www.acmicpc.net/problem/2252
import java.util.*;

public class lineSort {

	static ArrayList<Integer>[] G;
	static boolean[] visit = new boolean[32001];
	static int[] indeg = new int[32001];

	static Stack<Integer> order = new Stack<Integer>();
	static int N, M, s;

	static void DFS(int v) {
		visit[v] = true;
		
		for (int u : G[v]) {
			if (visit[u] == false)
				DFS(u);
		}	
		order.push(v);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 학생수(정점수)
		M = sc.nextInt(); // 비교횟수(간선수)
		
		G = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			G[i] = new ArrayList<Integer>();
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			G[u].add(v);
			indeg[v]++;
		}

		for (int i = 1; i <= N; i++) {
			if (indeg[i] == 0)
				DFS(i);
		}

		while (!order.isEmpty())
			System.out.print(order.pop() + " ");
		System.out.println();
		sc.close();
	}
}
