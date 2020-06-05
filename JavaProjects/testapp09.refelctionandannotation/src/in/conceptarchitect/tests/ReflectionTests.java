package in.conceptarchitect.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import in.conceptarchitect.animalkingdom.Horse;
import in.conceptarchitect.animalkingdom.Hunter;
import in.conceptarchitect.animalkingdom.Mammal;
import in.conceptarchitect.animalkingdom.Tiger;

public class ReflectionTests {

	
	@Test
	public void thereIsASingleClassObjectPerType() throws ClassNotFoundException {
		Tiger tiger1=new Tiger();
		Tiger tiger2=new Tiger();
		
		Class<?> c1= tiger1.getClass();
		Class<?> c2= tiger2.getClass();
		Class<?> c3= Tiger.class;
		Class<?> c4= Class.forName("in.conceptarchitect.animalkingdom.Tiger");
		
		assertSame(c1, c2);
		assertSame(c1, c3);
		assertSame(c1, c4);
		
	}
	
	@Test(expected=ClassNotFoundException.class)
	public void classForNameFailsIfNameIsNotFound() throws ClassNotFoundException {
		Class.forName("Foo");
	}
	
	@Test(expected=ClassNotFoundException.class)
	public void classWithoutPackageQualificationIsNotFound() throws ClassNotFoundException {
		Class.forName("Tiger");
	}
	
	@Test
	public void objectsOfClassIsDifferentForDifferentTypes() throws ClassNotFoundException {
		
		
		Class<?> c1= Tiger.class;
		Class<?> c2= Horse.class;
		
		assertNotEquals(c1, c2);
	}
	
	
	@Test
	public void interfacesAlsoHaveClassObjectForThem() throws ClassNotFoundException {
		
		
		Class<?> c1= Hunter.class;
		assertNotNull(c1);
	}
	
	
	@Test
	public void getName_givesPackageQualifiedName() throws ClassNotFoundException {
		
		Class<?> cls=Tiger.class;
		
		assertEquals("in.conceptarchitect.animalkingdom.Tiger", cls.getName());
	}
	
	
	@Test
	public void getSimpleName_returnsNameWithoutPackage() throws ClassNotFoundException {
		
		Class<?> cls=Tiger.class;
		
		assertEquals("Tiger", cls.getSimpleName());
	}
	
	@Test
	public void weCanIdentifyIfAClassIsInterface() {
		Class<?> cls=Hunter.class;
		
		assertTrue(cls.isInterface());
		
	
		
		
	}
	
	@Test
	public void getModifieer_CanIdentifyIfAClassIsAbstract() {
		Class<?> cls=Mammal.class;
		
		int m=cls.getModifiers();
		
		assertTrue(Modifier.isAbstract(m));
		
		Class<?> tiger=Tiger.class;
		
		int m2= tiger.getModifiers();
		
		assertFalse(Modifier.isAbstract(m2));
		
		
	}

	@Test
	public void canCreateAnObjectFromClassObject() throws InstantiationException, IllegalAccessException {
		
		Class<?> tigerClass=Tiger.class;
		Object tigerObject= tigerClass.newInstance();
		
		assertTrue(tigerObject instanceof Tiger);
	}
	
	
	@Test(expected = InstantiationException.class)
	public void cantCreateObjectOfInterface() throws InstantiationException, IllegalAccessException {
		Class<?> hunterClass=Hunter.class;
		Object hunterObject= hunterClass.newInstance();
		
	}
	
	
	@Test
	public void canGetAListOfMethodFromClass() throws InstantiationException, IllegalAccessException {
		
		Tiger tiger=new Tiger();
		
		Class<?> tigerClass= tiger.getClass();
		
		Method [] methods=tigerClass.getMethods();
		
		boolean found=false;
		for(Method method: methods) {
			
			System.out.println(method.getName());
			
			if(method.getName().equals("hunt"))
				found=true;
		}
		
		
		assertTrue("hunt() not found in Tiger", found);
		
		
		
	}
	
	@Test
	public void weCanIvokeAnyPresentMethodOfTheClass() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Tiger tiger=new Tiger();
		
		Class<?> tigerClass=tiger.getClass();
		
		Method huntMethod= tigerClass.getMethod("hunt");
		
		Object methodOutput= huntMethod.invoke(tiger);
		
		assertEquals(tiger.hunt(), methodOutput);
		
	}
	
	
	
	
	
}

