package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

public class CountDownTask implements Runnable{
	int max;
	
	
	public CountDownTask(int max) {
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
