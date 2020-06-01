package testapp04.junittest.tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class HelloTest {

	@Test  //—> This annotation marks this function as a test function
	public void test() {
		System.out.println("This is test 1");
	}
	
	@Test  
	public void somethingElse() {
		System.out.println("This is to test somethingElse");
	}
	
	@Test  
	public void iAmNotATest() {
		System.out.println("I Am Not A Test");
	}
	
	public void iAmTheLastTest() {
		System.out.println("I Am the Last Test");
	}
	

}
