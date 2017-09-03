package Day05;

import java.util.*;

public class TreeTraversal {
	static int N;
	static int[] pre = null;
	static int[] in = null;
	
	public static void printPostorder(int prestart, int preend, int instart, int inend)
	{
		if(prestart > preend || instart > inend) return;
		if(prestart == preend) System.out.print(pre[prestart] + " ");
		
		
		int L;
		for(L = instart; L <= inend; L++)
			if(in[L] == pre[prestart]) break;
		int size = L - instart;
		
		printPostorder(prestart + 1, prestart + size, instart, L - 1);
		printPostorder(prestart + size + 1, preend, L + 1, inend);
		System.out.print(pre[prestart] + " ");
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		N = sc.nextInt();
		pre = new int[N];
		in = new int[N];
		for(int i = 0; i < N; i++)
			pre[i] = sc.nextInt();
		for(int i = 0; i < N; i++)
			in[i] = sc.nextInt();
		
		printPostorder(0, N - 1, 0, N - 1);
		
		sc.close();
		
	}

}
