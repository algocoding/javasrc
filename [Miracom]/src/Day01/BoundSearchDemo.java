package Day01;

public class BoundSearchDemo {
	// key와 같거나 작은 값 중 최대값의 위치 찾기
	// arr[]: 자료들, lo:시작 위치, hi: 끝 위치
	static int lower_bound(int arr[], int key)
	{
	    int lo = 0, hi = arr.length; // 주의> hi는 N으로 설정
	    while (lo < hi)
	    {
	        int mid = (lo + hi) / 2; // 중간 위치

	        if (key > arr[mid])      // 오른쪽에서 탐색
	            lo = mid + 1;
	        else                     // key <= arr[mid]
	            hi = mid;            // 왼쪽에서 탐색
	    }
	    return lo;
	}
	// key 보다 큰 값중에 최소값의 위치 찾기
	static int upper_bound(int arr[], int key)
	{
	    int lo = 0, hi = arr.length; // 주의> hi는 N으로 설정
	    while (lo < hi)
	    {
	        int mid = (lo + hi) / 2; // 중간 위치

	        if (key >= arr[mid])     // 오른쪽에서 탐색
	            lo = mid + 1;
	        else                     // key <= arr[mid]
	            hi = mid;            // 왼쪽에서 탐색
	    }
	    return lo;
	}
	
	public static void main(String[] args){
		int arr[] = new int[]{1, 2, 3, 3, 5, 5, 5, 5, 7, 7, 9, 9, 10, 12, 13, 10};
		
		// 5에서 10 사이의 값은 몇개인가?
		int lo = lower_bound(arr, 5);
		int hi = upper_bound(arr, 10);
		System.out.println(hi - lo);
	}
}
