package in.conceptarchitect.collections;

import java.util.Iterator;

public class IntTree implements Collection<Integer>{
	
	class Node{
		public Node(Integer value) {
			// TODO Auto-generated constructor stub
			this.value=value;
		}
		int value;
		Node left;
		Node right;
	}
	
	Node root;
	int count=0;
	
	
	@Override
	public void add(Integer value) {
		// TODO Auto-generated method stub
		root=add(root,value);
	}
	
	
	
	private Node add(Node root, Integer value) {
		// TODO Auto-generated method stub
		if(root==null)
			root=new Node(value);
		else if(value<root.value)
			root.left=add(root.left, value);
		else if(value>root.value)
			root.right=add(root.right,value);
		else
			throw new RuleViolationException();
		return root;
	}


	

	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
		
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		System.out.println(root.value);
		preOrder(root.left);
		
		preOrder(root.right);
		
	}
	
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node root) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		
		postOrder(root.left);
		
		postOrder(root.right);
		System.out.println(root.value);
		
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}




	

	

}
