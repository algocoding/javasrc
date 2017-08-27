
// 3�� ��ȭ https://www.acmicpc.net/problem/2398
import java.util.*;

public class ThreeCall {

	static Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>(); // ����
																				// ����Ʈ
	static int[] D = new int[1001]; // �Ÿ� ����
	static int[] P = new int[1001]; // �ִ� ��� Ʈ��

	static int N, M;
	static int v1, v2, v3;

	private static class Node {
		int v, w;

		Node(int a, int b) {
			v = a;
			w = b;
		}
	}

	// �켱 ���� ť�� ����Ǵ� ����
	static class Vertex implements Comparable<Vertex> {
		int id;
		int key;

		Vertex(int a, int b) {
			id = a;
			key = b;
		}

		public String toString() {
			return id + " " + key + "\n";
		}

		public int compareTo(Vertex arg) {
			return id - arg.id;
		}
	}

	// ���ͽ�Ʈ�� + �켱���� ť
	public static void dijkstra(int v) {
		for (int i = 1; i <= N; i++)
			D[i] = 0xffffff;
		D[v] = 0;
		P[v] = v;

		PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();
		Q.add(new Vertex(v, D[v]));
		while (!Q.isEmpty()) {
			Vertex vt = Q.remove();
			if (vt.key > D[vt.id])
				continue;

			v = vt.id;

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int u, v, w;
		for (int i = 0; i < M; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();

			List<Node> list = map.get(u);
			if (list == null) {
				list = new LinkedList<Node>();
				list.add(new Node(v, w));
				map.put(u, list);
			} else
				list.add(new Node(v, w));

			list = map.get(v);
			if (list == null) {
				list = new LinkedList<Node>();
				list.add(new Node(u, w));
				map.put(v, list);
			} else
				list.add(new Node(u, w));
		}
		v1 = sc.nextInt();
		v2 = sc.nextInt();
		v3 = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			dijkstra(i);

		}
		sc.close();

	}
}
