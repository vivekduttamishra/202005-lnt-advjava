package in.conceptarchitect.specs;

import static in.conceptarchitect.unitest.Asserts.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.collections.DynamicArray;
import in.conceptarchitect.collections.IndexedList;


public class DynamicArraySpecs {
	
	DynamicArray<Integer> array;
	int growSize=3;
	static int tests=0;
	int [] testData= {100,200,300};
	
	@Before
	public void arrange() {
		array=new DynamicArray<Integer>(growSize);
		tests++;
	}
	@AfterClass
	public static void report() {
		System.out.println("Total tests executed :"+tests);
	}
	
	@Test 
	public void new_dynamicArrayShouldImplementIndexedList() {
		assertSubType(array, IndexedList.class);
	}
	
	
	@Test 
	public void new_dynamicArrayShouldTakeGrowSize() {
	}

	
	
	@Test 
	public void new_dynamicArrayShouldHaveZeroSize() {
		assertEquals(0, array.size());
	}
	
	@Test 
	public void new_dynamicArrayShouldTakeGrowSizeCapacity() {
		assertEquals(growSize, array.capacity());
	}
	
	
	@Test 
	public void add_addsItemToDynamicArray() {
		array.add(1);
		
	}
	
	
	@Test 
	public void add_increasesArraySize() {
		array.add(1);
		assertEquals(1, array.size());
	}
	
	
	
	@Test 
	public void add_lessThanCapacityDoesntChangeCapacity() {
		
		addItems(growSize);
		
		assertEquals(growSize, array.capacity());
	}
	
	
	@Test 
	public void add_addBeyondCapacityIncreasesListCapacityByGrowSize() {
		//Arrange �> add value till the capacity
		addItems(growSize);
		
		//Act --> Add another value to push it beyond capacity
		array.add(100);
		assertEquals(2*growSize, array.capacity());
		
		
		//Try second level
		addItems(growSize);
		
		assertEquals(3*growSize, array.capacity());
		
		
	}
	private void addItems(int count) {
		for(int i=0;i<count;i++)
			array.add(i);
	}
	
	
	@Test 
	public void get_0ReturnsFirstItem() {
		array.add(100);
		
		assertEquals(100, (int) array.get(0));

	}
	
	
	@Test 
	public void get_minusOneReturnsLastItem() {
		array.add(100);
		array.add(200);
		
		assertEquals(200,(int) array.get(-1));
		
	}
	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void get_beyondSizeThrowsIndexOutOfBoundsException() {
		array.add(100);
		array.add(200);
		
		array.get(2);
	}
	
	@Test
	public void get_canAccessAllItemsOnZeroBasedIndex() {
		addItems(5);
		
		for(int i=0;i<array.size();i++)
			assertEquals(i,(int)array.get(i));
		
	}
	
	//@Ignore
	@Test 
	public void set_0SetsFirstItem() {
		array.add(100);
		array.add(200);
		array.set(0, 1000);
		
		assertEquals(2, array.size());
		assertIntEquals(1000, array.get(0));
	}
	
	//@Ignore
	@Test 
	public void set_minusOneSetsLastItem() {
		addValues();
		
		//Act
		array.set(-1, 1000);
		
		//Assert
		assertIntEquals(1000,array.get(2));
	}
	
	//@Ignore
	@Test(expected=IndexOutOfBoundsException.class)
	public void set_beyondSizeThrowsIndexOutOfBoundsException() {
		addValues();
		array.set(3, 1000);
	}
	private void addValues() {
		for(int value : testData)
			array.add(value);
	}
	
	
	//@Ignore
	@Test
	public void foreach_CanAccessListUsingForEach() {
		addValues();
		int p=0;
		for(int value : array) {
			assertEquals(testData[p],value);
			p++;
		}
	}
	
	
	
}
;
