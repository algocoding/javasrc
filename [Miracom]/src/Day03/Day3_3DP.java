package Day03;

import java.util.Scanner;

public class Day3_3DP {
	static int N = 13;
	static int min;
	static int[] x = new int[N];
	static int[] y = new int[N];
	static int[][] G;
	static int[][] memo;
	
	static void calcDist(){
		memo = new int[13][0xffff];
		G = new int[N][N];
		for (int i = 0; i < N - 1; i++)	{
			for (int j = i + 1; j < N; j++)	{
				G[i][j] = (x[i] - x[j]) > 0 ? x[i] - x[j] : x[j] - x[i];
				G[i][j] += (y[i] - y[j]) > 0 ? y[i] - y[j] : y[j] - y[i];
				G[j][i] = G[i][j] ;
			}
		}
	}
	
	static int findPath(int curr, int visit)
	{
		if (visit == ((1 << N - 1) - 1))
		{
			return G[curr][12];
		}
		if (memo[curr][visit] != 0) return memo[curr][visit];
		
		int min = 0xffffff;
		for (int next = 0; next < N; next++)
		{
			if ((visit & (1 << next)) != 0) continue;
			//if (G[curr][next] == 0) continue;
			
			int ret = findPath(next, visit | (1 << next)) + G[curr][next];
			
			if (min > ret) min = ret;
		}
		return memo[curr][visit] = min;
	}
	public static void main(String[] args){
		System.out.println("인접행렬 사용");
		
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			x[0] = sc.nextInt(); y[0] = sc.nextInt(); 
			x[12] = sc.nextInt();y[12] = sc.nextInt();		

			for (int i = 1; i <= 11; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}			
			calcDist();			
			System.out.println(findPath(0, 1));		
		}
		sc.close();
	}
}
