import java.util.*;


public class SecuritySystem {
	static Map<Integer, List<Vertex>> adjList;
	static int[] D = new int[201]; // 거리 저장
	static int[] P = new int[201]; // 최단 경로 트리
	static int[] E = new int[201];
	static int N, M;

	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex> {
		int v; // 정점
		int d; // 가중치 또는 거리

		Vertex(int a, int b) {
			v = a;
			d = b;
		}

		public String toString() {
			return v + " " + d + "\n";
		}

		public int compareTo(Vertex arg) {
			return d - arg.d;
		}
	}

	// 다익스트라 + 우선순위 큐
	public static void dijkstra(int v)
	{
		for(int i = 1; i <= N; i++)		
			D[i] = 0xffffff;			
		
		D[v] = E[v] = 0; P[v] = v;
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();		
		Q.add(new Vertex(v, D[v]));
		
		while(!Q.isEmpty())
		{
			Vertex from = Q.poll();
			if(from.d > D[from.v]) continue;
			
			List<Vertex> list = adjList.get(from.v);
			
			for(Vertex to: list)
			{
				if(D[to.v] > D[from.v] + to.d)
				{
					D[to.v] = D[from.v] + to.d;
					P[to.v] = from.v;
					Q.add(new Vertex(to.v, D[to.v]));
					
				}else if(D[to.v] == (D[from.v] + to.d) && E[to.v] > E[from.v] + 1)
					E[to.v] = E[from.v] + 1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

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
		dijkstra(1);

	}
}
