package threaddemo01.mainthread;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfoPrinter printer=new InfoPrinter();
		
		Thread newThread=new Thread(printer); //create a new thread
		
		newThread.start();  //creates a new thread and invokes run() on new thread
		
		printer.run();
		
		//How many times run() method will be called?
	}

}
