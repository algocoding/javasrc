package Day03;

public class KnapsackDemo {
	static int W = 10;
	static int N = 4;
	static int max = 0;
	static int[] w = new int[]{6, 3, 4, 2};
	static int[] v = new int[]{30, 14, 16, 9};
	static boolean[] bits = new boolean[N];
	public static void print_items()
	{
		for(int i = 0; i < N; i++)
		{
			if(bits[i])
				System.out.print("물건" + i + ", ");
				//System.out.print("[물건" + i + "(" + w[i] + "," + v[i] + ")] ");
		}
		System.out.println();
	}
	// 반환 값 없는 knapsack 함수
	public static void knapsack(int k, int weight, int value)
	{
		if( weight > W) return;
		
		if(k == N)
		{
			if(value > max) 
			{
				max = value; //print_items();
			}
			return;
		}
		bits[k] = true; knapsack(k + 1,  weight + w[k], value + v[k]);
		bits[k] = false; knapsack(k + 1,  weight, value);
	}
	
	// 최대 이익을 반환 knapsack 함수
	public static int knapsack(int k, int weight)
	{
		if(k == N || weight == 0) return 0;
		
		int case1 = 0, case2 = 0;

		if( weight >= w[k]) 
			case1 = knapsack(k + 1,  weight - w[k]) + v[k];
		case2 = knapsack(k + 1,  weight);
		
		return case1 > case2? case1: case2;
	}
	
	public static void main(String[] args) {
		knapsack(0, 0, 0);
		System.out.println("최대 가치 = " + max);
		
		System.out.println("최대 가치 = " + knapsack(0, W));
	}

}
