package testapp04.junittest.tests;


import org.junit.Assert;
import org.junit.Test;

import junit.framework.AssertionFailedError;
import testapp04.junittest.program.SimpleMath;

public class SimpleMathTest2 {
	
	@Test
	public void testPlus() {
		int x=50, y=10;
		int result= SimpleMath.plus(x, y);
		System.out.println("SimpleMath.plus("+x+","+y+") is "+result);
		
		Assert.assertEquals(x+y, result);
		
	}
	
	@Test
	public void testMinus() {
		int x=50, y=10;
		int result= SimpleMath.minus(x, y);
		System.out.println("SimpleMath.minus("+x+","+y+") is "+result);
		Assert.assertEquals(x-y, result);
	}
	
	@Test
	public void testMultiply() {
		int x=50, y=10;
		int actual= SimpleMath.multiply(x, y);
		System.out.println("SimpleMath.multiply("+x+","+y+") is "+actual);
		
		
		
		Assert.assertEquals(x*y, actual);  //isEqual(x*y, actual);
	}

	private void isEqual(int expected, int actual) throws AssertionFailedError {
		if(actual!=expected)
			throw new AssertionFailedError("Failed -- Expected "+expected+" actual "+actual);
	}
	
	@Test
	public void divideWorksCorrectlyForNonZeroDenominator() {
		int x=50, y=10;
		int result= SimpleMath.divide(x, y);
		System.out.println("SimpleMath.plus("+x+","+y+") is "+result);
		
		isEqual(x/y, result);
	}
	
	@Test
	public void divideByZeroUnhandledCausesErrorWhenItShoudlActuallyPass() {
		int x=50, y=0;
		int result= SimpleMath.divide(x, y); //ideally this code will fail here!
		
		//so we can't write any assertion. Right?	
		
	}
	
	@Test
	public  void divideByZeroShouldThrowArithmeticException(){

		try{
			SimpleMath.divide(7,0); //should throw ArithemeticException
		
			//If I reach here. It means exception is not throw  and
			//the test has failed
			Assert.fail("excpected exception ArithmeticException wasn't thrown");
		}catch(ArithmeticException ex){
			//test passed as the exception was expected
			//do nothing and test will pass.
		}

	}
	
	
	@Test(expected = ArithmeticException.class)  //indicate which exception you exception	
	public void divideThrowsArithmeticExceptionIfDenominatorIsZero() {
		SimpleMath.divide(7, 0);
	}


}
