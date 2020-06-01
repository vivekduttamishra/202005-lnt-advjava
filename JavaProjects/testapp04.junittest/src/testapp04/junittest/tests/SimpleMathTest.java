package testapp04.junittest.tests;

import org.junit.Test;

import junit.framework.AssertionFailedError;
import testapp04.junittest.program.SimpleMath;

public class SimpleMathTest {
	
	@Test
	public void test1() {
		int x=50, y=10;
		int result= SimpleMath.plus(x, y);
		System.out.println("SimpleMath.plus("+x+","+y+") is "+result);
		if(result!=x+y)
			throw new RuntimeException("Plus Operation Failed");
	}
	
	@Test
	public void test2() {
		int x=50, y=10;
		int result= SimpleMath.minus(x, y);
		System.out.println("SimpleMath.minus("+x+","+y+") is "+result);
		if(result!=x-y)
			throw new RuntimeException("Minus Operation Failed");
	}
	
	@Test
	public void test3() {
		int x=50, y=10;
		int actual= SimpleMath.multiply(x, y);
		System.out.println("SimpleMath.multiply("+x+","+y+") is "+actual);
		
		
		
		isEqual(x*y, actual);
	}

	private void isEqual(int expected, int actual) throws AssertionFailedError {
		if(actual!=expected)
			throw new AssertionFailedError("Failed -- Expected "+expected+" actual "+actual);
	}
	
	@Test
	public void test4() {
		int x=50, y=10;
		int result= SimpleMath.divide(x, y);
		System.out.println("SimpleMath.plus("+x+","+y+") is "+result);
		
		isEqual(x/y, result);
	}

}
