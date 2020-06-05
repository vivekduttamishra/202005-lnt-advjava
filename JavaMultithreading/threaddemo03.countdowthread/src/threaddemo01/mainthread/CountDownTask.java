package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

public class CountDownTask implements Runnable{
	
	public void run() {
		
		int max=20;
	
		logLine("starts");
		
		while(max>=0) {
			logLine("counts %d",max);
			max--;
		}
		
		logLine("ends");
	}

}
