/* �Է¿�
10
321 1
4757 1
32888 2
757148 1
768466 3
777770 5
436659 2	
437859 7	
112233 4
111111 10
*/
package Day01;
import java.util.*;

public class Day1_2FindMaxDemo3 {
	
	static int d[] = {1, 10, 100, 1000, 10000, 100000};

	static int swap(int x, int i, int j)
	{
		int a = (x / d[i]) % 10;
		int b = (x / d[j]) % 10;
		return x - a*d[i] + a*d[j] - b*d[j] + b*d[i];
	}
	static class Node{
		int n, k;
		Node(int _n, int _k){
			n = _n; k = _k;
		}
	}
	
	public static void main(String[] args)
	{
		//Scanner sc = new Scanner(new File("day1_2.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long start = System.currentTimeMillis();
		
		for(int tc = 1; tc <= N; tc++)
		{
			int x = sc.nextInt();	// ����
			int s = sc.nextInt();	// ��ȯ Ƚ��
			
			int len = 0, t = x;
			while (t != 0) { t /= 10; len++;}

			int max = x;
			Node[] Q = new Node[10000];
			
			int front, rear;
			front = rear = -1;
			Q[++rear] = new Node(x, 0);
			
			while(front != rear)
			{
				Node cur = Q[++front];
				
				if(cur.k == s)
				{
					if(cur.n > max) max = cur.n;
				}else{
					for(int i = 0; i < len - 1; i++) {
						for(int j = i + 1; j < len; j++) {
							
							int n = swap(cur.n, i, j);
							int k = cur.k + 1;
							for(int it = rear; it > front; it--)
							{
								if((Q[it].k == k) && (Q[it].n == n)) { 
									n = 0; 
									//System.out.println("�ߺ�.......\n");
									break;
								}
							}							
							if(n != 0) Q[++rear] = new Node(n, k);
						}
					}
				}
			}			
			System.out.printf("#%d %d %d\n", tc, max, rear);
			if(tc == 9)
			System.out.println( "���� �ð� : " + ( System.currentTimeMillis() - start )/1000.0 ); 
		}
		sc.close();

		long end = System.currentTimeMillis();
		System.out.println( "���� �ð� : " + ( end - start )/1000.0 ); 
	}
}
