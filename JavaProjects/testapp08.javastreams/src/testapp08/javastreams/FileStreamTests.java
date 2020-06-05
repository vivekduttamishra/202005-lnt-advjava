package testapp08.javastreams;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.LinkedList;

public class FileStreamTests {

	String path="./src/mydata.txt";
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void canFindSortedDistinct5Primes() throws IOException {
		Stream<String> linesStream = Files.lines(Paths.get(path));
		
		List<Integer> result=
			linesStream
				.skip(3)   //first 3 values skipped
				.map(str->Integer.parseInt(str)) //convert to Integer
				.filter(n-> n%2!=0)  //remove evens
				.sorted()  //sorts all the value in ascending order
				.distinct() //remove duplicates
				.filter(Primes::isPrime) //filter the primes
				.limit(3)  // returns 3 smallest distinct primes numbers
				.collect(Collectors.toList());
			
		//result.forEach(System.out::println);
		
		assertEquals(29, (int)result.get(0));
		
		
	}
	
	@Test
	public void canAccessFilesInADirectory() throws IOException {
		
		LinkedList<String> list=new LinkedList<String>();
		
		Files
			.list(Paths.get("."))
			.map(p-> p.getFileName().toString())
			.filter(n-> !n.startsWith("."))
			.forEach(n->{
				System.out.println(n);
				list.add(n);
			});
			
		
		assertTrue(list.containsAll("bin","src"));
		
	}

}
