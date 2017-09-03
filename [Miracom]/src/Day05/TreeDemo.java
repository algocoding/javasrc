package Day05;
import java.util.*;

public class TreeDemo {
	static int[] L = new int[100];	// 왼쪽 자식
	static int[] R = new int[100];	// 오른쪽 자식
	static int[] P = new int[100];	// 부모	
	static int V, E;	// 노드수, 간선수	
	
	public static void bfsWithQ(int v)
	{
		System.out.println("트리의 너비우선탐색_Queue<>> ");
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(v);
		
		while(!Q.isEmpty())
		{
			v = Q.remove();
			System.out.printf("%d ", v);
			if(L[v] != 0) Q.add(L[v]);
			if(R[v] != 0) Q.add(R[v]);
		}
	}
	public static void bfs(int v)
	{
		System.out.println("트리의 너비우선탐색> ");
		int[] Q = new int[100];
		int front = -1, rear = -1;
		
		Q[++rear] = v;
		while(front != rear)
		{
			v = Q[++front];
			System.out.printf("%d ", v);
			if(L[v] != 0) Q[++rear] = L[v];
			if(R[v] != 0) Q[++rear] = R[v];
		}
	}
	public static int tree_size(int v)
	{
		if(v == 0) return 0;
		int size = 1;
		size += tree_size(L[v]);
		size += tree_size(R[v]);
		
		return size;
	}
	public static int tree_height(int v)
	{
		if(v == 0) return -1;
		
		int lh = tree_height(L[v]);
		int rh = tree_height(R[v]);
		
		return lh > rh? lh + 1: rh + 1;
	}
	
	public static void inorder(int v)
	{
		if(v == 0) return;
	
		inorder(L[v]);
		System.out.printf("%d ", v);
		inorder(R[v]);		
	
	}
	
	public static void main(String[] args)	{		
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		int parent, child;
		for(int i = 0; i < E; i++)
		{
			parent = sc.nextInt();
			child = sc.nextInt();
			if(L[parent] == 0) L[parent] = child;
			else R[parent] = child;
			P[child] = parent;			
		}
		sc.close();
		
		inorder(1); System.out.print('\n');		
		
		System.out.printf("트리의 높이 = %d\n", TreeDemo.tree_height(1));
		System.out.printf("트리의 크기 = %d\n", TreeDemo.tree_size(1));
		
		bfs(1); System.out.print('\n');
		bfsWithQ(1); System.out.print('\n');
	}
}
