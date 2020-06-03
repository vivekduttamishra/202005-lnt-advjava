package testapp05.genericcontrainttests.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.Collection;
import in.conceptarchitect.collections.DynamicArray;
import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;

import static in.conceptarchitect.collections.CollectionHelper.*;
import  static testapp05.genericcontrainttests.business.Helper.*;

import testapp05.genericcontrainttests.business.Animal;
import testapp05.genericcontrainttests.business.Horse;
import testapp05.genericcontrainttests.business.Tiger;

public class CollectionHelperTests02 {

	Tiger tiger1, tiger2, tiger3;
	LinkedList<Tiger> tigers;
	
	Horse horse1,horse2, horse3;
	DynamicArray<Horse> horses= new DynamicArray<Horse>(3);
	
	@Before
	public void setUp() throws Exception {
		tiger1=new Tiger("Sher Khan",12,9);
		tiger2=new Tiger("Mr Tiger",8,10);
		tiger3=new Tiger("Moti",10,8);
	
		tigers=IndexedList.createList(tiger1,tiger2,tiger3);
		
		
		
		
		horses.addMany(
				new Horse("Chetak",12,30),
				new Horse("Badal",8,40),
				new Horse("Hero",10,50)
		);
	
		
		
	}

	
	
	@Test
	public void indexOfReturns0BasedIndexForItemsFound() {
		
		LinkedList<?> objects=tigers;
		
		int pos=tigers.indexOf(tiger2);  //indexOf(tigers, tiger2);
		
		assertEquals(1, pos);
				
	}
	
	@Test
	public void indexOfReturnsMinusOneForNotFoundItem() {
		int pos= tigers.indexOf(new Tiger("Don",11,9));
		
		assertEquals(-1, pos);
		
	}
	
	@Test
	public void canCalculateAverageAgeOfHorses() {
		double avg= averageAge(horses);
		assertEquals(10, avg,0.1);
		
		avg=averageAge2(tigers);
		assertEquals(10, avg,0.1);
		
	}
	
	
	@Test
	public void canCopySameTypeList() {
		DynamicArray<Tiger> newTigers= new DynamicArray<Tiger>(5);
		
		//copy(tigers,newTigers);
		
		Collection.copy(tigers, newTigers);
		
		for(int i=0;i<tigers.size();i++) {
			assertEquals(tigers.get(i),newTigers.get(i));
		}
	}
	
	@Test
	public void canCopyListToSuperList() {
		DynamicArray<Animal> animals= new DynamicArray<Animal>(5);
		
		//copy2(tigers,newTigers);
		Collection.copy(tigers, animals);
		
		for(int i=0;i<tigers.size();i++) {
			assertEquals(tigers.get(i),animals.get(i));
		}
	}
	
	
	

}
