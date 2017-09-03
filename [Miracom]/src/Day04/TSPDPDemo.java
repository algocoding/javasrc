package Day04;
import java.util.*;
public class TSPDPDemo {
	static int N = 13;
	static int[] x = new int[N];
	static int[] y = new int[N];
	static int[][] G = new int[N][N];
	static int[][] dp = new int[1 << N][N];
	static void calcDistance(){
		
		for(int i = 0; i < N -1; i++)
		{
			for(int j = i + 1; j < N; j++)
			{
				G[i][j] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
				G[j][i] = G[i][j];
			}
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		while(T-- > 0)
		{
			// 시작점과 도착점
			x[0] = sc.nextInt(); y[0] = sc.nextInt();
			x[12] = sc.nextInt(); y[12] = sc.nextInt();
			
			for(int i = 1; i <= 11; i++)
			{
				x[i] = sc.nextInt(); 
				y[i] = sc.nextInt();
			}
			calcDistance();
			
			int n = N - 1;
			for (int i = 0; i < (1 << n); i++)
				for (int j = 0; j < n; j++)
					dp[i][j] = 0xfffffff;
			
			dp[1][0] = 0;
			
			for (int visit = 1; visit < (1 << n); visit++) // visit: 방문한 정점들의 집합
			{
				for (int last = 0; last < n; last++)		// last: 마지막 방문 정점
				{
					if ((visit & (1 << last)) == 0) continue; // 1번 방문하지 않은 경우 제외
					
					int prev = visit - (1 << last); 		 // 마지막 방문 정점을 제외
					
					for (int v = 0; v < n; v++)				 // prev 집합의 마지막 방문 정점들에 대해
					{
						if (G[v][last]==0 || (prev & (1 << v)) == 0) // 간선이 없거나, 비방문 정점 제외 
							continue;
						
						dp[visit][last] = Math.min(dp[visit][last], dp[prev][v] + G[v][last]);
					}
				}
			}
			int ans = 0xfffffff;
			for (int i = 1; i < n; i++)
				ans = Math.min(ans, dp[(1 << n) - 1][i] + G[i][n]);
			System.out.println(ans);
		}
		sc.close();		
	}
}
