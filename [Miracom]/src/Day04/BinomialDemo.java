package Day04;

import java.util.*;

public class BinomialDemo {

	static int n, r;
	static int[][] memo;
	
	static int bino(int n, int r)
	{
		if(r == 0 || n == r) return 1;
		return bino(n - 1, r - 1) + bino(n - 1, r);
	}
	static int bino_memo(int n, int r)
	{
		if(memo[n][r] != 0) return memo[n][r];
		
		if(r == 0 || n == r) return memo[n][r] = 1;
		
		return memo[n][r] = bino_memo(n - 1, r - 1) + bino_memo(n - 1, r);
	}
	static int bino_iter(int n, int r)
	{
		int[][] memo = new int[n + 1][r + 1];
		
		for(int i = 0; i <= n; i++)
		{
			for(int j = 0; j <= (r < i? r: i); j++)
			{
				if(j == 0 || i == j) memo[i][j] = 1;
				else memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j]; 
			}
		}
		
		return memo[n][r];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("n °ú r ÀÔ·Â> ");
		
		n = sc.nextInt();
		r = sc.nextInt();
		memo = new int[n + 1][n + 1];
		if(n >= r)
		{
			System.out.println(bino(n, r));
			System.out.println(bino_memo(n, r));
			System.out.println(bino_iter(n, r));
		}
		sc.close();
	}

}
