/*
 * A ~ G 까지의 정점을 1 ~ 7로 표기
입력> 7(정점수), 11(간선수)
-----------------------------------------
7 11 
1 2 3
1 3 17
1 4 6
2 4 5
2 7 12
3 5 10
3 6 8 
4 5 9
5 6 4
5 7 2
6 7 14 
-----------------------------------------
*/
package Day02;
import java.util.*;

public class MSTPrimPQ {
	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 트리에 포함된 정점들 표시
	static int[] D;				// 간선의 가중치 저장
	static int[] P; 			// 최소 신장 트리 저장(간선 정보 저장)	
	static int V, E;			// 정점수, 간선수
	
	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex>{
		int id;		// 정점 번호
		int key;	// 트리와 정점의 거리
		Vertex(int a, int b) {
			id = a; key = b; 
		}
		public int compareTo(Vertex arg) {
			if(key == arg.key)
				return id - arg.id;
			else return key - arg.key;
		}
	}
	public static int mst_prim(int s)	//  s: 시작점
	{									// MST 가중치합 반환 
		
		for(int i = 1; i <= V; i++)
		{
			D[i] = 0xfffff;
			P[i] = i;
		}
		D[s] = 0;	// 시작점 D[] 초기화
		
		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();		
		Q.add(new Vertex(s, D[s])); // 시작점 PQ에 삽입
		
		int ret = 0;		
		while(!Q.isEmpty())
		{
			Vertex v = Q.poll();		// 트리에서 가장 가까운 정점 가져오기
										// v 정점은 트리에 포함된다.
			if(visited[v.id]) continue;	// 이미 포함된 정점은 제거
			
			ret += D[v.id];				
			visited[v.id] = true;		// 정점 v가 트리에 포함됨.
			
			for(int i = 1; i <= V; i++)
			{
				if(G[v.id][i] != 0 && visited[i] == false && G[v.id][i] < D[i])
				{
					D[i] = G[v.id][i];
					P[i] = v.id;
					Q.add(new Vertex(i, D[i]));
				}
			}
		}
		return ret;
	}	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		// 필요한 저장 공간 생성 
		G = new int[V + 1][V + 1];
		visited = new boolean[V + 1];
		D = new int[V + 1];
		P = new int[V + 1];
		
		int u, v, w;		// 간선(u,v), 가중치 w
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();				
			G[u][v] = G[v][u] = w;
		}
		for(int i = 1; i <= V; i++)
		{
			for(int j = 1; j <= V; j++)
				System.out.printf("%2d ",G[i][j]);
			System.out.println();
		}
		System.out.println("MST 가중치 합> " + mst_prim(1));
		printResult();
		sc.close();		
	}
	public static void printResult()
	{
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", i);
		System.out.printf("\n-------------------------------\n");
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", P[i]);
		System.out.println();
		for(int i = 1; i <= V; i++)
			System.out.printf("%2d ", D[i]);		
		 
	}
}
