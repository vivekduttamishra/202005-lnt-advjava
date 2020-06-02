package testapp02.listtests;

import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;
import in.conceptarchitect.collections.ObjectList;
import in.conceptarchitect.collections.StringList;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IndexedList<String> values= LinkedList.create("India","USA","France","Japan");
		
		
		
		//testStringList();
		
		//Using ObjectList to Strings
		//testObjectList();
		
		IndexedList<String> names=new LinkedList<String>();
		names.add("India");
		names.add("USA");
		//names.add(21); //PROBLEM SOLVED #2: Invalid Data is rejected
		names.add("France"); //I can add these values
		
		
		for(int i=0;i<names.size(); i++) {
			//System.out.println(names.get(i).toUpperCase()); //returned value is Object not String
			
			//Problem#1 Solved --> No Typecasting need
			String str=  names.get(i).toUpperCase();  
			
			//PROBLEM#3 SOVLED No Typecasting no question of error Misplaced Error Reporting
			
			System.out.println(str);
		}
		
		
		//If we don't specify the generic type
		//It is assumed to be an Object
		//But it is not a recommended practice
		//It was don't for backward compatiblity 
		
		IndexedList numbers=new LinkedList();
		numbers.add(20);
		numbers.add(30);
		numbers.add(15);
		
		for(int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i));
			
			
		}
		
		//If you really need Object based LinkedList be specific
		
		//right side specifiecation can be skipped and 
		
		
		//java assumes Left side type on the right side (Java 6)
		IndexedList<Object> objects=new LinkedList<>();
		
		objects.add(10);
		objects.add("hello");
		for(int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i));
			
		}
		
		
	}

	private static void testObjectList() {
		ObjectList names=new ObjectList();
		names.add("India");
		names.add("USA");
		names.add(21); //PROBLEM #2: This is a list of Object, so any object can enter it.
		names.add("France"); //I can add these values
		
		
		for(int i=0;i<names.size(); i++) {
			//System.out.println(names.get(i).toUpperCase()); //returned value is Object not String
			
			//Problem#1 --> Manual type casting
			var str= (String) names.get(i);  //PROBLEM#3 Misplaced Error Reporting
			
			System.out.println(str.toUpperCase());
		}
		
		
		
		ObjectList numbers=new ObjectList();
		numbers.add(20);
		numbers.add(30);
		numbers.add(15);
		
		for(int i=0;i<numbers.size();i++) {
			System.out.println(numbers.get(i));
			
			
		}
	}

	private static void testStringList() {
		StringList list=new StringList();
		list.add("India");
		list.add("USA");
		list.add("France"); //I can add these values
		
		for(int i=0;i<list.size(); i++)
			System.out.println(list.get(i).toUpperCase());  //List returns String and I can perform String operations
	}

}
