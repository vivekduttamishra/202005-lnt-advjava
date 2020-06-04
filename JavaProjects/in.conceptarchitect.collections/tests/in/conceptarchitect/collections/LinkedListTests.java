package in.conceptarchitect.collections;

//import all static methods from Assert class
//this way all static method of the calss can be invoked without using Class reference
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.collections.LinkedList;

public class LinkedListTests {
	
	static int testCount;
	//Arrange
	LinkedList<Integer> list;	
	int initSize;
	int testData[]= {1,2,3};
	
	@BeforeClass //--> executes only once before all tests. 
	public static void beforeFirstTest() {
		testCount=0;
	}
	
	@AfterClass
	public static void afterLastTest() {
		System.out.println("Total Tests executed :"+testCount);
	}
	
	@After
	public void afterEachTest() {
		testCount++;
	}
	
	@Before  //--> executes before every test method
	public void arrange() {
		//System.out.println("arrange is called");
		list=new LinkedList<Integer>();
		for(int value :testData)
			list.add(value);
		initSize=list.size();
	}

	@Test
	public void new_listIsEmpty() {
		
		//Arrange (Reararnge) as original arrange is not acceptable
		list=new LinkedList<>();
		//Act
		
		//Assert
		assertEquals(0, list.size());
	}

	@Test
	public void toString_returnsListWithEmptyParenthesis() {
		//Re-Arrange
		list=new LinkedList<Integer>();
		
		//Act
		
		//Assert
		assertEquals("LinkedList()", list.toString());
	}
	
	//
	@Test
	public void add_canAddToAnEmptyList() {
		
		//Re-arrange
		list=new LinkedList<Integer>();
				
		
		//ACT
		list.add(7);
		
		//ASSERT
		assertEquals(1, list.size());
		assertEquals("LinkedList(\t7\t)",list.toString());
		
	}
	
	// 
	@Test
	public void add_addingToANonEmptyListAddsItemAtTheEnd() {
	
		
		
		//ACT
		list.add(11); //this is the action we need
		
		//ASSERT
		assertEquals(11, (int) list.get(initSize));
		

	
	}
	
	// 
	@Test
	public void add_addedItemsAreShownInToString() {
		//ARRANGE
		
		//ACT
		
		
		//ASSERT
		assertEquals("LinkedList(\t1\t2\t3\t)", list.toString());
	}
	
	// 
	@Test
	public void get_0GetsTheFirstItem() {
				
		//ACT
		
		//ASSERT
		assertEquals(1, (int) list.get(0)); 
	}
	
	
	// 
	@Test
	public void get_PosReturnsItemsFromZeroBasedIndex() {
		
		for(int i=0;i<list.size();i++)
			assertEquals(i+1, (int) list.get(i));
		
	}
	
	 
	@Test(expected = IndexOutOfBoundsException.class)
	public void get_throwsIndexExceptionForInvalidIndex() {
		list.get(100);
	}
	
	// 
	@Test
	public void get_NegativeIndexIsACirclularIndex() {
		//-1 is last item
		//-2 is second last item
		//-3 is third last item
		//size() is first item
		
		int p=0;
		for(int i=-list.size(); i<=-1; i++) {			
			assertEquals(testData[p], (int)list.get(i));
			p++;			
		}
		//you will have to modify LinkedList to implement this feature
	}
	
	// 
	@Test
	public void set_setDoesntAddNewItem() {
	
		list.set(1, 100);
		
		//there should be no change in the list size
		assertEquals(initSize, list.size());
	}
	
	// 
	@Test
	public void set_replacesCurrentItem() {
		
		//after setting index 1 to 100
		list.set(1,100);
		
		//we should get 100 back grom index 1
		assertEquals(100, (int) list.get(1));
		
	}
	
	// 
	@Test(expected = IndexOutOfBoundsException.class)
	public void set_failsForInvalidIndex() {
		list.set(100, 100);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void set_failsForNegativeIndexLessThanNegativeSize() {
		list.set(-list.size()-1, 0);
	}
	
	// 
	@Test
	public void remove_removesTheItemFromValidIndex() {
		list.remove(0);
		//after removeing 0th item, it shouldn't be present in the list any more
		assertNotEquals(testData[0], (int) list.get(0));
	}
	
	// 
	@Test
	public void remove_usesCircularIndex() {
		int p=0;
		for(int i=-list.size();i<=-1;i++) {
			assertEquals(testData[p], (int)list.remove(i));
			p++;
		}
		
		assertEquals(0, list.size()); //now list is zero sized
	}
	
	 
	@Test
	public void remove_removeReturnsTheRemovedItem() {
		
		int delItem=list.remove(1);
		
		assertEquals(testData[1], delItem);
		
	}
	@Test
	public void remove_resizesTheList() {
		//after removing an item
		list.remove(1);
		//the list size should decrease
		assertEquals(initSize-1, list.size());
		
	}
	
	
	
	
}
