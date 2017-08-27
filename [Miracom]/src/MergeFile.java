
// ���� ��ġ�� https://www.acmicpc.net/problem/11066
import java.util.*;

public class MergeFile {

	static int[] file = new int[500];
	static int[][] memo = new int[501][501];
	static int N;

	static int merge(int start, int end) {
		if (memo[start][end] != -1)
			return memo[start][end];
		if (end - start == 1)
			return memo[start][end] = file[start] + file[end];

		int min = 0xfffffff;

		// ���� ������ �� ���� ���ϳ׿�....

		int sum = merge(start + 1, end);
		sum = 2 * sum + file[start];
		if (min > sum)
			min = sum;

		sum = merge(start, end - 1);
		sum = 2 * sum + file[end];
		if (min > sum)
			min = sum;

		return memo[start][end] = min;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			for (int i = 0; i < N; i++)
				file[i] = sc.nextInt();

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++)
					memo[i][j] = -1;
			}

			merge(0, N - 1);
			System.out.println(memo[0][N - 1]);
		}

		sc.close();
	}
}
