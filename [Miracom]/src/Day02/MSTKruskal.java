/*
 * A ~ G 까지의 정점을 1 ~ 7로 표기
입력> 7(정점수), 8(간선수)
-----------------------------------------
7 11 
1 2 3
1 3 17
1 4 6
2 4 5
2 7 12
3 5 10
3 6 8 
4 5 9
5 6 4
5 7 2
6 7 14 
-----------------------------------------
*/
package Day02;
import java.util.*;

public class MSTKruskal {
	static int[] p = null;		// Disjoint-set 부모 저장
	static int[] r = null;		// 랭크값 저장	
	static int V,  E;			// 정점수, 간선수
	
	// 간선 정보를 위한 Edge 클래스
	public static class Edge implements Comparable<Edge>{
		int u, v, w;
		Edge(int _u, int _v, int _w){ u = _u; v = _v; w = _w;}
		
		public int compareTo(Edge arg) {
			return w - arg.w;			
		}
		public String toString()
		{
			return "(" + u + "-" + v + ", " + w + ")";
		}
	}
	// 모든 간선들 저장
	static LinkedList<Edge> edges = new LinkedList<Edge>();
	// 트리를 구성하는 간선 저장
	static LinkedList<Edge> tree = new LinkedList<Edge>();
	
	//---------------------------------------------
	// Disjoint-Set
	public static void make_set()
	{
		p = new int[V + 1];		
		r = new int[V + 1];
		
		for(int i = 1; i <= V; i++)
		{
			p[i] = i;
			r[i] = 0;
		}
	}
	public static int find_set(int x)
	{
		if( x != p[x]) p[x] = find_set(p[x]);
		
		return p[x]; 
	}
	public static void union(int x, int y)
	{
		int a = find_set(y); 
		int b = find_set(x);
		if(a == b) return;
		
		if(r[a] > r[b]) 
			p[b] = a;
		else {
			p[a] = b;
			if(r[a] == r[b]) r[b]++;
		}
	}
	//---------------------------------------------
	
	public static int kruskal()	// MST 가중치 합 반환
	{
		int cost = 0;			// 가중치 합 저장
		
		Collections.sort(edges);// 간선 정렬
		
		make_set();				// Disjoint-Set 초기화
		
		int cnt = V - 1;		// 정점수 - 1 개	
		
		while(cnt > 0)
		{
			Edge e = edges.removeFirst(); // 가중치 순으로 간선을 가져온다.
			
			int a = find_set(e.u);		// u, v 집합의 대표자 찾기
			int b = find_set(e.v);
			
			if(a == b) continue;		// 같은 집합이면 Skip
			
			union(a, b);				// 다른 집합이면 합친다.
			cost += e.w;
			
			tree.add(e);				// 선택된 간선을 저장
			cnt--;
		}
		return cost;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		int u, v, w;
		for(int i = 0; i < E; i++)
		{
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();				
			edges.add(new Edge(u, v, w));
		}
								
		System.out.println("MST 가중치 합> " + kruskal());
		for(Edge e: tree)
			System.out.println(e);
		sc.close();
	}
}
