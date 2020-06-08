package in.conceptarchitect.threading;

public class ThreadUtils {

	public static void logLine(Object format, Object ...args) {
		
		log(format+"\n",args);
		
		
	}
	
	public static void log(Object format, Object ...args) {
		
		String message=String.format(format.toString(), args);
		
		System.out.print("["+Thread.currentThread().getId()+"]\t"+message);
		
	}
	
	
	public static Thread threadStart(Runnable runnable, boolean isCritical) {
		
		Thread thread=new Thread(runnable);
		thread.setDaemon(!isCritical);
		thread.start();
		return thread;
		
	}
	
	
	public static Thread threadStart(Runnable runnable) {
		
		return threadStart(runnable,true);
		
	}
	
	public static Thread threadStartNonCritical(Runnable runnable) {
		return threadStart(runnable,false);
		
	}
	
	
	
	public static void threadSleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			new ThreadInterruptedException(e.getMessage(),e);
		} 
	}
	
	
	public static void threadAwait(Thread ...threads) {
		
		try {
			for(Thread thread:threads)
				thread.join();
		}catch(InterruptedException ex) {
			throw new ThreadInterruptedException(ex.getMessage(),ex);
		}
	}
	
	
}
