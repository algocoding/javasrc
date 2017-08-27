package Day03;
import java.util.*;

public class Day3_3Perm {

	static int N = 13;
	static int min;
	static int[] x = new int[N];
	static int[] y = new int[N];
	static int[] order = new int[N];
	
	static int calcDist(int from, int to){
		int dist = (x[from] - x[to]) > 0 ? x[from] - x[to] : x[to] - x[from];
		dist += (y[from] - y[to]) > 0 ? y[from] - y[to] : y[to] - y[from];
		return dist;
	}
	
	static void findPath(int k, int dist, int visit)
	{
		if (dist >= min) return;
		
		if (k == N - 1){ // 모든 선택이 끝남.
			
			dist += calcDist(order[k - 1], N - 1);
			
			if (dist < min) 
				min = dist;			
			
		}else{
			
			for (int i = 1; i <= 11; i++){
				
				if ((visit & (1 << i)) != 0) continue;
				
				order[k] = i;
				
				findPath(k + 1, dist + calcDist(order[k - 1], order[k]), visit | (1 << i));
			}
		}
	}
	public static void main(String[] args){
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
			
			min = 0xffffff;
			findPath(1, 0, 0);
			System.out.println(min);		
		}
		sc.close();
	}
	
}
