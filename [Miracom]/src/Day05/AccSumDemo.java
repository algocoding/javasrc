/*
10
9 8 1 7 15 2 4 19 3 6
2
1 2
4 8

 */
package Day05;
import java.util.*;

public class AccSumDemo {
	static int[] arr = new int[100];
	static int[] D = new int[100];
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++)
		{
			arr[i] = sc.nextInt();
			if(i == 0) D[i] = arr[i];
			else D[i] = arr[i] + D[i - 1];
		}
		int M = sc.nextInt();
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0)
				System.out.println("[" + a + ", " + b + "] = " + D[b]);
			else
				System.out.println("[" + a + ", " + b + "] = " + (D[b] - D[a - 1]));
		}
		
		sc.close();
	}
}
