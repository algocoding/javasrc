
// 단어 나누기 https://www.acmicpc.net/problem/1251
import java.util.*;

public class DivideWord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();

		String part, rev;
		String min = new String();
		for (int i = 0; i < 50; i++)
			min += "z";

		int last = word.length() - 1;

		for (int i = 0; i <= last - 2; i++) {
			for (int j = i + 1; j <= last - 1; j++) {
				part = word.substring(0, i + 1);
				rev = new StringBuffer(part).reverse().toString();

				part = word.substring(i + 1, j + 1);
				rev += new StringBuffer(part).reverse().toString();

				part = word.substring(j + 1, last + 1);
				rev += new StringBuffer(part).reverse().toString();
				// System.out.println(rev);
				if (min.compareTo(rev) > 0)
					min = rev;
			}
		}
		System.out.println(min);
		sc.close();
	}
}
