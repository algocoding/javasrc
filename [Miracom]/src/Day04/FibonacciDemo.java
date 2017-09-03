package Day04;

public class FibonacciDemo {
	static int fibonacci(int n)
	{
		if(n < 2) return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	//--------------------------------------------
	static int[] table;
	static int fibonacci_memo(int n)
	{
		if(n >= 2 && table[n] == 0) 
			table[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return table[n];
	}
	//--------------------------------------------
	static int fibonacci_iter(int n)
	{
		int[] fibo = new int[n + 1];
		fibo[0] = 0; fibo[1] = 1;
		for(int i = 2; i <= n; i++)
			fibo[i] = fibo[i-1] + fibo[i-2];
		return fibo[n];
	}
	//--------------------------------------------
	static long fibonacci_iter_notable(int n)
	{
		long curr = 0, ppred = 0, pred = 1;
		for(int i = 2; i <= n; i++)
		{
			curr = pred + ppred;
			ppred = pred;
			pred = curr;
		}
		return curr;
	}
	public static void main(String[] args) {

		System.out.println(fibonacci(40));
		table = new int[100];
		table[0] = 0; table[1] = 1;
		System.out.println(fibonacci_memo(40));
		System.out.println(fibonacci_iter(40));
		System.out.println(fibonacci_iter_notable(40));
	}
}
