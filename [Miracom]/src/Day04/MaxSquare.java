// 최대 정사각형 https://www.acmicpc.net/problem/4095
package Day04;
import java.util.*;

public class MaxSquare {	
	static final int MAX = 1000;
	static int[][] mat = new int[MAX][MAX];
	static int[][] memo = new int[MAX][MAX];
	static int N, M;

	
	public static void main(String[] args)
	{	
	    Scanner sc = new Scanner(System.in);
	    while(true)
	    {
	    	N = sc.nextInt();	    
		    M = sc.nextInt();
		    if(N == 0 && M == 0) {
		    	sc.close();
		    	return;		    
		    }
		    
			for (int i = 0; i < N; i++)		
				for (int j = 0; j < M; j++)			
					mat[i][j] = sc.nextInt();
			
			for (int i = 0; i < N; i++)			
				memo[i][0] = mat[i][0];
			for (int i = 0; i < M; i++)
				memo[0][i] = mat[0][i];
			
			int min, max = 0;
			for (int i = 1; i < N; i++)
			{
				for (int j = 1; j < M; j++)
				{
					if (mat[i][j] == 1)
					{
						min = (memo[i - 1][j - 1] < memo[i - 1][j]) ? memo[i - 1][j - 1] : memo[i - 1][j];					
						memo[i][j] = (min < memo[i][j - 1]) ? (min + 1) : (memo[i][j - 1] + 1);
						if (max < memo[i][j]) {
							max = memo[i][j];							
						}
					}
					else memo[i][j] = 0;
				}
			}	
			System.out.println(max);

	    }
	}
}
