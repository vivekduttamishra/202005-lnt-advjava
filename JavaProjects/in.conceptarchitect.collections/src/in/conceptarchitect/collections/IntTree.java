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
		count++;
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
	
	public <E> E inOrder(Action<Integer,E> action) {
		if(!action.init())
			return null;
		
		inOrder(root,action);
		
		return action.result();
	}

	private <E> void inOrder(Node root, Action<Integer,E> action) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		inOrder(root.left,action);
		//System.out.println(root.value);
		action.execute(root.value);
		
		inOrder(root.right,action);
		
	}

	public <E> E preOrder(Action<Integer,E> action) {
		
		if(!action.init())
			return null;
		
		preOrder(root,action);
		
		return action.result();
	}

	private <E> void preOrder(Node root,Action<Integer,E> action) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		//System.out.println(root.value);
		action.execute(root.value);

		preOrder(root.left,action);
		
		preOrder(root.right,action);
		
	}
	
	public <E> E postOrder(Action<Integer,E> action) {
		if(!action.init())
			return null;
		postOrder(root,action);
		return action.result();
	}

	private <E> void postOrder(Node root,Action<Integer,E> action) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		
		
		postOrder(root.left,action);
		
		postOrder(root.right,action);
		//System.out.println(root.value,action);
		action.execute(root.value);
		
	}
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}




	

	

}
