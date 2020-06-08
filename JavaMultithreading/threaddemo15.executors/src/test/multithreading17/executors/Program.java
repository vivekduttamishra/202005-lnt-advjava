package test.multithreading17.executors;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	

	public static void main(String[] args) throws InterruptedException {

		
		//runtTaskOnAThread();
		
		ExecutorService pool=Executors.newFixedThreadPool(4);
		
		for(int i=1;i<=15;i++) {
			final int id=i;
			pool.execute(()->task(id));
		}
		
		
		//TODO-2 shutdown executor
		//The pool will accept no new jobs
		//and will shutdown all its threads
		//once currently queued job is over.
		pool.shutdown(); 

		
		ThreadUtils.sleep(8000);
		System.out.println("Now calling shutdownNow()...");
		
		pool.shutdownNow();
		
		
		//TODO-3 wait for termination of current task
		System.out.println("Program Ends");
	}

	private static void runtTaskOnAThread() {
		for(int i=1;i<=15;i++) {
			final int id=i;
			ThreadUtils.threadStart(() -> task(id) );
		}
	}
	
	static void task(int id) {
		int max=5;
		ThreadUtils.println("task %d starts",id);
		while(max>=0) {
			ThreadUtils.println("task %d counts %d",id,max);
			max--;
			ThreadUtils.sleep(1000);
		}
		ThreadUtils.println("task %d ends",id);
	}

}
