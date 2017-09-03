package Day04;

import java.util.Scanner;

public class Day4_1Paper {

	static int[] paper = new int[]{1, 1, 2};
	static long[] memo = new long[100];
	
	static long solve_recur(int len)
	{
		if(len < 0) return 0;
		if(len == 0) return memo[len] = 1;
		if(memo[len] != 0) return memo[len];
		
		return memo[len] = solve_recur(len - 1)*2 + solve_recur(len - 2);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			int N = sc.nextInt();
			
			System.out.println(solve_recur(N));
			//System.out.println(solve_iter(N));
		}
		
		sc.close();
	}
}
