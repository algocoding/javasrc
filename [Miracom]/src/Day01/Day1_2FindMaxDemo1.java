/* 입력예
10
321 1
4757 1
32888 2
757148 1
768466 3
777770 5
436659 2	
437859 7	
112233 4
111111 10
*/
package Day01;
import java.util.*;

public class Day1_2FindMaxDemo1 {

	static int max, cnt, len;
	static int s;		// 교환 횟수 
	static int[][ ]state = new int[11][720];
	static int d[] = {1, 10, 100, 1000, 10000, 100000};

	static int swap(int x, int i, int j)
	{
		int a = (x / d[i]) % 10;
		int b = (x / d[j]) % 10;
		return x - a*d[i] + a*d[j] - b*d[j] + b*d[i];
	}

	static void findMax(int x, int k)
	{
		cnt++;		
		for (int i = 0; i < 720; i++)
		{
			if (state[k][i] == 0)
			{
				state[k][i] = x;
				break;
			}
			else if (state[k][i] == x) return;
		}
		if (k == s)
		{
			if(max < x) max = x;
			return;
		}
		
		for (int i = 0; i < len - 1; i++)
		{
			for (int j = i + 1; j < len; j++)
			{
				findMax(swap(x, i, j), k + 1);
			}
		}
	}

	public static void main(String[] args)
	{
		//Scanner sc = new Scanner(new File("day1_2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		
		long start = System.currentTimeMillis();
		
		for(int n = 1; n <= N; n++)
		{
			for (int i = 1; i < 11; i++)
				for (int j = 0; j < 720; j++)
					state[i][j] = 0;

			int x = sc.nextInt();	// 숫자
			s = sc.nextInt();		// 교환 횟수

			int t = x;
			len = 0;
			while (t != 0) { t /= 10; len++;}

			cnt = max = 0;
			findMax(x, 0);

			System.out.printf("#%d %d %d\n", n, max, cnt);
			if(n == 9)
			System.out.println( "실행 시간 : " + ( System.currentTimeMillis() - start )/1000.0 ); 
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 ); 
	}
}
