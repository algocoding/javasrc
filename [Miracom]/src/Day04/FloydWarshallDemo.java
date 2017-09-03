/*입력
5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2 
-2 0 0 0 2
0 -3 3 1 0
*/
package Day04;

import java.util.*;

public class FloydWarshallDemo {

	static int[][] D;
	static int N;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		D = new int[N + 1][N + 1];
		
		for(int i = 1; i <= N; i++)	// 1번 ~ N번 정점
		for(int j = 1; j <= N; j++)
		{
			D[i][j] = sc.nextInt();
			if(i != j && D[i][j] == 0) 
				D[i][j] = 0xffffff;
		}
		
		for (int k = 1; k <= N; k++)
		{
			for (int i = 1; i <= N; i++)
			{
				if (i == k) continue;
				for (int j = 1; j <= N; j++)
				{
					if (j == i && j == k) continue;
					D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
				}
			}
		}
		for (int i = 1; i <= N; i++)
		{
			for (int j = 1; j <= N; j++)
				System.out.printf("%2d ", D[i][j]);
			System.out.println();
		}
		sc.close();
	}
}
