package in.conceptarchitect.unitest;

import static org.junit.Assert.*;


public class Asserts {

	public static <E> void assertSubType(Object obj, Class<E> cls) {
		if(!cls.isInstance(obj)) {
			throw new AssertionError(obj.getClass().getName()+" not an intance of "+cls.getName());
		}
	}
	
	public static void assertIntEquals(Object expected, Object actual) {
		assertEquals((int)expected, (int)actual);
	}
	
}
