
// 
import java.util.*;

public class TreeTraversal {
	static int[] p, l, r;

	static void preorder(int v) {
		if (v == 0)
			return;

		System.out.printf("%c", 'A' + v - 1);
		preorder(l[v]);
		preorder(r[v]);
	}

	static void inorder(int v) {
		if (v == 0)
			return;

		inorder(l[v]);
		System.out.printf("%c", 'A' + v - 1);
		inorder(r[v]);
	}

	static void postorder(int v) {
		if (v == 0)
			return;

		postorder(l[v]);
		postorder(r[v]);
		System.out.printf("%c", 'A' + v - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		p = new int[27];
		l = new int[27];
		r = new int[27];

		String str;
		char c;

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			str = sc.next();
			c = str.charAt(0);
			int idx = (c - 'A') + 1;

			str = sc.next();
			c = str.charAt(0);
			if (c != '.')
				l[idx] = (c - 'A') + 1;
			str = sc.next();
			c = str.charAt(0);
			if (c != '.')
				r[idx] = (c - 'A') + 1;
		}
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();

		sc.close();
	}
}
