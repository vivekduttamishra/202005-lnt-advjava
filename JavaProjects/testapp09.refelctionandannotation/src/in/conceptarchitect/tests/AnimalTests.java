package in.conceptarchitect.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.animalkingdom.Animal;
import in.conceptarchitect.animalkingdom.Horse;
import in.conceptarchitect.animalkingdom.Hunter;
import in.conceptarchitect.animalkingdom.Parrot;
import in.conceptarchitect.animalkingdom.Tiger;

public class AnimalTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void subClassReferenceInvokesSuperClassMethod() {
		Animal a=new Tiger();
		String result=a.reproduce();
		
		assertTrue(result.contains("Mammal"));
	}
	
	@Test
	public void weCanExplicitlyTypecastObjectToAnotherType() {
		
		Tiger tiger=new Tiger();
		Hunter hunter=(Hunter) tiger;
		
		assertEquals(tiger,hunter);
		
	}
	
	@Test
	public void weCanInvokeSpeicalMethodAfterExplicitlyTypecastObjectToAnotherType() {
		
		Tiger tiger=new Tiger();
		Animal animal=tiger;
		Hunter hunter=(Hunter) animal;
		
		String result=hunter.hunt();
		
		assertEquals(tiger.hunt(),result);
	}
	
	


	@Test(expected = ClassCastException.class)
	public void invalidForcedCastingThrowsException() {
	
	
	Animal animal=new Horse();
	Hunter hunter=(Hunter) animal;
	
	
	}

	
	@Test
	public void safeCastingCanBeDoneByPrecheckingInstanceOf() {
		
		Tiger tiger=new Tiger();
		Horse horse=new Horse();
		
		Hunter hunter1=null;
		Hunter hunter2=null;
		
		if(tiger instanceof Hunter)
			hunter1=(Hunter) tiger;
		if(horse instanceof Hunter)
			hunter2=(Hunter) horse;
		
		//BAD TEST: two tests merged here!!!
		assertEquals(tiger,hunter1);
		assertNull(hunter2);
		
		
		
	}
	
	
	@Test 
	public void parrotIsDomestic() {
		assertTrue(new Parrot().isDomestic());
	}
	
	@Test 
	public void tigerIsNotDomestic() {
		assertFalse(new Tiger().isDomestic());
	}
	
	
	@Test
	public void abstractMethodCallMayActualUseSubClassMethods() {
		
		Tiger tiger =new Tiger();
		Animal animal =tiger;
		
		//animal.hunt(); //animal can't hunt
		
		//but to eat, tiger must hunt
		String eatResult= animal.eat(); //internally call tiger.hunt()
		
		
		String huntResult= tiger.hunt();
		
		assertTrue(eatResult.endsWith(huntResult));
	}
	
	
}
