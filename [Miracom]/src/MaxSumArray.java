
// 연속 최대합 https://www.acmicpc.net/problem/1912

import java.util.*;

public class MaxSumArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];

		int max = -0xfffffff;
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
			sum[i] = sum[i - 1] + arr[i] > arr[i] ? sum[i - 1] + arr[i] : arr[i];
			if (max < sum[i])
				max = sum[i];
		}
		System.out.println(max);

		sc.close();
	}
}
