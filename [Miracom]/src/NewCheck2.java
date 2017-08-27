
// ��Ȯ�� ������ https://www.acmicpc.net/problem/9370
import java.util.*;

public class NewCheck2 {
	static Map<Integer, List<Vertex>> adjList;
	static int[] D = new int[2001];
	static int[] P = new int[2001];

	static int T, N, M;
	static int s, g, h;

	// �켱 ���� ť�� ����Ǵ� ����
	private static class Vertex implements Comparable<Vertex> {
		int v; // ����
		int d; // ����ġ �Ǵ� �Ÿ�

		Vertex(int a, int b) {
			v = a;
			d = b;
		}

		public String toString() {
			return "(" + v + "/" + d + ")";
		}

		public int compareTo(Vertex arg) {
			return d - arg.d;
		}
	}

	// ���ͽ�Ʈ�� + �켱���� ť
	public static void dijkstra(int v) {
		for (int i = 1; i <= N; i++) {
			D[i] = 0xfffffff;
			P[i] = i;
		}
		D[v] = 0;

		PriorityQueue<Vertex> PQ = new PriorityQueue<Vertex>();
		PQ.add(new Vertex(v, D[v]));

		while (!PQ.isEmpty()) {
			Vertex from = PQ.poll();
			if (from.d > D[from.v])
				continue;

			List<Vertex> list = adjList.get(from.v);

			for (Vertex to : list) {
				if (D[to.v] > D[from.v] + to.d) {
					D[to.v] = D[from.v] + to.d;
					P[to.v] = from.v;
					PQ.add(new Vertex(to.v, D[to.v]));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		while (tc-- > 0) {
			N = sc.nextInt(); // ������ ��
			M = sc.nextInt(); // ���� ��
			T = sc.nextInt(); // ������ �ĺ� ��

			s = sc.nextInt(); // �����
			g = sc.nextInt(); // ��λ� ������ �� ����
			h = sc.nextInt(); // ��λ� ������ �� ����

			adjList = new HashMap<Integer, List<Vertex>>(); // ���� ����Ʈ
			int from, to, weight;
			for (int i = 0; i < M; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();

				List<Vertex> list = adjList.get(from);
				if (list == null) {
					list = new LinkedList<Vertex>();
					list.add(new Vertex(to, weight));
					adjList.put(from, list);
				} else
					list.add(new Vertex(to, weight));

				list = adjList.get(to);
				if (list == null) {
					list = new LinkedList<Vertex>();
					list.add(new Vertex(from, weight));
					adjList.put(to, list);
				} else
					list.add(new Vertex(from, weight));
			}
			ArrayList<Integer> cand = new ArrayList<Integer>();

			for (int i = 0; i < T; i++)
				cand.add(sc.nextInt());

			dijkstra(s);

			Collections.sort(cand);

			for (int i : cand) {
				int cur = i;
				while (cur != s) {
					if ((cur == g && P[cur] == h) || (cur == h && P[cur] == g)) {
						System.out.print(i + " ");
						break;
					}
					cur = P[cur];
				}
			}

			System.out.println();
		}
		sc.close();
	}
}