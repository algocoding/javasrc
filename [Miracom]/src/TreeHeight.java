
// 트리의 높이와 너비 https://www.acmicpc.net/problem/2250
// 틀린 부분 수정하기

import java.util.*;

public class TreeHeight {

	static int[] r = new int[10001];
	static int[] l = new int[10001];
	static int[][] minmax = new int[10002][2];
	static boolean[] p = new boolean[10001];
	static int cnt = 0, maxH = 0;

	static void inorder(int v, int h) {
		if (v == -1) return;
		inorder(l[v], h + 1);
		// ----------------------------
		cnt++;
		if (minmax[h][0] > cnt) minmax[h][0] = cnt;
		if (minmax[h][1] < cnt)	minmax[h][1] = cnt;

		// ----------------------------
		inorder(r[v], h + 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int node, left, right;

		for (int i = 1; i <= N; i++) {
			minmax[i][0] = 0xffffff;
			minmax[i][1] = 0;
		}
		for (int i = 0; i < N; i++) {
			node = sc.nextInt();
			left = sc.nextInt();
			right = sc.nextInt();
			l[node] = left;
			r[node] = right;
			if(left != -1) p[left] = true;
			if(right != -1) p[right] = true;
		}
		for(int i = 1; i <= N; i++)
		{
			if(p[i] == false)
			{
				inorder(i, 1);
				break;
			}
		}
		int max = 0, height = 1;
		for (int i = 1; i <= N; i++) {
			int width = minmax[i][1] - minmax[i][0] + 1;
			if (max < width) {
				max = width;
				height = i;
			}
		}
		System.out.printf("%d %d\n", height, max);

		sc.close();
	}
}
