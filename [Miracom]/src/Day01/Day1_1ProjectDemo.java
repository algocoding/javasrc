/* ÀÔ·Â¿¹
 * 
7
88 51 24 88 94 50 60
14 55 1 23 12 84 91
26 44 81 97 33 82 30
3 71 12 99 16 92 48
87 5 14 93 28 92 56
4 14 92 96 48 41 77
94 32 43 16 1 52 51

*/

package Day01;
import java.util.*;
import java.io.*;

public class Day1_1ProjectDemo {

	static int m[][] = new int[11][11];
	static int order[] = new int [11];
	static int N, min = 0xfffffff, cnt = 0;
	
	static void solve(int k, int visit, int sum)
	{
		//if(sum >= min) return;
		if (k == N)
		{	cnt++;
			if (sum < min) min = sum;
		}
		else
		{
			k++;
			for (int i = 1; i <= N; i++)
			{
				if((visit & (1 << i)) != 0) continue;
				order[k] = i;
				solve(k, visit | (1 << i), sum + m[k][i]);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				m[i][j] = sc.nextInt();;

		solve(0, 0, 0);
		System.out.printf("%d %d\n", min, cnt);
		
		sc.close();
	}

}
