package in.conceptarchitect.utils;

public class PerformanceMeasure {

	
	public static PerformanceResult<Object> execute( String message, Runnable runnable) {
		
		PerformanceResult<Object> result=new PerformanceResult<>();
		if(message!=null)
			System.out.println(message+" started");
		result.start();
		runnable.run();
		
		result.stop();
		if(message!=null)
			System.out.println(message+" finished in "+result.timeTaken()+" ms");
		
		return result;
		
		
	}
	
	public static PerformanceResult<Object> execute(  Runnable runnable) {
		return execute(null, runnable);
	}
	
	public static <E> PerformanceResult<E> execute( String message, Producer<E> producer) {
		
		PerformanceResult<E> result=new PerformanceResult<>();
		if(message!=null)
			System.out.println(message+" started");
		result.start();
		
		
		result.setResult(producer.produce());
		
		result.stop();
		if(message!=null) {
			System.out.println(message+" finished in "+result.timeTaken()+" ms");
			System.out.println("result is "+result.getResult());
		}
		
		return result;
		
		
	}
	
	public static <E> PerformanceResult<E> execute(  Producer<E> producer) {
		return execute(null, producer);
	}

	

}
