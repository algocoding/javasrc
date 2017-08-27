package Day03;

import java.util.*;

// 백트래킹으로 풀기
public class Day3_1Backtrack {
	static int[] cost;		// 병원 건설 비용
	static int[] subset;	// 인접 정점들의 집합(자기 자신도 포함)
	static int U; 			// 전체 정점 집합
	static int N;			// 마을 수
	static int min;			// 최소 비용
	
	// sum: 현재까지 비용, set: 커버하는 마을 정보
	static void solve(int k, int sum, int set)
	{
		if (sum >= min) return;
		if (set == U && sum < min)
		{
			min = sum;
			System.out.printf("비용 = %d\n", min);
			return;
		}
		if (k == N)	return;

		solve(k + 1, sum + cost[k], set | subset[k]);
		solve(k + 1, sum, set);
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		cost = new int[N];
		subset = new int[N];
		
		for(int i = 0; i < N; i++)
			cost[i] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			U |= (1 << i);
			subset[i] |= (1 << i);		// 자기 자신 포함
			for(int j = 0; j < N; j++)
			{
				int t = sc.nextInt();
				if(t == 1)
					subset[i] |= (1 << j); 
			}
		}
		min = 0xfffffff;
		solve(0, 0, 0);
		
		System.out.println(min);
		sc.close();
	}
}
