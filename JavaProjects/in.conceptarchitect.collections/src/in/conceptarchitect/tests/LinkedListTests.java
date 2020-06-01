package in.conceptarchitect.tests;

//import all static methods from Assert class
//this way all static method of the calss can be invoked without using Class reference
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.collections.LinkedList;

public class LinkedListTests {

	@Test
	public void new_listIsEmpty() {
		LinkedList<Integer> list=new LinkedList<>();
		assertEquals(0, list.size());
	}

	@Test
	public void toString_returnsListWithEmptyParenthesis() {
		LinkedList<Integer> list=new LinkedList<Integer>();
		
		assertEquals("LinkedList()", list.toString());
	}
	
	@Ignore
	@Test
	public void add_canAddToAnEmptyList() {
		fail("not yet implemented");
	}
	
	@Ignore 
	@Test
	public void add_addingToANonEmptyListAddsItemAtTheEnd() {
		
	}
	
	@Ignore 
	@Test
	public void add_addedItemsAreShownInToString() {
		
	}
	
	@Ignore 
	@Test
	public void get_0GetsTheFirstItem() {
		
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
