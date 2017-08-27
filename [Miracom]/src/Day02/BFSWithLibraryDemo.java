/*
입력> 7(정점수), 8(간선수)
-----------------------------------------
7 8
1 2 
1 3 
2 4 
2 5 
3 7 
4 6 
5 6 
6 7 
-----------------------------------------
*/
package Day02;

import java.util.*;

public class BFSWithLibraryDemo {

	static ArrayList<Integer>[] G;			// 인접 리스트
	static boolean[] visited;	// 방문 정보
	static int V, E;			// 정점수, 간선수
	static void BFS(int v)
	{
		visited = new boolean[V + 1];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		visited[v] = true; System.out.print(v + " ");
		Q.add(v);
		
		while(!Q.isEmpty())
		{
			v = Q.poll();
			for(int w: G[v])
			{
				if(visited[w] == false)
				{
					visited[w] = true; System.out.print(w + " ");
					Q.add(w);
				}
			}
		}
	}	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		V = sc.nextInt();
		E = sc.nextInt();
		
		// 인접 리스트 생성하기
		G = new ArrayList[V + 1];
		for(int i = 0; i <= V; i++)
			G[i] = new ArrayList<Integer>();
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();			
			G[u].add(v);
			G[v].add(u);
		}
		BFS(1);
		sc.close();		
	}	

}
