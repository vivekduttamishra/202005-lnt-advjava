package test.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BasicIOTest {

	String testFilePath="src/test/io/numbers.txt";
	String targetFilePath="src/test/io/numbers-output.txt";
	File testFile;
	File targetFile;
	long size;
	
	@Before
	public void setUp() throws Exception {
		
		testFile=new File(testFilePath);
		size=testFile.length();
		targetFile=new File(targetFilePath);
		
		
		//make sure you remove the target file each time to make test isolated
		if(targetFile.exists())
			targetFile.delete(); //preparing the test properly
		
		assumeTrue(testFile.exists()); //ignore the test if test file doesn't exit
		 
		assumeTrue(testFile.canRead()); //or cant be read
		
		
	}
	
	@Test
	public void targetFileObjectMustNotExist() {
		assertFalse(targetFile.exists());
	}
	
	
	@Test
	public void canCopyAFileUsingFileObject() throws IOException{
		FileInputStream in=null;
		FileOutputStream out=null;
		
		
		in=new FileInputStream(testFile);
		out=new FileOutputStream(targetFile);
			
		while(in.available()>0) {
			int value=in.read();
			out.write(value);
		}
		
		in.close();
		out.close();
		
		assertTrue(targetFile.exists());
		
		assertEquals(testFile.length(), targetFile.length());
		
		
		
	}
	
	@Test
	public void fileObjectCanReadTheTestFile() {
		
		assumeTrue(testFile.exists());   //if assumption fails, test is skipped. Test is not marked as failure
		
		assertEquals(true,testFile.canRead());
	}
	

	@Test
	public void inputStream_canReadEntireFile() {
		try {
			
		
			FileInputStream in=new FileInputStream(testFile);
			int ch;
			long count=0;
			while((ch= in.read() )!=-1)
				count++;
			
			
			assertEquals(size, count);
		}
		catch(Exception ex) {
			fail("unable to read the file");
		}
	}

	
	@Test
	public void can_writeAndReadStream() {

			String input="Hello World";
			
			byte [] inputData= input.getBytes();
			
			ByteArrayInputStream bis=new ByteArrayInputStream(inputData);
			
			ByteArrayOutputStream bos=new ByteArrayOutputStream(input.length());
			
			int ch;
			while(bis.available()>0)
				bos.write(bis.read());

			String output= new String(bos.toByteArray());
			
			assertEquals(input, output);
			
	}
	
	

	
	
	
	
}







