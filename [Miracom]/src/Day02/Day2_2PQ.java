package Day02;

import java.util.*;

// Dijkstra + 우선 순위 큐 사용
public class Day2_2PQ {
	static int N;								// 맵 크기
	static int[][] G = new int[100][100];		// 맵 정보
	static int[][] D = new int[100][100];		// 거리
	static boolean[][] visited = new boolean[100][100];	// 방문 정보	
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	
	// 우선 순위 큐에 저장되는 정보
	private static class Vertex implements Comparable<Vertex>{
		int x, y, d; 		// (x, y)좌표, D[x][y]
		Vertex(int _x, int _y, int _d){
			x = _x; y = _y; d = _d;
		}
		public int compareTo(Vertex arg) {			 
			return d - arg.d;
		}		
	}
	static PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();	
	
	//	간선 완화
	static void edgeRelaxation(int x, int y)
	{
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i]; 
			int ty = y + dy[i];
			if(tx < 0 || tx == N || ty < 0 || ty == N) continue;
			if(D[tx][ty] > D[x][y] + G[tx][ty])
			{
				D[tx][ty] = D[x][y] + G[tx][ty];
				Q.add(new Vertex(tx, ty, D[tx][ty]));
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();		// 입력수
		
		while(T-- > 0)
		{
			N = sc.nextInt();		// 맵 크기
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					G[i][j] = str.charAt(j) - '0';
					D[i][j] = 0xffffff;
					visited[i][j] = false;
				}
			}
			
			D[0][0] = 0;			// (0, 0): 시작점 
			visited[0][0] = true;
			Q.add(new Vertex(0, 0, 0));
			
			while(!Q.isEmpty())
			{
				Vertex cur = Q.poll();
				
				if(cur.d > D[cur.x][cur.y]) continue;
				
				//if(cur.x == N - 1 && cur.y == N - 1) break;
				
				edgeRelaxation(cur.x, cur.y);	// 간선 완화
			}
			
			System.out.println(D[N-1][N-1]);
		}
		
		sc.close();
	}
}
