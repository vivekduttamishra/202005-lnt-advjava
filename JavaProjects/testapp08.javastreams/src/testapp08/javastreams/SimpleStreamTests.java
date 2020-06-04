package testapp08.javastreams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.Counter;


public class SimpleStreamTests {

	List<Integer> numberCollection= Arrays.asList(8,2,5,25,51,93,33,43,55,28,42,20,19,53,83,93,37,53,24,19,45,53);
	Stream<Integer>  numberStream= numberCollection.stream();  //returns a stream

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void streamIsNotACollection() {
		Stream<Integer> stream= Stream.of(2,9,11,14,5,3,21,17,11,8);
		assertFalse(stream instanceof Collection);
	}
	
	@Test
	public void streamCanBeCreatedFromACollection() {
		
		Stream<?> stream=numberCollection.stream();
		assertTrue(stream instanceof Stream);
	}
	
	
	@Test
	public void streamCountIsATerminalFunction() {
		
		long streamCount= numberStream.count();  //count looks similar to size() of collection
		
		assertEquals(numberCollection.size(), streamCount);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void streamCantExecuteTerminalOperationMoreThanOnce() {
		
		//Arrange
		long count= numberStream.count();  //we have consumed the stream here
		System.out.println("count() consumed the stream. total values "+count);
		
		//ASSERT --- you can't consume (count) stream a second time
		numberStream.count(); //throws IllegalStateException if we try terminal operation more than once
		
		
	}
	
	
	
	@Test
	public void streamCanbeRegeneratedFromSource() {
		
		//Arrange --- consume the first stream
		long count1=numberStream.count();
		
		//we can can't use same stream again
		//but we can create a new stream from the same source again
		Stream<?> secondStream= numberCollection.stream() ; //creates a new stream every time
		
		assertEquals(count1, secondStream.count());
		
		
		
	}
	
	@Test
	public void forEach_isATerminalOperation() {
		
		Counter counter=new Counter();
		
		
		
		numberStream.forEach( v-> counter.increment());
		
		assertEquals(numberCollection.size(), counter.getValue());
		
		
		
	}
	
	
	
	@Test(expected=IllegalStateException.class)
	public void oneStreamCantHaveTwoTerminals() {
		
		System.out.print("using foreach");
		numberStream.forEach(Helper::tabprint);
		
		//now you can't use any other terminal operation
		
		long count=numberStream.count();
	}
	
	
	@Test
	public void filter_producesANewStream() {
		
		
		
			Stream<?> resultStream = numberStream.filter( n -> (int)n % 5==0);
			
			assertNotSame(numberStream, resultStream);
		
	}
	
	@Test
	public void filter_toFindStreamOfAllMultiplesOf5() {
		Stream<?> m5Stream= numberStream.filter( n -> (int) n%5 ==0  );
		
		assertEquals(5, m5Stream.count());
	}
	
	@Test
	public void intermediateOperationChain() {
		
		
		List<?> result =numberStream
							.filter( n -> n% 2!=0 )  // stream of odds
							.filter( n -> n %5!=0 )   //stream of odds not ending with 5
							.filter( Primes::isPrime)	     // a list of primes not ending with 5
							.map(n-> n*10 )        //converts a stream of one values in another
							.collect(Collectors.toList()); //Terminal: make a list of value
	
		System.out.println("\nresult of filter and map");
		result.forEach(Helper::tabprint); //collection foreach can be used multiple ties
		System.out.println("\nend of result");
		
	}
	
	
	@Test
	public void streamOperationsDontExecuteTillTheTerminalIsApplied() {
		
		Stream<Integer> stream= Helper.range(101) //List of 0-100
									  .stream(); //stream of 0 -100
		
		Counter gt50=new Counter();
		Counter oddFilter=new Counter();
		Counter f5=new Counter();
		Counter i4=new Counter();
		
		Stream<Integer> result= stream
					.filter(n->{   //all values reach 0-100 -->101
						System.out.println("[i1 : "+n+"]\t");
						gt50.increment();
						return n>50;  //filters 51-100 -->50
					})
					.filter(n->{  
						System.out.println("[i2 : "+n+"]\t");
						oddFilter.increment();
						return n%2!=0;  //filter out half of it 25
					})
					.filter(n->{
						System.out.println("[i3 : "+n+"]\t");
						f5.increment();
						return n%5==0; //filters out 5th of it 5
					});
						
		
		//A stream is nonoperational till you apply a terminal
		
		assertEquals(0, gt50.getValue()); //all value reached first filter
		assertEquals(0, oddFilter.getValue()); //only 51-100 reached here
		assertEquals(0, f5.getValue()); //only odds between 51-100 reached here
		
		System.out.println("Stream created. Now applying terminal");
		
		//total itmes out fo last filter
		List<Integer> m5=result.collect(Collectors.toList()); //oh! terminal is applied. stream will run
		
		
		assertEquals(101, gt50.getValue()); //all value reached first filter
		assertEquals(50, oddFilter.getValue()); //only 51-100 reached here
		assertEquals(25, f5.getValue()); //only odds between 51-100 reached here
		
		
	    assertEquals(5, m5.size());
		
		
	}
	
	
	

}
