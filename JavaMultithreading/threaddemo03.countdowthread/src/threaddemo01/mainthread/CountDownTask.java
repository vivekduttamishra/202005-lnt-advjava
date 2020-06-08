package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

public class CountDownTask implements Runnable{
	
	public void run() {
		
		int max=20;
	
		println("starts");
		
		while(max>=0) {
			println("counts %d",max);
			max--;
		}
		
		println("ends");
	}

}
