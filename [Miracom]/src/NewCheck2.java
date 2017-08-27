
// 미확인 도착지 https://www.acmicpc.net/problem/9370
import java.util.*;

public class NewCheck2 {
	static Map<Integer, List<Vertex>> adjList;
	static int[] D = new int[2001];
	static int[] P = new int[2001];

	static int T, N, M;
	static int s, g, h;

	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex> {
		int v; // 정점
		int d; // 가중치 또는 거리

		Vertex(int a, int b) {
			v = a;
			d = b;
		}

		public String toString() {
			return "(" + v + "/" + d + ")";
		}

		public int compareTo(Vertex arg) {
			return d - arg.d;
		}
	}

	// 다익스트라 + 우선순위 큐
	public static void dijkstra(int v) {
		for (int i = 1; i <= N; i++) {
			D[i] = 0xfffffff;
			P[i] = i;
		}
		D[v] = 0;

		PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();
		PQ.add(new Vertex(v, D[v]));

		while (!PQ.isEmpty()) {
			Vertex from = PQ.poll();
			if (from.d > D[from.v])
				continue;

			List<Vertex> list = adjList.get(from.v);

			for (Vertex to : list) {
				if (D[to.v] > D[from.v] + to.d) {
					D[to.v] = D[from.v] + to.d;
					P[to.v] = from.v;
					PQ.add(new Vertex(to.v, D[to.v]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		while (tc-- > 0) {
			N = sc.nextInt(); // 교차로 수
			M = sc.nextInt(); // 도로 수
			T = sc.nextInt(); // 목적지 후보 수

			s = sc.nextInt(); // 출발점
			g = sc.nextInt(); // 경로상 간선의 한 정점
			h = sc.nextInt(); // 경로상 간선의 한 정점

			adjList = new HashMap<Integer, List<Vertex>>(); // 인접 리스트
			int from, to, weight;
			for (int i = 0; i < M; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();

				List<Vertex> list = adjList.get(from);
				if (list == null) {
					list = new LinkedList<Vertex>();
					list.add(new Vertex(to, weight));
					adjList.put(from, list);
				} else
					list.add(new Vertex(to, weight));

				list = adjList.get(to);
				if (list == null) {
					list = new LinkedList<Vertex>();
					list.add(new Vertex(from, weight));
					adjList.put(to, list);
				} else
					list.add(new Vertex(from, weight));
			}
			ArrayList<Integer> cand = new ArrayList<Integer>();

			for (int i = 0; i < T; i++)
				cand.add(sc.nextInt());

			dijkstra(s);

			Collections.sort(cand);

			for (int i : cand) {
				int cur = i;
				while (cur != s) {
					if ((cur == g && P[cur] == h) || (cur == h && P[cur] == g)) {
						System.out.print(i + " ");
						break;
					}
					cur = P[cur];
				}
			}

			System.out.println();
		}
		sc.close();
	}
}