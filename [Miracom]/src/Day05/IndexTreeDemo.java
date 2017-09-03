/*
5
9 8 5 7 2
 */
package Day05;

import java.util.Scanner;

public class IndexTreeDemo {
	static int[] IDT = new int[1 << 18];
	static int N;
	static int base;
	void update(int p, int val)
	{
		int diff = val - IDT[p];  
		IDT[p] = val;		
		p >>= 1;
		while(p > 0)
		{
			IDT[p] += diff;
			p >>= 1;
		}
	}
	static int query(int a, int b)
	{
		a = base + a - 1;
		b = base + b - 1;
		int sum = 0;
		while(a < b)
		{
			if((a & 1) != 0) {
				sum += IDT[a];
				a++;
			}
			if((b & 1) == 0) {
				sum += IDT[b];
				b--;
			}
			a >>= 1; b >>= 1;		
		}
		if(a == b) sum += IDT[a];
		return sum;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		base = 1;
		while(base < N)
			base <<= 1;
		
		for(int i = base; i < N + base; i++)
			IDT[i] = sc.nextInt();
		
		for(int i = base - 1; i >= 1; i--)
			IDT[i] = IDT[i << 1] + IDT[(i << 1) + 1];
		
		System.out.println(query(2, 5));
		sc.close();
	}
}
