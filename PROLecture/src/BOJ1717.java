// https://www.acmicpc.net/problem/1717

import java.util.*;

public class BOJ1717 {
	static final int MAXN = 1000000;
	static int[] p = new int[MAXN + 1];
	static int[] r = new int[MAXN + 1];
	static int N, M;
	
	public static void make_set()
	{
		for(int i = 0; i <= N; i++)
		{
			p[i] = i;
			r[i] = 0; 
		}
	}
	public static int find_set(int x)
	{
		if( x != p[x]) p[x] = find_set(p[x]);		
		return p[x];
	}
	public static void union(int x, int y)
	{
		int a = find_set(x);
		int b = find_set(y);
		if(a == b) return;
		if(r[a] > r[b]){ 
			p[b] = a;			
		}
		else{		
			p[a] = b;			
			if(r[a] == r[b]) r[b]++;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		
		M = sc.nextInt();
		
		make_set();
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int u = sc.nextInt();
			int v = sc.nextInt();
			if(a == 0)
				union(u,v);
			else{
				if(find_set(u) == find_set(v))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
		sc.close();
	}
}
