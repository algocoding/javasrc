package Day03;

import java.util.Scanner;

public class Day3_3Perm2 {
	static int N = 13;
	static int min;
	static int[] x = new int[N];
	static int[] y = new int[N];
	static int[][] G;
	static int[] order = new int[N];
	
	static void calcDist(){
		G = new int[N][N];
		for (int i = 0; i < N - 1; i++)	{
			for (int j = i + 1; j < N; j++)	{
				G[i][j] = (x[i] - x[j]) > 0 ? x[i] - x[j] : x[j] - x[i];
				G[i][j] += (y[i] - y[j]) > 0 ? y[i] - y[j] : y[j] - y[i];
				G[j][i] = G[i][j] ;
			}
		}
	}
	
	static void findPath(int k, int dist, int visit)
	{
		if (dist >= min) return;
		
		if (k == N - 1){ // 모든 선택이 끝남.
			
			dist += G[order[11]][12];
			
			if (dist < min) 
				min = dist;			
			
		}else{
			
			for (int i = 1; i <= 11; i++){
				
				if ((visit & (1 << i)) != 0) continue;
				
				order[k] = i;
				
				findPath(k + 1, dist + G[order[k - 1]][i], visit | (1 << i));
			}
		}
	}
	public static void main(String[] args){
		System.out.println("인접행렬 사용");
		
		Scanner sc = new Scanner(System.in);	
		int T = sc.nextInt();
		
		while(T-- > 0)
		{
			x[0] = sc.nextInt(); y[0] = sc.nextInt(); 
			x[12] = sc.nextInt();y[12] = sc.nextInt();
			
			order[0] = 0;  order[12] = 12;

			for (int i = 1; i <= 11; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}			
			calcDist();
			min = 0xffffff;
			findPath(1, 0, 0);
			System.out.println(min);		
		}
		sc.close();
	}
}
