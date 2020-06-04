package in.conceptarchitect.collections;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.collections.DynamicArray;
import in.conceptarchitect.collections.LinkedList;

public class DynamicArrayPerformanceTest {

	DynamicArray<Integer> list;
	long startTime,endTime;
	int max=100000;
	
	@Before
	public void setUp() throws Exception {
		startTime=System.currentTimeMillis();
		
	}

	private void addItems() {
		
		for(int i=1;i<=max;i++) 
			list.add(i);
	}
	
	private DynamicArray<Integer> create(int growFactor){
		list=new DynamicArray<Integer>(growFactor);
		addItems();
		return list;
	}
	
	@After
	public void after() {
		endTime=System.currentTimeMillis();
		System.out.println("Total Time Taken:"+(endTime-startTime)+" ms");
	}

	
	@Test
	public void timeTakeToAddMaxItemToDynamicArrayWithGrowFactor1000() {
	
		System.out.println("Adding Item to Dynamic Array with grow factor 1000");
		create(1000);
	}
	
	@Test
	public void timeTakeToAddMaxItemToDynamicArrayWithGrowFactor10() {
	
		System.out.println("Adding Item to Dynamic Array with grow factor 10");
		create(10);
	}
	
	
	
	
	  @Test
	public void timeTakenToAccessMaxItemsUsingIterator() {
		System.out.println("time taken to access "+max+" items using iterator");
		long sum=0;
		create(1000);
		startTime=System.currentTimeMillis(); //now create time is excluded
		
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()) {
			sum+=it.next();
		}
		
		
		endTime=System.currentTimeMillis();
		System.out.println("Actual Total Time Taken:"+(endTime-startTime)+" ms");
		System.out.println("Sum of all values is "+sum);
		
	}
	
	
	
	
	
	
	

}
