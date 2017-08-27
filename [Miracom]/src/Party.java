import java.util.*;

public class Party {
	static int[][] D = new int[1001][1001];
	static int N, M, X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		X = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				D[i][j] = 0xfffffff;
			}
		}
		int u, v, w;
		for (int i = 0; i < M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			D[u][v] = w;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= N; j++) {
					if (k == j || i == j)
						continue;
					if (D[i][j] > D[i][k] + D[k][j])
						D[i][j] = D[i][k] + D[k][j];
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (i == X)
				continue;
			if (max < D[i][X] + D[X][i])
				max = D[i][X] + D[X][i];
		}
		System.out.println(max);
	}
}
