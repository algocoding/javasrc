package Day03;
import java.util.*;

// ���̳ʸ� ī�������� ��� �κ� ���� ����
public class Day3_1BinCnting {
	
	static int[] cost;		// ���� �Ǽ� ���
	static int[] subset;	// ���� �������� ����(�ڱ� �ڽŵ� ����)
	static int U; 			// ��ü ���� ����
	static int N;			// ���� ��
	
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
		
		int min = 0xfffff, set, sum;
		
		for(int i = 0; i < (1 << N); i++)
		{
			set = sum = 0;
			for(int j = 0; j < N; j++)
			{
				if((i & (1 << j)) != 0)	
				{
					set |= subset[j];	// j������ �������� ������ ���Ѵ�.
					sum += cost[j];		// j������ ����� ���Ѵ�.
				}
			}
			
			if(set == U && min > sum) min = sum;
		}
		System.out.println(min);
		sc.close();
	}
}
