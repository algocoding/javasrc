package Day01;

import java.util.*;

public class SortingDemo {
	
	public static void main(String[] args) {
		
		//BubbleSort(arr);
		//SelectionSort(arr);
		//InsertionSort(arr);
		//QuickHoare(arr, 0, arr.length - 1);		
		//MergeSort(arr, sorted, 0, arr.length - 1);
		//RadixSort(arr);
		
		CountingSort();
			
	}
	static int[] arr = new int[]{23, 45, 2, 5, 88, 12, 7, 49, 45, 16};
	
	static void swap(int[] arr, int i, int j){
		int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
	}
	
	//----------------------------------------------------------
	static void BubbleSort(int arr[])
	{
		for(int i = arr.length - 2; i >= 0; i--)
		{
			for(int j = 0; j <= i; j++)
				if(arr[j] > arr[j + 1]) 
					swap(arr, j, j + 1);
		}
	}
	//----------------------------------------------------------
	static void SelectionSort(int arr[])
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			int min = i;
			for(int j = i + 1; j < arr.length; j++)
				if(arr[min] > arr[j]) 
					min = j;
			swap(arr, i, min);
		}
	}
	//----------------------------------------------------------
	static void InsertionSort(int arr[])
	{
		for(int i = 1; i < arr.length; i++)
		{
			int j, val = arr[i];
			
			for(j = i - 1; j >= 0 && val < arr[j]; j--)			
				arr[j + 1] = arr[j];				
			
			arr[j + 1] = val;
		}
	}
	//----------------------------------------------------------
	static void QuickHoare(int arr[], int lo, int hi)
	{
		if(lo < hi){
			
			int i = lo, j = hi;
			
			while(i < j){				
				while(i <= hi && arr[i] <= arr[lo]) i++;
				while(arr[j] > arr[lo]) j--;
				
				if(i >= j) break;
				
				swap(arr, i, j);
			}
			swap(arr, lo, j);
			QuickHoare(arr, lo, j - 1);
			QuickHoare(arr, j + 1, hi);
		}
	}
	//----------------------------------------------------------
	static int[] sorted =  new int[arr.length]; 
	static void MergeSort(int[] arr, int[] sorted, int lo, int hi){
		
		if(lo == hi) return;
		
		int mid = (lo + hi) / 2;
		
		MergeSort(arr, sorted, lo, mid);
		MergeSort(arr, sorted, mid + 1, hi);
		
		int i = lo, j = mid + 1, k = lo;
		while(i <= mid && j <= hi)
		{
			if(arr[i] < arr[j]) sorted[k++] = arr[i++];
			else sorted[k++] = arr[j++];
		}
		if(i <= mid) 
			while(i <= mid) sorted[k++] = arr[i++];
		else
			while(j <= hi) sorted[k++] = arr[j++];
		
		for(int idx = lo; idx <= hi; idx++)
			arr[idx] = sorted[idx];
	}
	//----------------------------------------------------------	
	static void RadixSort(int[] arr)
	{
		Vector<Integer>[] Q = new Vector[10];
		for(int i = 0; i < 10; i++)
			Q[i] = new Vector<Integer>();
		
		int max = 0;
		for(int i = 1; i < arr.length; i++)
			if(arr[max] < arr[i]) max = i;
		
		int len = 0, n = arr[max];
		while(n > 0){
			len++; n /= 10; 
		}
		for(int i = 0, d = 1; i < len; i++, d *= 10)
		{
			for(int j = 0; j < arr.length; j++)
				Q[(arr[j]/d)%10].add(arr[j]);
			
			int idx = 0;
			for(int j = 0; j < 10; j++)
				while(!Q[j].isEmpty()) 
					arr[idx++] =Q[j].remove(0);
		}
	}
	//----------------------------------------------------------
	static int[] A = new int[]{5, 1, 3, 3, 3, 2, 1, 5, 1};
	static int[] B = new int[A.length];
	static int[] cnt = new int[6]; // 1 <= 자료값 <= 5
	static void CountingSort()
	{
		// cnt[]는 0으로 초기화 된 상태
		for(int i = 0; i < A.length; i++)
			cnt[A[i]]++;
		
		for(int i = 1; i <= 5; i++)
			cnt[i] += cnt[i - 1];
		
		for(int i = A.length - 1; i >= 0; i--)
		{
			cnt[A[i]]--;
			B[cnt[A[i]]] = A[i];
		}
		
		for(int val: B) System.out.print(val + " ");
	}
}
