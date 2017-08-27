package Day01;
import java.util.*;

public class HashingDemo {

	static Node[] S = new Node[10000];	
	static int M = 123456;
	
	static class Node 
	{
		String str;
		int len;
		int[] hash;
		Node(String s){
			str = s;
			len = str.length();
			hash = new int[len];
			calcHash();
		}
		void calcHash()
		{
			int h = 0;
			for(int i = 0; i < len; i++)
			{
				h = ((h * 10) + str.charAt(i)) % M;
				hash[i] = h;
			}			
		}
		int getHash(int N){
			return hash[N - 1];
		}
	}
	static Comparator<Node> compareNode = new Comparator<Node>(){		
		public int compare(Node arg0, Node arg1) {		
			return arg0.len - arg1.len;
		}
	};
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);		
		
		int T = sc.nextInt();
		while(T-- > 0)
		{
			int N = sc.nextInt();
			
			for(int i = 0; i < N; i++)			
				S[i] = new Node(new String(sc.next()));				
			
			// 길이순으로 정렬
			Arrays.sort(S, 0, N, compareNode);
			
			boolean ans = true;
			for(int i = 0; i < N - 1; i++)
			{
				for(int j = i + 1; j < N; j++)
				{
					if(S[i].len == S[j].len) continue;	
					
					if(S[i].getHash(S[i].len) == S[j].getHash(S[i].len))
					{
						if(S[j].str.startsWith(S[i].str))
						{
							ans = false; i = N; break;
						}
					}
					
				}
			}
			if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
		sc.close();
	}
}
