package threaddemo01.mainthread;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask();
		CountDownTask task2=new CountDownTask();
		
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		
		t1.start();
		t2.start();
	
		ThreadUtils.logLine("Program Ends");
		
	}
}
