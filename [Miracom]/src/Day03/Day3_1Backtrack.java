package Day03;

import java.util.*;

// ��Ʈ��ŷ���� Ǯ��
public class Day3_1Backtrack {
	static int[] cost;		// ���� �Ǽ� ���
	static int[] subset;	// ���� �������� ����(�ڱ� �ڽŵ� ����)
	static int U; 			// ��ü ���� ����
	static int N;			// ���� ��
	static int min;			// �ּ� ���
	
	// sum: ������� ���, set: Ŀ���ϴ� ���� ����
	static void solve(int k, int sum, int set)
	{
		if (sum >= min) return;
		if (set == U && sum < min)
		{
			min = sum;
			System.out.printf("��� = %d\n", min);
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
			subset[i] |= (1 << i);		// �ڱ� �ڽ� ����
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
