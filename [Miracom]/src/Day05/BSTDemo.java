package Day05;
public class BSTDemo {

	public static void main(String[] args)
	{
		System.out.println("BST demo......");
		
		BST<Integer> bst = new BST<Integer>();
		
		bst.insert(10);
		bst.insert(12);
		bst.insert(6);
		bst.insert(22);
		bst.insert(2);
		bst.insert(7);
		bst.insert(2);
		bst.insert(19);
		
		System.out.println(bst.contains(13));
		System.out.println(bst.contains(6));
		
		bst.remove(13);
		System.out.println(bst.contains(13));
	}
}
