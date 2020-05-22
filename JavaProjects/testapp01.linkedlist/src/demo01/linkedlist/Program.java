package demo01.linkedlist;

import in.conceptarchitect.collections.IntList;
import in.conceptarchitect.collections.StringList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Linked List Tests
		
		IntList list=new IntList();
		
		//listBasicTest(list);
		
		//listPerformanceTest(list,100000);
		
		testStringList();
		
		
		
	}
	
	static void testStringList() {
		StringList list=new StringList();
		list.add("india");
		list.add("france");
		list.add("japan");
		
		for(int i=0;i<list.size();i++) {
			var str=list.get(i);
			System.out.println(str);
			list.set(i, str.toUpperCase());
		}
		
		for(int i=0;i<list.size();i++)
			System.out.println(list.get(i));
		
		
		
	}

	private static void listPerformanceTest(IntList list, int items) {
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

	private static void listBasicTest(IntList list) {
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

	private static void showList(IntList list) {
		for(int i=0;i<list.size();i++)
			System.out.print(list.get(i)+"\t");
		
		System.out.println();
	}

}
