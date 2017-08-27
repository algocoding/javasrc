
// 
import java.util.*;

public class TreeTraversal2 {

	static class Child {
		String left = null, right = null;

		Child(String l, String r) {
			left = l;
			right = r;
		}
	}

	static Map<String, Child> map = new HashMap<String, Child>();

	static void preorder(String node) {
		if (node == null)
			return;

		Child child = map.get(node);
		System.out.print(node);
		preorder(child.left);
		preorder(child.right);
	}

	static void inorder(String node) {
		if (node == null)
			return;

		Child child = map.get(node);

		inorder(child.left);
		System.out.print(node);
		inorder(child.right);
	}

	static void postorder(String node) {
		if (node == null)
			return;

		Child child = map.get(node);

		postorder(child.left);
		postorder(child.right);
		System.out.print(node);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String p = sc.next();
			String l = sc.next();
			String r = sc.next();

			if (l.compareTo(".") == 0)
				l = null;
			if (r.compareTo(".") == 0)
				r = null;
			map.put(p, new Child(l, r));
		}
		preorder("A");
		System.out.println();
		inorder("A");
		System.out.println();
		postorder("A");
		System.out.println();

		sc.close();
	}
}
