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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopoSortDegreeDemo {
	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 방문 정보
	static int[] indeg;			// 진입 차수
	static int V, E;			// 정점수, 간선수
	
	public static void solve_degree()
	{
		Queue<Integer> Q = new LinkedList<Integer>();
		
		for(int i = 0; i < V; i++)		
			if(indeg[i] == 0) Q.add(i); // 진입 차수 0인 정점 큐에 저장
		
		while(!Q.isEmpty())
		{
			int v = Q.poll();
			
			System.out.print(v + " ");
			
			for(int i = 0; i < V; i++)	// 인접 정점의 진입 차수 차감
			{
				if(G[v][i] == 1 && indeg[i] != 0)
				{
					indeg[i]--;
					if(indeg[i] == 0) Q.add(i);	// 진인 차수가 0이 되면 큐에 저장
				}
			}
		}
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
				
		V = sc.nextInt();
		E = sc.nextInt();
		G = new int[V][V];	// 정점 번호 0 ~ (V-1)
		visited = new boolean[V];
		indeg = new int[V];
		
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
							
			G[u][v] = 1;
			indeg[v]++;
		}
		solve_degree();
		sc.close();
		
	}
}
