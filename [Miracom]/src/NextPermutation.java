import java.util.*;

public class NextPermutation {

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

		int[] arr = new int[] { 4, 3, 2, 1 };

		do {
			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		} while (next_permutation(arr));
	}
}
