package Day03;

import java.util.LinkedList;
import java.util.Queue;

public class SubsetBFSDemo {

	static char[] str;
	static boolean[] bits;	
	static int cnt = 0, N = 0;
	
	public static class Node{
		int bits;
		int k;
		Node(int b, int k){
			bits = b; this.k = k;
		}
	}
	public static void subsetBFS()
	{
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(new Node(0, 0));
		
		while(!Q.isEmpty())
		{
			Node curr = Q.poll();
			
			if(curr.k == N)
			{
				for(int i = 0; i < N; i++)
				{
					if((curr.bits  & (1 << i)) == 0) System.out.print(0);
					else System.out.print(1);					
				}
				System.out.println();
			}else{
				Node left = new Node((curr.bits | (1 << curr.k)),  curr.k + 1);
				Q.add(left);
				Node right = new Node(curr.bits,  curr.k + 1);
				Q.add(right);
			}
		}
	}
	
	public static void main(String[] args) {
		String tmp = new String("ABCDE");
		str = tmp.toCharArray();
		N = tmp.length();
		subsetBFS();
		
	}

}
