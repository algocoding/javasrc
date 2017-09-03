package Day05;
// 이진 힙

public class Heap {
	static int SIZE = 100;
	static int[] heap = new int[SIZE];  
	static int hsize;
	static void init(){ hsize = 0;}
	static boolean isEmpty(){ return hsize == 0;}
	static boolean insert(int item)
	{
		if(hsize == SIZE - 1) return false;
		
		heap[++hsize] = item;
		int c = hsize, p = c / 2;
		while(p > 0 && heap[p] > heap[c])
		{
			int tmp = heap[p]; heap[p] = heap[c]; heap[c] = tmp;
			
			c = p;
			p = c / 2;
		}
		return true;
	}
	static int get()
	{
		int ret = heap[1];
		heap[1] = heap[hsize--];
		
		int p = 1, c = p * 2;
		while(c <= hsize)
		{
			if(c + 1 <= hsize && heap[c] > heap[c+1]) // 오른쪽이 더 작은 값인지 체크
				c++;
			if(heap[p] > heap[c])
			{
				int tmp = heap[p]; heap[p] = heap[c]; heap[c] = tmp;
				p = c;
				c = p*2;
			}else break;
			
		}
		return ret;
	}
	public static void main(String[] args) {
		int[] arr = new int[]{ 23, 45, 2, 5, 88, 12, 7, 49, 45, 16 };

		for(int val: arr) insert(val);
		
		while(!isEmpty())
		{
			System.out.println(get());
		}
		
	}

}
