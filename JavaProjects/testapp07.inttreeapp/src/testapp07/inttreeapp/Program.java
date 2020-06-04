package testapp07.inttreeapp;

import in.conceptarchitect.collections.IntTree;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IntTree tree=new IntTree();
		
		tree.add(20);
		tree.add(30);
		
		//tree.add(tree.root,40);
		
		
		System.out.println("tree created with size "+tree.size());
		
	}

}
