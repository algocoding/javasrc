import java.util.*;

public class DFSBFS2 {
	static ArrayList<ArrayList<Integer>> adjList;
	static boolean[] visit = new boolean[1001];
	static int N, M, s;

	static void DFS(int v) {
		visit[v] = true;
		System.out.print(v + " ");

		ArrayList<Integer> list = adjList.get(v);
		for (int u : list) {
			if (visit[u] == false)
				DFS(u);
		}
	}

	static void BFS(int v) {
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(v);
		visit[v] = true;
		System.out.print(v + " ");

		while (!Q.isEmpty()) {
			v = Q.poll();

			ArrayList<Integer> list = adjList.get(v);
			for (int u : list) {
				if (visit[u] == false) {
					Q.add(u);
					visit[u] = true;
					System.out.print(u + " ");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점수
		M = sc.nextInt(); // 간선수
		s = sc.nextInt(); // 시작 정점

		adjList = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		DFS(s);
		System.out.println();
		BFS(s);
		System.out.println();
		sc.close();
	}
}
