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

import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;
import in.conceptarchitect.streams.RandomNumbers;

public class CustomStreamTests {

	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void randomStreamCanGenerateRandomNumber() {
		
		RandomNumbers randomNumber=new RandomNumbers(1,6,100);
		
		Stream<Integer> stream= 
					randomNumber
					.stream()
					.distinct()
					.sorted();
		
		stream.forEach(System.out::println);
		
		
		
	}
	
	@Test
	public void dynamicArrayCanBeStreamed() {
		
		
		//LinkedList<String> result=new LinkedList<String>();
		
		List<String> result=
		IndexedList
			.createArray("India","France","Japan","USA","UK","Germany","UAE", "Norway") //dynamic arra
			.stream()   //converted to stream
			.filter(s->s.length()>3)
			.sorted((x,y)-> x.compareTo(y))
			.map(s->s.toUpperCase())
			.collect(Collectors.toList());
		
		
		//names.forEach(System.out::println);
		
		//result.each(System.out::println);
		
		assertEquals("NORWAY", result.get(result.size()-1));
		assertEquals("FRANCE", result.get(0));
		
		
		
	}

}
