/*입력
4
6 7 12 5
5 3 11 18
7 17 3 3
8 10 14 9
 */

package Day04;

import java.util.Scanner;

public class MatrixPathDemo {

	static int[][] MAT;
	static int[][] D;
	static int N;
	
	static int matrixPath_recur(int i, int j)
	{
		if(i == 1 && j == 1) return D[1][1] = MAT[1][1];
		if(i == 1) return matrixPath_recur(1, j - 1) + MAT[1][j]; 
		if(j == 1) return matrixPath_recur(i - 1, 1) + MAT[i][1];
		
		int a = matrixPath_recur(i, j - 1); 
		int b = matrixPath_recur(i - 1, j);  
		a = a < b ? a : b; 
		return D[i][j] = a + MAT[i][j];
	}
	static int matrixPath_iter(int N, int M)
	{
		for(int i = 1; i <= N; i++) // 1행 1열 초기화
		{
			D[1][i] = D[1][i - 1] + MAT[1][i];
			D[i][1] = D[i - 1][1] +MAT[i][1];
		}
		for(int i = 2; i <= N; i++)	// 2번 ~ N번 정점
		for(int j = 2; j <= N; j++)
		{
			D[i][j] = (D[i][j - 1] + MAT[i][j]) < (D[i - 1][j] + MAT[i][j]) ? 
					(D[i][j - 1] + MAT[i][j]) : (D[i - 1][j] + MAT[i][j]);
		}
		return D[N][M];
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		MAT = new int[N + 1][N + 1];
		D = new int[N + 1][N + 1];
		for(int i = 1; i <= N; i++)	// 1번 ~ N번 정점
		for(int j = 1; j <= N; j++)
		{
			MAT[i][j] = sc.nextInt();			
			D[i][j] = -1;
		}

		System.out.printf("%2d\n", matrixPath_recur(N, N));
		//System.out.printf("%2d\n", matrixPath_iter(N, N));
		
		sc.close();
	}

}
