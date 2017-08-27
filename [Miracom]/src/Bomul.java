// 보물 - https://www.acmicpc.net/problem/1026

import java.util.*;

public class Bomul {

	static int[] A;
	static int[] B;
	static void swap(int[] arr, int i, int j)
	{
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		A = new int[N];
		B = new int[N];
		for(int i = 0; i < N; i++)		
			A[i] = sc.nextInt(); 
		for(int i = 0; i < N; i++)		
			B[i] = sc.nextInt();

		// 선택 정렬 수행
		for(int i = 0; i < N - 1; i++)
		{
			int min = i, max = i;
			for(int j = i + 1; j < N; j++)
			{
				if(A[min] > A[j]) min = j;
				if(B[max] < B[j]) max = j;
			}
			swap(A, min, i);
			swap(B, max, i);
		}
		int sum = 0;
		for(int i = 0; i < N; i++)
			sum += A[i] * B[i];
		System.out.println(sum);
		sc.close();
	}

}
