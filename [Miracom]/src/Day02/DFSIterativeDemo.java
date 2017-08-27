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

import java.util.Scanner;
import java.util.Stack;

public class DFSIterativeDemo {

	static int[][] G;			// 인접 행렬
	static boolean[] visited;	// 방문 정보
	static int V, E;			// 정점수, 간선수
	
	public static void DFS_iter1(int v)
	{
		visited = new boolean[100];
		Stack<Integer> S = new Stack<Integer>();
		
		visited[v] = true;			// 시작점 방문
		System.out.print(v + " ");
		S.push(v);	
		
		while(!S.isEmpty()) 
		{
			int i;
			for(i = 1; i <= V; i++)
			{
				if(G[v][i] == 1 && visited[i] == false)
				{
					v = i;
					visited[i] = true;
					System.out.print(v + " ");
					S.add(v);
					break;
				}
			}
			if(i > V) v = S.pop();
		}
	}
	public static void DFS_iter2(int v)
	{
		visited = new boolean[100];
		int[] stack = new int[V + 1];
		int top = -1;
		
		stack[++top] = v;
		
		while(top != -1) 
		{
			v = stack[top--];
			
			if(visited[v] == false)
			{
				visited[v] = true; 
				System.out.print(v + " ");
				
				for(int i = 1; i <= V; i++)
				{
					if(G[v][i] == 1 && visited[i] == false)					
						stack[++top] = i;				
				}
			}			
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
			
		V = sc.nextInt();
		E = sc.nextInt();
		
		G = new int[V + 1][V + 1];		
		
		int u, v;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			
			G[u][v] = G[v][u] = 1;
		}
		DFS_iter2(1);
		sc.close();		
	}

}
