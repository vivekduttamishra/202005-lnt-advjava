package demo01.linkedlist;

import in.conceptarchitect.collections.LinkedList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Linked List Tests
		
		LinkedList list=new LinkedList();
		
		//listBasicTest(list);
		
		listPerformanceTest(list,100000);
		
		
		
	}

	private static void listPerformanceTest(LinkedList list, int items) {
		// TODO Auto-generated method stub
		System.out.println("Inserting "+items+" items");
		long start=System.currentTimeMillis();
		for(int i=0;i<items;i++)
			list.add(items);
		long end=System.currentTimeMillis();
		
		System.out.println("Total time taken to add "+items+" item is "+(end-start)+" ms");
		
		System.out.println("Now trying to access all items of the list...");
		start=System.currentTimeMillis();
		long sum=0;
		for(int i=0;i<list.size();i++)
			sum+=list.get(i);
		
		end=System.currentTimeMillis();
		
		System.out.println("Total time taken to process "+items+" item is "+(end-start)+" ms");
		
		
	}

	private static void listBasicTest(LinkedList list) {
		for(int i=0;i<10;i++)		
			list.add(i);
		System.out.println("size of list after add is "+list.size());
	
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			list.set(i, i*10);
		}
		
		showList(list);
		
		System.out.println();
		
		list.remove(8); //--->80
		list.remove(3); //--->30
		list.remove(0); //--->0
		
		showList(list);
		
		
		//10 20 40 50 60 70 90
		
		//insert 0 30 and 90
		
		list.insert(6, 80);
		list.insert(0, 0);
		list.insert(3, 30);
		
		showList(list);
	}

	private static void showList(LinkedList list) {
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+"\t");
		
		System.out.println();
	}

}
