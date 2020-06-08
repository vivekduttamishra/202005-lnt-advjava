package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

public class CountDownThread extends Thread{
	int max;
	
	
	public CountDownThread(int max) {
		super();
		this.max = max;
	}


	public void run() {
		
		
	
		println("starts");
		
		while(max>=0) {
			println("counts %d",max);
			max--;
		}
		
		println("ends");
	}

}
