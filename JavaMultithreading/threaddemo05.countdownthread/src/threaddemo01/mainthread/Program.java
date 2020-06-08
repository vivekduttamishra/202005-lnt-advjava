package threaddemo01.mainthread;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownThread t1=new CountDownThread(200);
		CountDownThread t2=new CountDownThread(150);
		CountDownThread t3=new CountDownThread(300);
		
		
		
		t1.start();
		t2.start();
		t3.start();
	
		ThreadUtils.println("Program Ends");
		
	}
}
