
// 부분집합 합 https://www.acmicpc.net/problem/1182
import java.util.*;

public class SubsetSumDP {

	static int N, S;
	static int[] arr = new int[30];
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		// subset(0, N, 0, 0);
		System.out.println(cnt);
		sc.close();
	}
}
