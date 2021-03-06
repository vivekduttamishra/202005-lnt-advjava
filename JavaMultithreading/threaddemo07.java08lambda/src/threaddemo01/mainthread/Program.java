package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.println;

import static in.conceptarchitect.threading.ThreadUtils.*;


public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Thread t1=new Thread(()-> countDown(200));
		
		Thread t2= threadStart(()->countDown(250));
		
		Thread t3=new Thread(Program::quickCountDown);
		
		
		t1.start();
		t3.start();
		
		
		
		
	
		println("Program Ends");
		
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
