package in.conceptarchitect.collections;

public class LinkedList {

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
		
	}
	
	public int get(int pos) {
		return 0;
	}
	
	public void set(int pos, int value) {
		
	}
	
	public void remove(int pos) {
		
	}
	
	public int size() {
		return 0;
	}
	
}
