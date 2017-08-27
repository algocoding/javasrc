/* 입력>
------------------------
10 14
1 2 12 
1 3 15 
2 5 4 
2 6 10
3 4 21
3 7 7
4 8 25
5 6 3
5 9 13
6 7 10
7 8 19
7 10 9
8 10 5
9 10 15
------------------------
*/
package Day02;
import java.util.*;

public class ShortestPathDijkstra {
	static ArrayList<Vertex>[] G;	// 인접 행렬
	static int[] D;					// 거리 저장
	static int[] P;					// 최단 경로 트리 저장
	static int V, E;				// 정점수, 간선수
	
	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex>{
		int v;	// 정점 번호
		int d;	// 시작점에서 거리
		Vertex(int a, int b) {
			v = a; d = b; 
		}
		public int compareTo(Vertex arg) {			 
			return d - arg.d;
		}
		public String toString() {
			return v +" " + d + "\n";			
		}		
	}
	// 다익스트라 + 우선순위 큐
	public static void dijkstra(int v)
	{
		for(int i = 1; i <= V; i++)
			D[i] = 0xffffff;		// D[] 배열 초기화
		D[v] = 0; P[v] = v;
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();		
		Q.add(new Vertex(v, D[v]));
		
		while(!Q.isEmpty())
		{
			Vertex from = Q.poll();
			if(from.d > D[from.v]) continue;
			
			for(Vertex to: G[from.v])
			{
				if(D[to.v] > D[from.v] + to.d)
				{
					D[to.v] = D[from.v] + to.d;
					P[to.v] = from.v;
					Q.add(new Vertex(to.v, D[to.v]));
				}	
			}
		}
	}
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++)
			G[i] = new ArrayList<Vertex>();
		
		D = new int[V + 1];
		P = new int[V + 1];
		
		int u, v, w;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();				
			w = sc.nextInt();
			
			G[u].add(new Vertex(v, w));
			G[v].add(new Vertex(u, w));
		}			
		sc.close();
		
		System.out.println("최단 경로 - 다익스트라> ");		
		dijkstra(1); 
		printResult();		
	}
	// D[], P[] 배열 출력 하기
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", i);
		
		System.out.println("\n------------------------------------------");
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", D[i]);
		System.out.println("\n------------------------------------------");		
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", P[i]);		
		System.out.printf("\n");
	}	
		
}
