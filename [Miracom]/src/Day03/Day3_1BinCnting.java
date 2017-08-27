package Day03;
import java.util.*;

// 바이너리 카운팅으로 모든 부분 집합 생성
public class Day3_1BinCnting {
	
	static int[] cost;		// 병원 건설 비용
	static int[] subset;	// 인접 정점들의 집합(자기 자신도 포함)
	static int U; 			// 전체 정점 집합
	static int N;			// 마을 수
	
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
		
		int min = 0xfffff, set, sum;
		
		for(int i = 0; i < (1 << N); i++)
		{
			set = sum = 0;
			for(int j = 0; j < N; j++)
			{
				if((i & (1 << j)) != 0)	
				{
					set |= subset[j];	// j정점의 인접정점 집합을 합한다.
					sum += cost[j];		// j정점의 비용을 더한다.
				}
			}
			
			if(set == U && min > sum) min = sum;
		}
		System.out.println(min);
		sc.close();
	}
}
