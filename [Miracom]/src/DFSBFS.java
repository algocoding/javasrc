
// DFS-BFS https://www.acmicpc.net/problem/1260
import java.util.*;

public class DFSBFS {

	static Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	static boolean[] visit = new boolean[1001];
	static int N, M, s;

	static void DFS(int v) {
		visit[v] = true;
		System.out.print(v + " ");
		List<Integer> list = map.get(v);
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
			List<Integer> list = map.get(v);
			for (int u : list) {
				if (visit[u] == false) {
					Q.add(u);
					visit[u] = true;
					System.out.print(u + " ");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점수
		M = sc.nextInt(); // 간선수
		s = sc.nextInt(); // 시작 정점

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			List<Integer> list = map.get(u);
			if (list == null) {
				list = new LinkedList<Integer>();
				list.add(v);
				map.put(u, list);
			} else {
				boolean flag = true;
				for (int val : list)
					if (val == v) {
						flag = false;
						break;
					}
				if (flag)
					list.add(v);

			}

			list = map.get(v);
			if (list == null) {
				list = new LinkedList<Integer>();
				list.add(u);
				map.put(v, list);
			} else {
				boolean flag = true;
				for (int val : list)
					if (val == u) {
						flag = false;
						break;
					}
				if (flag)
					list.add(u);
			}
		}

		DFS(s);
		System.out.println();
		BFS(s);

		sc.close();
	}
}
