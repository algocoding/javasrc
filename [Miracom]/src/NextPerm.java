
// 다음 순열 https://www.acmicpc.net/problem/10972

import java.util.*;

public class NextPerm {

	static boolean next_permutation(int[] arr) {
		int i = arr.length - 1;

		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		if (i == 0)
			return false;

		int j = arr.length - 1;

		while (j > 0 && arr[i - 1] >= arr[j])
			j--;

		if (j < i)
			return false;

		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;

		j = arr.length - 1;
		while (i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		if (next_permutation(arr)) {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		} else
			System.out.println(-1);
		sc.close();
	}
}
