package in.conceptarchitect.collections;

import static org.junit.Assert.*;

import org.junit.Test;

import in.conceptarchitect.collections.Collection;
import in.conceptarchitect.collections.DynamicArray;
import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;

public class InterfaceDefaultMethodTests {
	
	@Test
	public void canAddMultipleItemsToACollectionUsingDefaultMethod() {
		
		LinkedList<String> names= new LinkedList<String>();
		
		names.addMany("india","usa","uk");
		
		assertEquals(3, names.size());
		
	}
	
	@Test
	public void newArrayIsEmpty() {
		DynamicArray<Integer> numbers= new DynamicArray<Integer>(2);
		
		assertTrue(numbers.isEmpty());
	}
	
	@Test
	public void addMakesArrayNotEmpty() {
		DynamicArray<Integer> numbers= new DynamicArray<Integer>(2);
		numbers.addMany(1,2,3);
		assertFalse(numbers.isEmpty());
	}
	
	@Test
	public void containsReturnsTrueForContainedValue() {
		
		LinkedList<String> names= new LinkedList<String>();
		
		names.addMany("india","usa","uk");
		
		assertTrue(names.contains("usa"));
		
	}
	
	@Test
	public void containsReturnsFalseForMissingValue() {
		
		LinkedList<String> names= new LinkedList<String>();
		
		names.addMany("india","usa","uk");
		
		assertFalse(names.contains("china"));
		
	}
	
	
	@Test
	public void containsAllReturnsFalseForAnyMissingValue() {
		
		LinkedList<String> names= new LinkedList<String>();
		
		names.addMany("india","usa","uk");
		
		assertFalse(names.containsAll("usa","china","uk"));
		
	}
	
	@Test
	public void containsAllReturnsTrueIfAllValuesArePresent() {
		
		LinkedList<String> names= new LinkedList<String>();
		
		names.addMany("india","usa","uk");
		
		assertTrue(names.containsAll("usa","india","uk"));
		
	}
	
	@Test
	public void indexOfReturns0BasedIndexForFoundItem() {
		
		LinkedList<String> names= new LinkedList<String>();
		
		names.addMany("india","usa","uk");
		
		assertEquals(2, names.indexOf("uk"));		
	}
	
	@Test
	public void indexOfReturnsMinus1ForMissingValue() {
		
		DynamicArray<String> names= new DynamicArray<String>(3);
		
		names.addMany("india","usa","uk");
		
		assertEquals(-1, names.indexOf("china"));		
	}
	
	
	@Test
	public void canCreateListFromItems() {
		
		LinkedList<String> names=IndexedList.createList("india","usa","uk","france");
		
		
		
		assertEquals(4, names.size());
		assertTrue(names.contains("france"));
	}
	

	@Test
	public void canCopyFromOneListToAnother() {
		
		LinkedList<String> names=IndexedList.createList("india","usa","uk","france");
		
		DynamicArray<String> names2=IndexedList.createArray("japan", "norway");
		
		//IndexedList.copy
		
		Collection.copy(names, names2);
		
		assertEquals(6, names2.size());
		assertTrue( names2.containsAll("france","japan"));
	}
	

}
