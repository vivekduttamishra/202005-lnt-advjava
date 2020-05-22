package backup;


public class LinkedListV2 {
	
	class Node {	
		int value;
		Node next;
		Node previous;
	}


	Node first;
	
	//add a new value at the end of the list
	public void add(int value) {
		Node newNode=new Node();
		newNode.value=value;
		newNode.next= null; //remember this will be the last node.
		//node.previous=??? //--> we must do it at some point
		
		//Now I need to add this node after the last node in the list
		
		//scenario#1 ---> List is empty. we are adding the first node
		if(first==null) {
			first=newNode; //this node is the first node
			newNode.previous=null; //this is the first node
			
			return ; //work done!
		}
		
		//secnerio #2 ---> List is not empty. We must find the last Node
		Node node=first; //let us begin from the begin
		while(node.next!=null)  //loop till there is no next available
			node=node.next ; //keep moving next item
		
		//now node means last node
		Node last=node;
		last.next=newNode; //next to the last will be newNode
		newNode.previous=last; //previous to new node will be current lastNode
		
		
	}
	
	public void insert(int pos, int value) {
		
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
	
	public int get(int pos) {
		Node n = locate(pos);
		if(n==null)
			return 0;
		else
			return n.value;
	}

	
	
	public void set(int pos, int value) {
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
		int c=0;
		Node n=first;
		while(n!=null){
			n=n.next;
			c++;
		}
		
		return c;
	}
		
}
