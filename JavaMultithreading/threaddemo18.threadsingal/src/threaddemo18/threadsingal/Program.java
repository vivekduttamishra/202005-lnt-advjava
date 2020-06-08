package threaddemo18.threadsingal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		ExecutorService executor=Executors.newFixedThreadPool(3);
		
		int max=10;
		
		CountDownLatch latch=new CountDownLatch(10);
		
		for(int i=1;i<10;i++) {
			final int id=i;
			
			executor.execute(()->{
				
				System.out.println("Task#"+id+" started");
				ThreadUtils.sleep(2000);
				System.out.println("Task#"+id+" finished");
				//announce that task is over
				latch.countDown(); //each task after finishing decreass latch count
				
			});
		}
		
		
		System.out.println("waiting for tasks to be over...");
		latch.await();
		System.out.println("Now the tasks are over");
		
		
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS); 
	}

}
