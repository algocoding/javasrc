
// 模备 匙飘况农 https://www.acmicpc.net/problem/4195
import java.util.*;

public class FriendsNetwork {
	static Map<String, Integer> map = new HashMap<String, Integer>();

	static final int MAXN = 200000;
	static int[] p = new int[MAXN + 1];
	static int[] r = new int[MAXN + 1];
	static int[] cnt = new int[MAXN + 1];
	static int N, M;

	public static void make_set() {
		for (int i = 0; i <= N * 2; i++) {
			p[i] = i;
			r[i] = 0;
			cnt[i] = 1;
		}
	}

	public static int find_set(int x) {
		if (x != p[x])
			p[x] = find_set(p[x]);
		return p[x];
	}

	public static int union(int x, int y) {
		int a = find_set(x);
		int b = find_set(y);
		if (a == b)
			return cnt[a];
		if (r[a] > r[b]) {
			p[b] = a;
			cnt[a] += cnt[b];
			return cnt[a];
		} else {
			p[a] = b;
			cnt[b] += cnt[a];
			if (r[a] == r[b])
				r[b]++;

			return cnt[b];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			N = sc.nextInt();
			String key;
			Integer val;
			int id = 0, u, v;

			make_set();
			for (int i = 0; i < N; i++) {
				key = sc.next();
				val = map.get(key);
				if (val == null) {
					u = id;
					map.put(key, id++);
				} else
					u = val;
				key = sc.next();
				val = map.get(key);
				if (val == null) {
					v = id;
					map.put(key, id++);
				} else
					v = val;

				System.out.println(union(u, v));
			}
		}

		sc.close();
	}
}
