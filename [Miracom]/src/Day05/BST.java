package Day05;

public class BST <T extends Comparable<? super T>>
{
	// 노드 클래스
	private static class Node<T> 
	{
		T	key;
		Node<T> left;
		Node<T> right;
		Node(T val){ this(val, null, null);}
		Node(T val, Node<T> l, Node<T> r){
			key = val; left = l; right = r;
		}
	}
	private Node<T> root;
	public BST(){ root = null;}
	
	public void makeEmpty(){ root = null;}
	public boolean isEmpty(){ return root == null;}
	
	// x 값 검색
	public boolean contains(T x) { return contains(x, root); }
	
	// 최소값 찾기
	public T findMin() throws Exception{
		if(isEmpty()) throw new Exception();
		return findMin(root).key;
	}
	
	// x 값 삽입
	public void insert(T x){ root = insert(x, root); }
	
	//x값 삭제
	public void remove(T x){ root = remove(x, root); }
	
	private boolean contains(T x, Node<T> t)
	{
		if(t == null) return false;
		int ret = x.compareTo(t.key);
		
		if(ret < 0) return contains(x, t.left);
		else if(ret > 0) return contains(x, t.right);
		else return true;
		
	}
	private Node<T> findMin(Node<T> t){
		if(t == null) return null;
		else if(t.left == null)  return t;
		else return findMin(t.left);
		
	}
	private Node<T> insert(T x, Node<T> t)
	{
		if(t == null) return new Node<T>(x, null, null);
		
		int ret = x.compareTo(t.key);
		if(ret < 0) t.left = insert(x, t.left);
		else if(ret > 0) t.right = insert(x, t.right);
		
		return t;
	}
	private Node<T> remove(T x, Node<T> t)
	{
		if(t == null) return null;
		
		int ret = x.compareTo(t.key);
		
		if(ret < 0) t.left = remove(x, t.left);
		else if(ret > 0) t.right = remove(x, t.right);
		else if(t.left != null && t.right != null)
		{
			t.key = findMin(t.right).key;
			t.right = remove(t.key, t.right);
		}else
			t = (t.left != null)? t.left:t.right;
		return t;
	}
}
