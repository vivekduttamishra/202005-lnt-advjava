package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

public class Factorial {

	private int number;
	private int _result;

	private Thread thread;

	public  Factorial(int number) {
		this.number=number;
		
		thread= new Thread(()->{
			
			_result= calculate(number);
			System.out.println("calculation for "+number+" done");
			
		});
		
		
		thread.start();
		
		System.out.println("calcuation for "+number+" started...");
		
	}
	
	
	
	public static int calculate(int x) {
		
		int fx=1;
		for(int i=1;i<=x;i++) {
			threadSleep(1000);
			fx*=i;
		}
		
		return fx; 
		 
		
	}
	
	public void await() {
		if(thread.isAlive())
			threadAwait(thread);
	}



	public int result() {
		// TODO Auto-generated method stub
		await();
		return _result;
	}

}
