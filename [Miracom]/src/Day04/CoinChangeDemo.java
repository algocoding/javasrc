package Day04;

public class CoinChangeDemo {
	static int[] coin = new int[]{1, 4, 6};
	
	public static int coinChange(int money)
	{
		if(money == 0) return 0;
		
		int min = 0xfff;
		for(int i = 0; i < coin.length; i++)
		{
			if(money < coin[i]) continue;

			int ret = coinChange(money - coin[i]);
			
			if(min > ret) min = ret;
		}
		return min + 1;
	}
	static int[] memo = new int[1000];
	public static int coinChange_memo(int money)
	{ 
		if(memo[money] != 0) return memo[money];
		if(money == 0) return memo[money] = 0;
		
		int min = 0xfff;
		for(int i = 0; i < coin.length; i++)
		{
			if(money < coin[i]) continue;

			int ret = coinChange_memo(money - coin[i]);
			
			if(min > ret) min = ret;
		}
		System.out.printf("memo[%d] = %2d\n", money, min + 1);
		return memo[money] = min + 1;
	}
	public static int coinChange_iter(int money)
	{ 
		memo[0] = 0;
		
		for(int j = 1; j <= money; j++)
		{
		
			int min = 0xfff;
			for(int i = 0; i < coin.length; i++)
			{
				if(j < coin[i]) continue;
	
				int ret = memo[j - coin[i]];
				
				if(min > ret) min = ret;
			}
			memo[j] = min + 1;
		}
		for(int i = 0; i <= money; i++) System.out.printf("%2d ", i);
		System.out.print("\n----------------------------------\n");
		for(int i = 0; i <= money; i++) System.out.printf("%2d ", memo[i]);
		System.out.print("\n----------------------------------\n");
		
		return memo[money]; 
	}
	public static void main(String[] args) {
		System.out.println(coinChange(8));
		System.out.println(coinChange_memo(8));
		System.out.println(coinChange_iter(8));		
	}
}
