/*
입력> 6(정점수), 8(간선수)
정점 번호는 0 ~ 5 까지
-----------------------------------------
6 8
0 1
0 2
1 3
1 4
2 3
2 4
3 5
4 5
-----------------------------------------
*/
package Day02;
import java.util.*;

public class TopoSortDFSDemo {
	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 방문 정보
	static int[] indeg;			// 진입 차수
	static int[] order;			// 정렬된 정점 순서 저장
	static int idx = -1;		// order[]에 저장된 마지막 자료의 위치
	static int V, E;			// 정점수, 간선수
	
	public static void printOrder()
	{
		for(int i = idx; i >= 0; i--)
			System.out.printf("%d ", order[i]);
		System.out.printf("\n");
	}
	public static void dfs(int v)
	{
		visited[v] = true;		
		for(int i = 0; i < V; i++)
		{
			if(G[v][i] == 1 && visited[i] == false)
				dfs(i);
		}
		order[++idx] = v;		// 이전 정점으로 돌아갈 때 저장
	}
	public static void solve_dfs()
	{
		for(int i = 0; i < V; i++)
		{
			if(indeg[i] == 0)	// 진입 차수 0인 정점을 시작점으로
				dfs(i);			// 깊이 우선 탐색 
		}
		printOrder(); 
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
				
		V = sc.nextInt();
		E = sc.nextInt();
		G = new int[V][V];		// 정점 번호는 0 ~ (V-1)
		visited = new boolean[V];	
		indeg = new int[V];
		order = new int[V];
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
							
			G[u][v] = 1;
			indeg[v]++;
		}
		solve_dfs();
		sc.close();
		
	}
}
