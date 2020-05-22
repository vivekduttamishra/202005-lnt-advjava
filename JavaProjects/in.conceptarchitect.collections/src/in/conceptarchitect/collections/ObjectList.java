package in.conceptarchitect.collections;


public class ObjectList {
	
	class Node {	
		Object value;
		Node next;
		Node previous;
	}


	Node first;
	int count;
	Node last; //always remember the last position.
	
	//add a new value at the end of the list
	public void add(Object value) {
		
		
		Node newNode=new Node();
		newNode.value=value;
		newNode.next= null; //remember this will be the last node.
		newNode.previous=last; //current last node is my previous
		
		count++;

		//scenario#1 ---> List is empty. we are adding the first node
		if(first==null) 
			first=newNode; //this node is the first node
		else
			last.next=newNode; //next to current last will be newNode
		
		last=newNode; //new node is the last Node
			
		
	}
	
	public void insert(int pos, Object value) {
		
		Node n=locate(pos);
		
		if(n==null)
			return ; //there is no node. can't insert
		
		Node newNode=new Node();
		newNode.value=value;
		newNode.next= n; //remeber we are inserting before n
		newNode.previous=n.previous; //what ever comes before n
		
		if (n==first) //inserting before first
			first=newNode;
		else
			n.previous.next=newNode;
		
		n.previous=newNode;
		count++;
	}
	
	
	private Node locate(int pos) {
		int i=0;
		Node n=first;
		while(i<pos && n!=null)
		{
			i++;
			n=n.next;
		}
		return n;
	}
	
	public Object get(int pos) {
		Node n = locate(pos);
		if(n==null)
			return null;
		else
			return n.value;
	}

	
	
	public void set(int pos, Object value) {
		Node n = locate(pos);
		if(n!=null)
			n.value=value;
	}
	
	public void remove(int pos) {
		
		if(pos<0)
			return ; //nothing to remove
		
		if(first==null) //list is empty
			return ; //nothing to remove
		
		
		Node n=locate(pos);
		
		if(n==null)
			return ; //we moved past the last one. Nothing to remove
		
		//delete the 'nth' node
		
		if(n.previous==null)   //deleting first node
			first=n.next;
		else
			n.previous.next=n.next; //if not the first node
		
		if(n.next!=null) // last node			
			n.next.previous=n.previous; //not the last node
		//else
			//do nothing	
		
		
	}
	
	public int size() {
		return count;
	}
		
}
