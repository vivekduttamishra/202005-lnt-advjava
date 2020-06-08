package test.multithreading18.futureandcallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.utils.PerformanceMeasure;

public class Program {

	

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		
		
		//TODO: 1. create a ThreadPool object
		ExecutorService executor=Executors.newCachedThreadPool();	
		
		
		//userSequentialOrBlockingCall();

		//userNormalExecutor(executor);
		
		
		//useCallableAndFuture(executor);
		
		multipleCallables(executor);
		
		
		
		
		
		
		
		//sequentialExecution();
		
		

		
		//TODO: 6. Shutdown Executor
		executor.shutdown();
		
		//TODO: 7. Wait for Current Jobs to terminate
		executor.awaitTermination(1, TimeUnit.MILLISECONDS);
			
	}

	private static void userSequentialOrBlockingCall() {
		//Sequential call
		System.out.println("Going to calculate all prime upto 200000");
		PrimeResult result= countPrimes(0, 200000);
		System.out.println("Work is completed. Result is "+result);
	}

	private static void userNormalExecutor(ExecutorService executor) {
		//Normal executor
		System.out.println("Going to calculatre prime using Executor.execute");
		executor.execute(()-> countPrimes(2, 200000));
		System.out.println("You reach here immediately. But we have no way to check the result of calculation");
	}

	private static void useCallableAndFuture(ExecutorService executor) throws InterruptedException, ExecutionException {
		//Callable and Future
		
		Future<PrimeResult> future= executor.submit(()-> countPrimes(2,200000));
		System.out.println("task submitted waiting for the result");
		while(! future.isDone()) {
			System.out.print("▓");
			Thread.sleep(200);
		}
		System.out.println("\ndone. result is "+future.get());
	}

	private static void sequentialExecution() {
		PerformanceMeasure.execute("PrimeCount1 2-2L", ()->countPrimes(2, 200000));

		PerformanceMeasure.execute("PrimeCount 2-50K", ()->countPrimes(2, 50000));

		PerformanceMeasure.execute("PrimeCount 2-1L", ()->countPrimes(2, 100000));
	}

	private static void multipleCallables(ExecutorService executor) throws InterruptedException, ExecutionException {
		//This is three rang of prime finding Job
		int [] ranges= {100000,50000,200000};
		
		
		//TODO: 2. Create a List of Future Objects returning PrimeResult
		List<Future<PrimeResult>> results=new ArrayList<>();
		
		
		for(int max:ranges) {
			
			final int m=max;
			//TODO: 3. Create a Future Object returning prime result by calling executor.sumit
			Future<PrimeResult> result= executor.submit(()->countPrimes(2,m));
			
			//TODO: 4. Add the result to the List			
			results.add(result);
			
		}
		
		System.out.println("waiting for responses");
		
		//TODO: 5. loop through the result to find the answers
		for(Future<PrimeResult> result :results)
			System.out.println(result.get()); //automatically wait for result to come
	}
	
	static PrimeResult countPrimes(int min,int max) {
		PrimeResult result=new PrimeResult(min, max);
		
		
		for(int i=min;i<max;i++) {
			if(isPrime(i))
				result.addPrime();
			
		
		}
		return result;
	}

	private static boolean isPrime(int x) {
		
		if(x<2)
			return false;
		
		for(int i=2;i<x;i++)
			if(x%i==0)
				return false;
		
		return true;
	}

}
