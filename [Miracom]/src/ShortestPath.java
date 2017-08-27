
// 최단 경로  https://www.acmicpc.net/problem/1753
import java.util.*;

public class ShortestPath {
	static int INF = 0xfffffff;
	static ArrayList<Vertex>[] G;
	static int[] D;
	static int[] P;
	static int N, M, S;

	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex> {
		int v; // 정점
		int d; // 가중치 또는 거리

		Vertex(int a, int b) {
			v = a; d = b;
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
			D[i] = INF;
		}
		D[v] = 0;
		//P[v] = v;

		PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();
		PQ.add(new Vertex(v, D[v]));

		while (!PQ.isEmpty()) {
			Vertex from = PQ.poll();
			
			if (from.d > D[from.v]) continue;
			
			
			for (Vertex to : G[from.v]) 
			{

				if (D[to.v] > D[from.v] + to.d) {
					D[to.v] = D[from.v] + to.d;
					// P[to.v] = from.v;
					PQ.add(new Vertex(to.v, D[to.v]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		S = sc.nextInt();

		G = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			G[i] = new ArrayList<Vertex>();
		
		D = new int[N + 1];
		P = new int[N + 1];
		
		int u, v, w;
		for (int i = 0; i < M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			
			G[u].add(new Vertex(v, w));
		}
		dijkstra(S);

		for (int i = 1; i <= N; i++)
			if (D[i] == INF)
				System.out.println("INF");
			else
				System.out.println(D[i]);

		sc.close();
	}
}