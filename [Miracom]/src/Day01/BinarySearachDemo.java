package Day01;
public class BinarySearachDemo {

	static int Search(int[] arr, int key, int lo, int hi)
	{
	    while(lo <= hi)
	    {        
	        int mid = (lo + hi) / 2;    // �߰� ��ġ

	        if ( key == arr[mid])       // ����
	            return mid;
	        else if (key < arr[mid])    // ���ʿ��� Ž��
	            hi = mid - 1;
	        else                        // �����ʿ��� Ž��
	            lo = mid + 1;
	    }
	    return -1;						// Ž�� ����
	}
	static int SearchRecur(int[] arr, int key, int lo, int hi)
	{
	    if(lo > hi) return -1;		// Ž�� ����
	            
        int mid = (lo + hi) / 2;    // �߰� ��ġ

        if ( key == arr[mid])       // ����
            return mid;
        else if (key < arr[mid])    // ���ʿ��� Ž��
            return SearchRecur(arr, key, lo, mid - 1);
        else                        // �����ʿ��� Ž��
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
