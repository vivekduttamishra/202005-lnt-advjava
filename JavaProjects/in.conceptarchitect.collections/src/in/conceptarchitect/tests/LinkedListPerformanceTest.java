package in.conceptarchitect.tests;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.LinkedList;

public class LinkedListPerformanceTest {

	LinkedList<Integer> list=new LinkedList<>();
	long startTime,endTime;
	int max=100000;
	
	@Before
	public void setUp() throws Exception {
		startTime=System.currentTimeMillis();
		for(int i=1;i<=max;i++)
			list.add(i);
	}
	
	@After
	public void after() {
		endTime=System.currentTimeMillis();
		System.out.println("Total Time Taken:"+(endTime-startTime)+" ms");
	}

	@Test
	public void timeTakenToAddMaxItems() {
		System.out.println("time taken to add "+max+" items");
		
	}
	
	
	@Test(timeout = 15)
	public void timeTakenToAccessMaxItems() {
		System.out.println("time taken to access "+max+" items");
		long sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i); //it is important we access the item
		}
		endTime=System.currentTimeMillis();
		System.out.println("Actual Total Time Taken:"+(endTime-startTime)+" ms");
		System.out.println("Sum of all values is "+sum);
		
	}
	
	
	@Test(timeout = 15)
	public void timeTakenToAccessMaxItemsUsingIterator() {
		System.out.println("time taken to access "+max+" items using iterator");
		long sum=0;
		
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()) {
			sum+=it.next();
		}
		
		
		endTime=System.currentTimeMillis();
		System.out.println("Actual Total Time Taken:"+(endTime-startTime)+" ms");
		System.out.println("Sum of all values is "+sum);
		
	}
	
	

}
