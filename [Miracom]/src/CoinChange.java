import java.util.Scanner;

// µ¿Àü2 - https://www.acmicpc.net/problem/2294

public class CoinChange {
	static int N, K;
	static int[] coin;
	static int[] memo;

	public static int coinChange(int money) {
		for (int j = 1; j <= money; j++) {
			int min = 0xffffff;
			for (int i = 0; i < coin.length; i++) {
				if (j < coin[i])
					continue;
				if (memo[j - coin[i]] == -1)
					continue;

				if (min > memo[j - coin[i]])
					min = memo[j - coin[i]];
			}
			if (min != 0xffffff)
				memo[j] = min + 1;
		}
		return memo[money];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		coin = new int[N + 1];
		memo = new int[K + 1];

		for (int i = 0; i < N; i++)
			coin[i] = sc.nextInt();
		for (int i = 1; i <= K; i++)
			memo[i] = -1;
		System.out.println(coinChange(K));

		sc.close();
	}
}
