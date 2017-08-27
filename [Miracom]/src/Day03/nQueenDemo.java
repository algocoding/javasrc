package Day03;
import java.util.*;

public class nQueenDemo {
	static int[] COL;
	static int N;
	static int cnt = 0;

	static boolean isOk(int k, int col) {
		for (int i = 0; i < k; i++)
			if (Math.abs(i - k) == Math.abs(COL[i] - col))
				return false;
		return true;
	}

	static void search(int k, int used) {
		if (k == N)
			cnt++;

		for (int i = 0; i < N; i++) {
			if ((used & (1 << i)) != 0)
				continue;
			if (!isOk(k, i))
				continue;
			COL[k] = i;
			search(k + 1, used | (1 << i));
		}
	}

	public static void main(String[] args) {
		System.out.println("N-Queen 입력> ");
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		COL = new int[N];

		search(0, 0);

		System.out.println(cnt);
		sc.close();
	}
}
