package Day01;
public class BinarySearachDemo {

	static int Search(int[] arr, int key, int lo, int hi)
	{
	    while(lo <= hi)
	    {        
	        int mid = (lo + hi) / 2;    // 중간 위치

	        if ( key == arr[mid])       // 성공
	            return mid;
	        else if (key < arr[mid])    // 왼쪽에서 탐색
	            hi = mid - 1;
	        else                        // 오른쪽에서 탐색
	            lo = mid + 1;
	    }
	    return -1;						// 탐색 실패
	}
	static int SearchRecur(int[] arr, int key, int lo, int hi)
	{
	    if(lo > hi) return -1;		// 탐색 실패
	            
        int mid = (lo + hi) / 2;    // 중간 위치

        if ( key == arr[mid])       // 성공
            return mid;
        else if (key < arr[mid])    // 왼쪽에서 탐색
            return SearchRecur(arr, key, lo, mid - 1);
        else                        // 오른쪽에서 탐색
        	return SearchRecur(arr, key, mid + 1, hi);
	}
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 5, 8, 9, 10, 11, 14, 17, 22, 24, 46, 47, 51};
		
		System.out.println(Search(arr, 46, 0, arr.length - 1));
		System.out.println(Search(arr, 4, 0, arr.length - 1));
		System.out.println(SearchRecur(arr, 46, 0, arr.length - 1));
		System.out.println(SearchRecur(arr, 4, 0, arr.length - 1));
	}
}
