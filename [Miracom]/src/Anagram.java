
// 애너그램 - https://www.acmicpc.net/problem/6996
import java.util.*;

public class Anagram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while (T-- > 0) {
			int[] cntA = new int[128];
			int[] cntB = new int[128];
			int start = (int) 'A';
			int end = (int) 'z';

			String A = sc.next();
			String B = sc.next();

			if (A.length() != B.length())
				System.out.println(A + " & " + B + " are NOT anagrams.");
			else {
				for (int i = 0; i < A.length(); i++)
					cntA[(int) A.charAt(i)]++;
				for (int i = 0; i < B.length(); i++)
					cntB[(int) B.charAt(i)]++;

				int i;
				for (i = start; i <= end; i++)
					if (cntA[i] != cntB[i])
						break;

				if (i > end)
					System.out.println(A + " & " + B + " are anagrams.");
				else
					System.out.println(A + " & " + B + " are NOT anagrams.");
			}
		}
		sc.close();
	}
}
