package Day04;

import java.util.Scanner;

public class Day4_2LCS {
	static String x;
	static String y;
	
	static int[][] memo;
	
	public static int LCS(int i, int j)
	{
		if(i < 0 || j < 0) return 0;
		
		if(x.charAt(i) == y.charAt(j))
			return LCS(i - 1, j - 1) + 1;
		else 
		{
			int a = LCS(i - 1, j);
			int b = LCS(i, j - 1);
			return a > b? a : b;
		}
	}
	public static int LCS_memo(int i, int j)
	{
		if(i < 0 || j < 0) return 0;
		if(memo[i][j] != 0) return memo[i][j];
		
		int ret;
		if(x.charAt(i) == y.charAt(j))
			ret = LCS_memo(i - 1, j - 1) + 1;
		else 
		{
			int a = LCS_memo(i - 1, j);
			int b = LCS_memo(i, j - 1);
			ret = a > b? a : b;
		}
		return memo[i][j] = ret;
	}
	public static int LCS_iter(int m, int n)
	{
		for(int i = 0; i <= m; i++) 
			for(int j = 0; j <= n; j++)
				memo[i][j] = 0;
		
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(x.charAt(i - 1) == y.charAt(j - 1))
					memo[i][j] = memo[i - 1][j - 1] + 1;
				else					
					memo[i][j] = memo[i - 1][j] > memo[i][j - 1]? memo[i - 1][j] : memo[i][j - 1];
			}
		}
		return memo[m][n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			int N = sc.nextInt();
			x = sc.next();
			y = sc.next();
			
			memo = new int[x.length() + 1][y.length() + 1];			
			
			//System.out.printf("%.2f\n", ((double)LCS_memo(x.length() - 1, y.length() - 1)/N)*100 );
			System.out.printf("%.2f\n", ((double)LCS_iter(x.length(), y.length())/N) * 100 );
		}
		sc.close();
	}
}
