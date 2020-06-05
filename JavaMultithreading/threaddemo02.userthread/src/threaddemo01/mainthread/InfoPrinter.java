package threaddemo01.mainthread;

public class InfoPrinter implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread currentThread=Thread.currentThread();
		System.out.println("Thread #"+currentThread.getId()+" has name "+currentThread.getName());
	}

}
