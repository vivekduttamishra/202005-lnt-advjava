package threaddemo01.mainthread;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask task1=new CountDownTask(200);
		CountDownTask task2=new CountDownTask(150);
		CountDownTask task3=new CountDownTask(300);
		
		
		Thread t1=new Thread(task1);
		Thread t2=new Thread(task2);
		Thread t3=new Thread(task3);
		
		t1.start();
		t2.start();
		t3.start();
	
		ThreadUtils.logLine("Program Ends");
		
	}
}
