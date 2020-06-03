package testapp05.genericcontrainttests.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.DynamicArray;
import in.conceptarchitect.collections.LinkedList;

import static in.conceptarchitect.collections.CollectionHelper.*;
import testapp05.genericcontrainttests.business.Horse;
import testapp05.genericcontrainttests.business.Tiger;

public class CollectionHelperTests {

	Tiger tiger1, tiger2, tiger3;
	LinkedList<Tiger> tigers;
	
	Horse horse1,horse2, horse3;
	DynamicArray<Horse> horses= new DynamicArray<Horse>(3);
	
	@Before
	public void setUp() throws Exception {
		tiger1=new Tiger("Sher Khan",12,9);
		tiger2=new Tiger("Mr Tiger",8,10);
		tiger3=new Tiger("Moti",5,8);
	
		tigers=new LinkedList<Tiger>();
		tigers.add(tiger1);
		tigers.add(tiger2);
		tigers.add(tiger3);
		
		
		horse1=new Horse("Chetak",12,30);
		horse2=new Horse("Badal",8,40);
		horse3=new Horse("Hero",10,50);
	
		horses.add(horse1);
		horses.add(horse2);
		horses.add(horse3);
		
	}

	@Test
	public void idIsHashCode() {
		
		int id= id(tiger1);
		assertEquals(tiger1.hashCode(), id);
		
	     
	     id=id(horse1);
	     assertEquals(horse1.hashCode(), id);
	}
	
	@Test
	public void indexOfReturns0BasedIndexForItemsFound() {
		
		LinkedList<?> objects=tigers;
		
		int pos=indexOf(tigers, tiger2);
		
		assertEquals(1, pos);
				
	}
	
	@Test
	public void indexOfReturnsMinusOneForNotFoundItem() {
		int pos= indexOf(tigers,new Tiger("Don",11,9));
		
		assertEquals(-1, pos);
		
	}
	

}
