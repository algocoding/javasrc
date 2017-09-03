package Day05;
import java.util.Scanner;
	
public class KMP 
{
	static int[] next;
	
	static String t;
	static String p;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		t = sc.nextLine(); 
		p = sc.nextLine(); 
		next = new int[p.length() + 1];
		
		int n = t.length(); int m = p.length();
		t = t + "\0";
		p = p + "\0";
		next[0]= -1;
		int i = 0, j = -1;
		
		while(i < m)
		{
			while(j >= 0 && p.charAt(j) != p.charAt(i))
				j = next[j];
			i++; j++;
			next[i] = j;
		}
		
		i = 0; j = 0;		
		while(i < n)
		{
			while(j >= 0 && p.charAt(j) != t.charAt(i))
				j = next[j];
			i++; j++;
			if(j == m)
			{
				System.out.println(t.substring(i - j));
				break;
			}
		}
		sc.close();
	}
}
