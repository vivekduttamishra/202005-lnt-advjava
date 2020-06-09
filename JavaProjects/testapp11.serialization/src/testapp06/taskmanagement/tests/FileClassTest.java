package testapp06.taskmanagement.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class FileClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void checkCurrentDirector() {
		
		File file=new File("src/mydata.txt"); //current directory
		File file2= new File("/Users/vivek/works/corporate/202005-lnt-advjava/JavaProjects/testapp11.serialization/src/mydata.txt");
		
		
		//assertTrue(file.isDirectory());
		
		System.out.println(file.getAbsolutePath());
		
		assertEquals(file2.getAbsolutePath(), file.getAbsolutePath());
		
	}

}
