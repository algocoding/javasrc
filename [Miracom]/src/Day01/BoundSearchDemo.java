package Day01;

public class BoundSearchDemo {
	// key�� ���ų� ���� �� �� �ִ밪�� ��ġ ã��
	// arr[]: �ڷ��, lo:���� ��ġ, hi: �� ��ġ
	static int lower_bound(int arr[], int key)
	{
	    int lo = 0, hi = arr.length; // ����> hi�� N���� ����
	    while (lo < hi)
	    {
	        int mid = (lo + hi) / 2; // �߰� ��ġ

	        if (key > arr[mid])      // �����ʿ��� Ž��
	            lo = mid + 1;
	        else                     // key <= arr[mid]
	            hi = mid;            // ���ʿ��� Ž��
	    }
	    return lo;
	}
	// key ���� ū ���߿� �ּҰ��� ��ġ ã��
	static int upper_bound(int arr[], int key)
	{
	    int lo = 0, hi = arr.length; // ����> hi�� N���� ����
	    while (lo < hi)
	    {
	        int mid = (lo + hi) / 2; // �߰� ��ġ

	        if (key >= arr[mid])     // �����ʿ��� Ž��
	            lo = mid + 1;
	        else                     // key <= arr[mid]
	            hi = mid;            // ���ʿ��� Ž��
	    }
	    return lo;
	}
	
	public static void main(String[] args){
		int arr[] = new int[]{1, 2, 3, 3, 5, 5, 5, 5, 7, 7, 9, 9, 10, 12, 13, 10};
		
		// 5���� 10 ������ ���� ��ΰ�?
		int lo = lower_bound(arr, 5);
		int hi = upper_bound(arr, 10);
		System.out.println(hi - lo);
	}
}
