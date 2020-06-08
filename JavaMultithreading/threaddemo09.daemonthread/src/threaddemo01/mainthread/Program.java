package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.logLine;

import static in.conceptarchitect.threading.ThreadUtils.*;


public class Program {


	public static void main(String[] args) {
	
		Thread t1=threadStart(()->countDown(200));
		
		Thread t2=threadStartNonCritical(()->countDown(2000));
		
		Thread t3=threadStart(()->countDown(300));
		
		
		
		threadAwait(t1,t3);
	
	
		logLine("main ends");
	
	}
	
	
	public static void main01(String[] args) {
		// TODO Auto-generated method stub
		
		
		Thread t1=new Thread( ()-> countDown(200));

		Thread t2=new Thread( ()-> countDown(2000));
		
		Thread t3=new Thread( ()-> countDown(300));
		
		
		
		
		//when other threads will finish
		//this thread will be killed
		
		t1.start();
		t2.start();
		t3.start();
		
		//t2.setDaemon(true); //its is a non-critical task
		
		//if some non daemon waits for a daemon, then daeomon is as good as non daemon
		//the main thread will not end till daemon ends.
		//threadAwait(t1,t2,t3);
		
		//as a good practice main should wait for non-daeomon threads only
		threadAwait(t1,t3);
		
		//now that non-daemon threads are dead, daemon will be killed.
		
		logLine("\nProgram Ends");
		
		
		
		
		
		
		
	}

		
	public static void countDown(int max) {
		
		
		
		logLine("starts");
		
		while(max>=0) {
			logLine("counts %d",max);
			max--;
		}
		
		logLine("ends");
	}
}
