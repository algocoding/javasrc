package Day05;
// 구간합 구하기1 https://www.acmicpc.net/problem/2042
// 10999
import java.util.*;

public class SegmentTree {

	static final int MAXN = 1000000;
	static long[] arr = new long[MAXN + 1];
	static long[] st = new long[1 << 21 + 1];
	static long[] lt = new long[1 << 21 + 1];;
	static int N, M, K;
	public static long buildTree(int id, int l, int r)
	{
		if(l == r)
		{
			return st[id] = arr[l];
		}
		int m = (l + r) / 2;
		
		return st[id] = buildTree(id * 2, l, m) + buildTree(id * 2 + 1, m + 1, r);
	}
	public static void lazy_propagation(int id, int l, int r)
	{
		if(lt[id] != 0)
		{
			st[id] += (r - l + 1) *lt[id];
			if(l != r)
			{
				lt[id*2] += lt[id];
				lt[id*2 + 1] += lt[id];
			}
			lt[id] = 0;
		}
	}
	public static long query(int id, int l, int r, int i, int j)
	{
		lazy_propagation(id, l, r);
		
		if(r < i || j < l) return 0;
		
		if(i <= l && r <= j)  return st[id];
		
		int m = (l + r) / 2;
		return query(id * 2, l, m, i, j) + query(id * 2 + 1, m + 1, r, i, j);
	}
	public static void update(int id, int l, int r, int p, int v)
	{
		if(r < p || p < l) return;
		
		st[id] += v;
		if(l != r)
		{
				int m = (l + r) / 2;		
				update(id * 2, l, m, p, v);
				update(id * 2 + 1, m + 1, r, p, v);
		}
	}
	public static void updateRange(int id, int l, int r, int i, int j, int v)
	{
		lazy_propagation(id, l, r);
		
		if(r < i || j < l) return;
		
		if(i <= l && r <= j){
			st[id] += (r - l + 1) * v;
			if(l != r)
			{
				lt[id*2] += v;
				lt[id*2 + 1] += v;
			}
			return;
		}
		
		
		int m = (l + r) / 2;		
		updateRange(id * 2, l, m, i, j, v);
		updateRange(id * 2 + 1, m + 1, r, i, j, v);
		
		st[id] = st[id*2] + st[id*2+1];
	}
	public static void main(String[] args) 
	{
		//System.out.println("구간 트리....lazy propagation....");
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();		
		M = M + K;
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		buildTree(1, 0, N - 1);
		int a, b, c, d;
		
		for(int i = 0; i < M; i++)
		{
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a == 1)
			{
				d = sc.nextInt();				
				arr[b] = c;
				updateRange(1, 0, N - 1, b - 1, c - 1, d);
			}else{
				System.out.println(query(1, 0, N - 1, b - 1, c - 1));
			}
		}
		sc.close();
	}

}
