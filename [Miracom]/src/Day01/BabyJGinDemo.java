package Day01;

import java.util.*;

public class BabyJGinDemo {
	
	static boolean ByGreedy(int[] arr)
	{
		int[] cnt = new int[10];	// 카드 숫자 세기
		for(int i = 0; i < 6; i++)
			cnt[arr[i]]++;

		int run = 0, tri = 0;
		for(int i = 0; i < 10; i++)
		{
			while(i <= 7 && cnt[i] != 0 && cnt[i + 1] != 0 && cnt[i + 2] != 0)
			{
				run++; cnt[i]--; cnt[i + 1]--; cnt[i + 2]--;
			}
			while(cnt[i] >= 3)
			{
				tri++; cnt[i] -= 3;
			}
		}		
		return ((run + tri) == 2);
	}
	static boolean ByPermutation(int[] arr)
	{
		for (int x1 = 0; x1 < 6; x1++)
		for (int x2 = 0; x2 < 6; x2++) if (x2 != x1)
		for (int x3 = 0; x3 < 6; x3++) if (x3 != x1 && x3 != x2)
		for (int x4 = 0; x4 < 6; x4++) if (x4 != x1 && x4 != x2 && x4 != x3)
		for (int x5 = 0; x5 < 6; x5++) if (x5 != x1 && x5 != x2 && x5 != x3 && x5 != x4)
		for (int x6 = 0; x6 < 6; x6++) if (x6 != x1 && x6 != x2 && x6 != x3 && x6 != x4 && x6 != x5)
		{
			int run = 0, tri = 0;
			if(arr[x1] + 1 == arr[x2] && arr[x2] + 1 == arr[x3]) run++;
			if(arr[x4] + 1 == arr[x5] && arr[x5] + 1 == arr[x6]) run++;
			if(arr[x1] == arr[x2] && arr[x2] == arr[x3]) tri++;
			if(arr[x4] == arr[x5] && arr[x5] == arr[x6]) tri++;
			if((run + tri) == 2) return true;
		}
		return false; 
	}
	static boolean ByCombination(int[] arr)
	{
		Arrays.sort(arr);			// 정렬해서 순서대로 선택하기		
		for(int i = 0; i < 6; i++)
		for(int j = i + 1; j < 6; j++)
		for(int k = j + 1; k < 6; k++)
		{
			// i, j, k 조사
			int run = 0, tri = 0;
			if(arr[i] + 1 == arr[j] && arr[j] + 1 == arr[k]) run++;			
			if(arr[i] == arr[j] && arr[j] == arr[k]) tri++;
			
			// 나머지 숫자들 조사
			int[] A = new int[3];
			int idx = 0;
			for(int n = 0; n < 6; n++)
				if(n != i && n != j && n != k) 
					A[idx++] = arr[n];
			
			if(A[0] + 1 == A[1] && A[1] + 1 == A[2]) run++;			
			if(A[0] == A[1] && A[1] == A[2]) tri++;
			if((run + tri) == 2) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
		int[] arr1 = new int[]{6, 7, 7, 5, 7, 4};
		int[] arr2 = new int[]{0, 0, 1, 2, 0, 1};

		System.out.println(ByGreedy(arr1));
		System.out.println(ByGreedy(arr2));
		System.out.println(ByPermutation(arr1));
		System.out.println(ByPermutation(arr2));
		System.out.println(ByCombination(arr1));
		System.out.println(ByCombination(arr2));
	}

}
