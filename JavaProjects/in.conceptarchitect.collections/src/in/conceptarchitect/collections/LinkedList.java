package in.conceptarchitect.collections;



//X is some unknown which will be supplied when creating a object
public class LinkedList<X> {  	
	class Node {	
		X value;
		Node next;
		Node previous;
	}
	Node first;
	int count;
	Node last; //always remember the last position.
	
	//add a new value at the end of the list
	public void add(X value) {
		
		
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
	
	public void insert(int pos, X value) {
		
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
		
		if(pos<0)
			pos=size()+pos;
		
		if(pos<0 || pos>=size())
			throw new IndexOutOfBoundsException(pos);
		
		int i=0;
		Node n=first;
		while(i<pos)
		{
			i++;
			n=n.next;
		}
		return n;
	}
	
	public X get(int pos) {
		Node n = locate(pos);
		
		
		return n.value;
	}
	
	public void set(int pos, X value) {
		Node n = locate(pos);
		
		n.value=value;
	}
	
	public X remove(int pos) {
		
		
		Node n=locate(pos);
		
		
		//delete the 'nth' node
		
		if(n.previous==null)   //deleting first node
			first=n.next;
		else
			n.previous.next=n.next; //if not the first node
		
		if(n.next!=null) // last node			
			n.next.previous=n.previous; //not the last node
		//else
			//do nothing	
		
		count--;
		return n.value;
		
		
	}
	
	public int size() {
		return count;
	}
	
	
	public  static <T> LinkedList<T> create(T...values){
		LinkedList<T> list=new LinkedList<T>();
		for(T value : values) {
			list.add(value);
		}
		
		return list;
		
	}
	
	/*
	 * Should Create a String representing all value from the list
	 * Example1: List contains "india","usa","france"
	 * 		Output:  LinkedList(\tIndia,\tusa\tfrance\t)
	 * Example2: List is empty
	 * 		Output:  LinkedList()	  
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(size()==0)
			return "LinkedList()";
		
		String str="LinkedList(\t";
		
		for(Node n=first;n!=null;n=n.next)
			str+=n.value+"\t";
		
		str+=")";
		
		return str;
	}
		
}
