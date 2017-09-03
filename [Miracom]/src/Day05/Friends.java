package Day05;
import java.util.Scanner;

// UVa 
public class Friends {

	static int[] p = new int[30001];
	static int[] r = new int[30001];
	static int[] cnt = new int[30001];
	static int N, M, max;
	
	
	public static void make_set()
	{
		max = 1;
		for(int i = 1; i <= N; i++)
		{
			p[i] = i;
			r[i] = 0;
			cnt[i] = 1; 
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
			cnt[a] += cnt[b];			
			max = max > cnt[a]? max: cnt[a];
		}
		else{		
			p[a] = b;
			cnt[b] += cnt[a];			
			max = max > cnt[b]? max: cnt[b];
			if(r[a] == r[b]) r[b]++;
		}
	}
	
	public static void main(String[] args) {
		
		int T, a, b;
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for(int i = 0; i < T; i++)
		{
			N = sc.nextInt();
			M = sc.nextInt();
			
			make_set();

			for(int j = 0; j < M; j++)
			{
				a = sc.nextInt();
				b = sc.nextInt();
				union(a, b);
			}
			System.out.println(max);
		}
		sc.close();
	}
}
