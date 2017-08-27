
//네트워크 연결 https://www.acmicpc.net/problem/1922

import java.util.*;

public class LinkNetwork {
	static int[] p = null; // 부모 저장

	static int V, E;

	public static class Edge implements Comparable<Edge> {
		int u, v, w;

		Edge(int _u, int _v, int _w) {
			u = _u;
			v = _v;
			w = _w;
		}

		public int compareTo(Edge arg) {
			return w - arg.w;
		}

		public String toString() {
			return "(" + u + "-" + v + ", " + w + ")";
		}
	}

	static LinkedList<Edge> edges = new LinkedList<Edge>();
	static LinkedList<Edge> tree = new LinkedList<Edge>();

	public static void make_set() {
		p = new int[V + 1];
		for (int i = 1; i <= V; i++)
			p[i] = i;
	}

	public static int find_set(int x) {
		if (x == p[x])
			return x;
		else
			return find_set(p[x]);
	}

	public static void union(int x, int y) {
		p[find_set(y)] = find_set(x);
	}

	public static void kruskal() {
		Collections.sort(edges);
		make_set();

		int cnt = V - 1;

		while (cnt > 0) {
			Edge e = edges.removeFirst();
			int a = find_set(e.u);
			int b = find_set(e.v);
			if (a == b)
				continue;

			union(a, b);
			tree.add(e);
			cnt--;
		}
	}

	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			V = sc.nextInt();
			E = sc.nextInt();

			int from, to, weight;
			for (int i = 0; i < E; i++) {
				from = sc.nextInt();
				to = sc.nextInt();
				weight = sc.nextInt();
				edges.add(new Edge(from, to, weight));
			}
			kruskal();
			for (Edge e : tree)
				System.out.println(e);

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
