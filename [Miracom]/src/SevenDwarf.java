
// ÀÏ°ö³­ÀïÀÌ https://www.acmicpc.net/problem/2309

import java.util.*;

public class SevenDwarf {

	static ArrayList<Integer> arr = new ArrayList<Integer>();
	static int N = 9;

	static boolean subset(int k, int sum, int set, int cnt) {
		if (sum > 100)
			return false;
		if (cnt == 7 && sum == 100) {
			for (int i = 0; i < N; i++)
				if ((set & (1 << i)) != 0)
					System.out.println(arr.get(i));
			return true;
		}
		if (k == N)
			return false;

		if (subset(k + 1, sum + arr.get(k), set | (1 << k), cnt + 1))
			return true;
		if (subset(k + 1, sum, set, cnt))
			return true;

		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < N; i++)
			arr.add(sc.nextInt());

		Collections.sort(arr);

		subset(0, 0, 0, 0);

		sc.close();
	}
}
