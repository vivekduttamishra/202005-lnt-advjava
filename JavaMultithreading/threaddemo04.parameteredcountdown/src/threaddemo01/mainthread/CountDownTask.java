package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

public class CountDownTask implements Runnable{
	int max;
	
	
	public CountDownTask(int max) {
		super();
		this.max = max;
	}


	public void run() {
		
		
	
		logLine("starts");
		
		while(max>=0) {
			logLine("counts %d",max);
			max--;
		}
		
		logLine("ends");
	}

}
