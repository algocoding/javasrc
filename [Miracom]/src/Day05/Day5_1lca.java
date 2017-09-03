package Day05;
import java.util.*;

public class Day5_1lca {
	static int MAXN = 10000;
	static int V, E;		// 정점수, 간선수
	static int V1, V2;		// 두 노드
	static int[] P = new int[MAXN + 1]; // 부모 저장
	static int[] L = new int[MAXN + 1]; // 왼쪽 자식
	static int[] R = new int[MAXN + 1]; // 오른쪽 자식
	static int[] H = new int[MAXN + 1]; // 노드의 높이
	static int maxH, maxW;
	static int findLCA_recur(int v)
	{
		if(v == 0) return 0;
		if(v == V1 || v == V2) return v;
		
		int l = findLCA_recur(L[v]);
		int r = findLCA_recur(R[v]);
		if(l != 0 && r != 0) return v;
		
		return l != 0 ? l : r;
	}
	static int findLCA_iter()
	{
		boolean[] visited = new boolean[V + 1];
		int v1 = V1, v2 = V2;
		while (v1 != 0)
		{
			visited[v1] = true;
			v1 = P[v1];
		}
		while (v2 != 0)
		{
			if (visited[v2]) return v2;
			v2 = P[v2];
		}
		return -1;
	}
	static int treeHeight(int v, int h)
	{
		if(v == 0) return -1;
		
		H[h]++;		
		if(maxW < H[h]) maxW = H[h];
		
		int l = treeHeight(L[v], h + 1);
		int r = treeHeight(R[v], h + 1);
		
		return (l > r) ? l + 1: r + 1;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0)
		{
			V = sc.nextInt();
			E = sc.nextInt();
			
			V1 = sc.nextInt();
			V2 = sc.nextInt();
			for(int i = 0; i < E; i++)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				if(L[u] == 0) L[u] = v;
				else R[u] = v;
				P[v] = u;
			}
			//int lca = findLCA_iter();
			int lca = findLCA_recur(1);
			maxW = 0;
			int treeH = treeHeight(lca, 0); 
			
			System.out.println(lca + " " + treeH + " " + maxW);
			for (int i = 1; i <= V; i++)
				L[i] = P[i] = R[i] = H[i] = 0;				
		}
		sc.close();
	}
}
