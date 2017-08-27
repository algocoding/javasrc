import java.util.Scanner;

// 부분집합 합 https://www.acmicpc.net/problem/1182

public class SubsetSum {

	static int N, S;
	static int[] arr = new int[30];
	static int cnt = 0;

	static void subset(int k, int n, int sum, int visit) {
		if (k == n) {
			if (sum == S && visit != 0)
				cnt++;
			return;
		}
		subset(k + 1, n, sum + arr[k], visit | (1 << k));
		subset(k + 1, n, sum, visit);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		subset(0, N, 0, 0);
		System.out.println(cnt);
		sc.close();
	}
}
