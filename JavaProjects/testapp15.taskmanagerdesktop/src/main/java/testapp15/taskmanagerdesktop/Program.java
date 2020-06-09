package testapp15.taskmanagerdesktop;

import in.conceptarchitect.swt.Application;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println("Hello World");
		
		Application
				.instance
				.setTitle("Hello SWT Maven App")
				.build(new MainUiBuilder())
				.run();
	}

}
