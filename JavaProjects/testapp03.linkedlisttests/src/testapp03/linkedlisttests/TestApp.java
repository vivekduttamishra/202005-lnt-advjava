package testapp03.linkedlisttests;

import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//LinkedList<int> numbers=new LinkedList<>(); //can't create gneeric of primitive types  
		LinkedList<Integer> numbers=new LinkedList<>();//Java 6+ <> automatically detects the type from variable on the right.
		System.out.println(numbers);

		//Test the linkedlist Add
		testAdd(numbers);
		
		testDelete(numbers);
		
		testGet(numbers);
		
		testSet(numbers);
		testGetWithInvalidIndex(numbers);
	}
	
	private static void testGetWithInvalidIndex(IndexedList<Integer> numbers) {
		// TODO Auto-generated method stub
		System.out.println("numbers.get(100) is "+numbers.get(100));
	}

	private static void testGet(IndexedList<Integer> numbers) {
		// TODO Auto-generated method stub
		int [] positions= {6, 4, 9, 0};
		for(int position : positions) {
			int value=numbers.get(position);
			System.out.print("numbers.get("+position+") is "+numbers.get(position));
			if(value==position)
				System.out.println("\tpassed");
			else
				System.out.println("\tfailed");
		}
	}

	private static void testDelete(LinkedList<Integer> numbers) {
		// TODO Auto-generated method stub
		int [] positions= {8, 6,  2 , 0};
		for(int position : positions) {
			System.out.println("trying to delete at position "+position);
			numbers.remove(position);
		}
		
		System.out.println(numbers);
	}

	private static void testSet(IndexedList<Integer> numbers) {
		// TODO Auto-generated method stub
		int [] positions= {6, 4, 9, 0};
		for(int position : positions) {
			System.out.println("setting numbers.set("+position+","+position*10+") ... ");
			numbers.set(position, position*10);
		}
		System.out.println(numbers);
	}

	

	private static void testAdd(IndexedList<Integer> numbers) {
		
		for(int i=0;i<10;i++) {
			numbers.add(i); 
		}
		System.out.println("numbers.size()="+numbers.size());
		System.out.println(numbers);		
	}

}
