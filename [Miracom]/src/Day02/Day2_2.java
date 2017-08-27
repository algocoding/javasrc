package Day02;

import java.util.*;

// Dijkstra + 배열 사용
public class Day2_2 {
	static int N;								// 맵 크기
	static int[][] G = new int[100][100];		// 맵 정보
	static int[][] D = new int[100][100];		// 거리
	static boolean[][] visited = new boolean[100][100];	 // 방문 정보
	static int[] dx = new int[]{0, 0, 1, -1};
	static int[] dy = new int[]{1, -1, 0, 0};
	
	//	간선 완화
	static void edgeRelaxation(int x, int y)
	{
		for(int i = 0; i < 4; i++)
		{
			int tx = x + dx[i]; 
			int ty = y + dy[i];
			if(tx < 0 || tx == N || ty < 0 || ty == N) continue;
			if(visited[tx][ty] == false && D[tx][ty] > D[x][y] + G[tx][ty])
				D[tx][ty] = D[x][y] + G[tx][ty];
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
			D[0][0] = 0; 
			visited[0][0] = true;
			edgeRelaxation(0, 0);	// 시작점에 대해 간선 완화
			
			// 정점의 수 만큼 간선 완화
			int cnt = N * N - 1;
			while(cnt-- > 0)
			{
				// visited[][] == false && D[][] 가 최소인 좌표 찾기
				int x = 0, y = 0, min = 0xffffff;
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(visited[i][j] == false && D[i][j] < min){
							min = D[i][j]; x = i; y = j;
						}
					}
				}
				
				visited[x][y] = true; 	// (x,y)에 대한 최단 경로가 확정된다. 
				//if(x == N - 1 && y == N - 1) break;
				
				edgeRelaxation(x, y);
			}
			
			System.out.println(D[N-1][N-1]);
		}
		
		sc.close();
	}
}
