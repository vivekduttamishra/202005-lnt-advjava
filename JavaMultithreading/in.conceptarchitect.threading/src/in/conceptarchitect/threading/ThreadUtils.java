package in.conceptarchitect.threading;

public class ThreadUtils {

	public static void logLine(Object format, Object ...args) {
		
		log(format+"\n",args);
		
		
	}
	
	public static void log(Object format, Object ...args) {
		
		String message=String.format(format.toString(), args);
		
		System.out.print("["+Thread.currentThread().getId()+"]\t"+message);
		
	}
	
	
	public static Thread threadStart(Runnable runnable) {
		
		Thread thread=new Thread(runnable);
		thread.start();
		return thread;
		
	}
	
	public static void threadSleep(int ms) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			new ThreadInterruptedException(e.getMessage(),e);
		} 
	}
	
	
	
}
