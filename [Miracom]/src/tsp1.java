// 
import java.util.Scanner;

public class tsp1 {
	static int[][] G = new int[10][10];
	static int[] order;	
	static int min = 0xfffffff;
	static int N; // µµ½Ã¼ö
	public static void tsp(int k, int prev, int dist, int visit)
	{
		if(dist >= min) return;
		if(k == N)
		{
			dist += G[prev][0];
			if(min > dist) min = dist;
			return;
		}
		for(int i = 1; i < N; i++)
		{
			if( (visit & (1 << i)) != 0) continue;
			if(G[prev][i] == 0) continue;
			
			tsp(k + 1, i, dist + G[prev][i], visit | (1 << i));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
				G[i][j] = sc.nextInt();
		}
		tsp(1, 0, 0, 0);
		System.out.println(min);
		sc.close();
	}
}
