package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.*;

import java.lang.Thread.State;

public class CountDownTask implements Runnable{
	int max;
	boolean autoStart=true;
	Thread thread;
	
	public CountDownTask(int max) {
		this(max,true);
	}
	
	public CountDownTask(int max,boolean autoStart) {
		super();
		this.max = max;
		thread=new Thread(this);
		if(autoStart)
			thread.start();
	}

	public void start() {
		if(thread.getState()==State.NEW) //if not aleady started 
			thread.start();
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
