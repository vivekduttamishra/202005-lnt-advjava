package threaddemo01.mainthread;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread currentThread=Thread.currentThread();
		
		System.out.println(currentThread);  //thread-name: main, priority:5/10 (normal), group: main
		
		currentThread.setName("My Thread");
		currentThread.setPriority(8);
		
		System.out.println(currentThread);
	}

}
