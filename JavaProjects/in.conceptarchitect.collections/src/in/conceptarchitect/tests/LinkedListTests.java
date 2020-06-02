package in.conceptarchitect.tests;

//import all static methods from Assert class
//this way all static method of the calss can be invoked without using Class reference
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.collections.LinkedList;

public class LinkedListTests {
	
	//Arrange
	LinkedList<Integer> list;	
	int initSize;
	
	@Before
	public void arrange() {
		System.out.println("arrange is called");
		list=new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
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
	
	//@Ignore
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
	
	//@Ignore 
	@Test
	public void add_addingToANonEmptyListAddsItemAtTheEnd() {
	
		
		
		//ACT
		list.add(11); //this is the action we need
		
		//ASSERT
		assertEquals(11, (int) list.get(initSize));
		

	
	}
	
	//@Ignore 
	@Test
	public void add_addedItemsAreShownInToString() {
		//ARRANGE
		
		//ACT
		
		
		//ASSERT
		assertEquals("LinkedList(\t1\t2\t3\t)", list.toString());
	}
	
	@Ignore 
	@Test
	public void get_0GetsTheFirstItem() {
				
		//ACT
		
		//ASSERT
	}
	
	
	@Ignore 
	@Test
	public void get_PosReturnsItemsFromZeroBasedIndex() {
		
	}
	
	@Ignore 
	@Test
	public void get_throwsIndexExceptionForInvalidIndex() {
		
	}
	
	@Ignore 
	@Test
	public void get_NegativeIndexIsACirclularIndex() {
		//-1 is last item
		//-2 is second last item
		//-3 is third last item
		//size() is first item
		
		//you will have to modify LinkedList to implement this feature
	}
	
	@Ignore 
	@Test
	public void set_setDoesntAddNewItem() {
		
	}
	
	@Ignore 
	@Test
	public void set_replacesCurrentItem() {
		
	}
	
	@Ignore 
	@Test
	public void set_failsForInvalidIndex() {
		
	}
	
	@Ignore 
	@Test
	public void remove_removesTheItemFromValidIndex() {
		
	}
	
	@Ignore 
	@Test
	public void remove_usesCircularIndex() {
		
	}
	
	@Ignore 
	@Test
	public void get_removeReturnsTheRemovedItem() {
		
	}
	
	
	
	
}
