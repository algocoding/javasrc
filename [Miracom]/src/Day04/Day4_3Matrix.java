package Day04;
import java.util.*;

public class Day4_3Matrix {
	
		static final int MAXN = 20;	
		static int[] ROWS = new int[MAXN + 1];
		static int[] COLS = new int[MAXN + 1];
		static int[][] memo = new int[MAXN + 1][MAXN + 1];
		static int N;
		
		static void prepare() // 행렬 곱셈 가능 순서 만들기
		{
			int i, j;
			for(i = 0; i < N; i++)
			{
				for(j = 0; j < N; j++)
					if(i != j && ROWS[i] == COLS[j]) break;
				if( j == N) break;
			}
			int t = ROWS[0]; ROWS[0] = ROWS[i]; ROWS[i] = t;
			t = COLS[0]; COLS[0] = COLS[i]; COLS[i] = t;
			
			for(int k = 0; k < N - 1; k++)
			{
				for(int l = k + 1; l < N; l++)
				{
					if(COLS[k] == ROWS[l]) {
						t = ROWS[l]; ROWS[l] = ROWS[k + 1]; ROWS[k + 1] = t;
						t = COLS[l]; COLS[l] = COLS[k + 1]; COLS[k + 1] = t;
						break;					
					}
				}				
			}
		}
		// 재귀 + 메모
		static int multi_memo(int start, int end){			
			
			if (start == end) return 0;
			if (memo[start][end] != -1) return memo[start][end];
			
			int min = 0x7fffffff;
			for (int i = start; i < end; i++)
			{
				int l= multi_memo(start, i);
				int r = multi_memo(i + 1, end);
				int mid = ROWS[start] * COLS[i] * COLS[end];

				if (min > l + r + mid) min = l + r + mid;
			}
			return memo[start][end] = min;
		}
		// 반복
		static int multi_iter(){
			
			for (int start = N - 1; start >= 0; start--)
			{	
				for (int end = start; end <= N - 1; end++)
				{			
					if (start == end) memo[start][end] = 0;
					else
					{
						int min = 0x7fffffff;

						for (int i = start; i < end; i++)
						{
					 		int sum = memo[start][i] + memo[i + 1][end] + (ROWS[start] * COLS[i] * COLS[end]);
							if (min > sum) min = sum;
						}
						memo[start][end] = min;
					}
				}
			}
			return memo[0][N - 1];
		}
		public static void main(String[] args)
		{	
		    Scanner sc = new Scanner(System.in);
		    int T = sc.nextInt();
		    while(T-- > 0)
		    {
			    N = sc.nextInt();
			    for(int i = 0; i < N; i++)
			    {
			    	ROWS[i] = sc.nextInt();
			    	COLS[i] = sc.nextInt();
			    }
			    
			    // 곱셈 가능한 순서로 만들기
			    prepare();	
			    
			    // memo[][]에 초기값 설정
				for(int i = 0; i < N; i++)
					for(int j = 0; j < N; j++)
						memo[i][j] = -1;
			    
				System.out.println(multi_iter());		
				//System.out.println(multi_memo(0, N - 1));
		    }
		    sc.close();
		}
	}
