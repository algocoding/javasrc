import java.util.*;

// https://www.acmicpc.net/problem/10815
// 이분 탐색


public class NumberCard 
{
	static final int MAXN = 500000;
	static final int MAXM = 500000;
	static int[] nums;

	static boolean binarySearch(int key, int lo, int hi)
	{
		if(lo > hi) return false;
		int mid = (lo + hi)/2;
		
		if(key < nums[mid]) return binarySearch(key, lo, mid - 1);
		else if(key > nums[mid]) return binarySearch(key, mid + 1, hi);
		else return true;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int N, M;
		N = sc.nextInt();		
		nums = new int[N];
		for(int i = 0; i < N; i++)
			nums[i] = sc.nextInt();
		Arrays.sort(nums);
		
		M = sc.nextInt();
		
		for(int i = 0; i < M; i++)
		{
			int key = sc.nextInt();
			//if(binarySearch(key, 0, N - 1))
			if(Arrays.binarySearch(nums, key) >= 0) // 키가 있다면
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
		
		sc.close();
	}
}
