package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.println;

import static in.conceptarchitect.threading.ThreadUtils.*;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Thread t1= threadStart(Program::quickCountDown);

		Thread t2= threadStart(Program::quickCountDown);

		Thread t3= threadStart(Program::quickCountDown);
		
		
		//how to make sure main ends after the other three
		
		
		//option#1 - reduce mains priority
		//reduceMainPriority();
		
		
		//option#2 - keep main busy 
		//keepMainBusy();
		
		
		//option#3 make main sleep
		//sleepyMain();
		//threadSleep(5000);
		
		
		//waitForThreads(t1, t2, t3);  //main thread will sleep till t1 finishes
		
		waitFor(t1,t2,t3);
		
		
		
		
		//this should be last line printed
	
		println("\nProgram Ends");
		
		
		
		
		
		
		
	}

	private static void waitForThreads(Thread t1, Thread t2, Thread t3) {
		try {
			t1.join(); //current thread should wait till t1 joins
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void sleepyMain() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //suspend main for next 5 seconds
	}

	private static void keepMainBusy() {
		for(int i=0;i<20000;i++)
			System.out.print("+");
	}

	private static void reduceMainPriority() {
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
	}
	
	public static void quickCountDown() {
		countDown(100);
	}
	
	public static void countDown(int max) {
		
		
		
		println("starts");
		
		while(max>=0) {
			println("counts %d",max);
			max--;
		}
		
		println("ends");
	}
}
