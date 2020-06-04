package testapp07.inttreeapp;

import in.conceptarchitect.collections.IntTree;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		IntTree tree=new IntTree();
		
		tree.addMany(15, 10, 25, 20, 5, 12,30);
		
		
		//if I want to print the list inorder
		System.out.println("inroder list");
		tree.inOrder(v->System.out.print(v+"\t"));
		
		
		//we can print a list using method reference
		System.out.println("\npreorder");
		tree.preOrder(System.out::print);
		
		
		//static method reference
		System.out.println("\npostorder");
		tree.postOrder(Program::printTab);
		
	}
	
	
	static <E >void printTab(E value){
		System.out.print(value+"\t");
	}

}
