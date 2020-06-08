package threaddemo01.mainthread;

import in.conceptarchitect.threading.ThreadUtils;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CountDownTask t1=new CountDownTask(200);
		CountDownTask t2=new CountDownTask(150,false);
		CountDownTask t3=new CountDownTask(300);
		
		t2.start();
		t1.start(); //shouldn't start twice
		
	
		ThreadUtils.println("Program Ends");
		
	}
}
