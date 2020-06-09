package in.conceptarchitect.swt;




import java.util.HashMap;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class Application {
	
	Shell shell;
	Display display;
	
	HashMap<String,Object> services=new HashMap<String,Object>();
	
	public Application addService(String name, Object service) {
		services.put(name, service);
		return this;
	}
	
	public <E> E getService(String name, Class<E> type) {
		return (E)services.get(name);
	}
	
	
	private Application() {
		
		//display=new Display();
		display=Display.getDefault();
		
		shell=new Shell(display);
		
	}
	
	public static final Application instance=new Application();
	

	public Shell getShell() {
		return shell;
	}

	//center the main shell of our application
	
	public Application center() {
		return center(shell);
	}
	
	//center the any applicaiton shell on the display
	//you window should appear in center of the main display.
	public Application center(Shell shell) {
		//let us find the size of the display;
		Rectangle screen= display.getBounds();
		//System.out.println("screen size is "+screenArea.width+"x"+screenArea.height);
		
		Rectangle window=shell.getBounds();
		
		int x=(screen.width-window.width)/2;
		int y=(screen.height-window.height)/2;
		
		shell.setLocation(x, y);
				
		return this;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}


	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Application build(UIBuilder builder) {
		
		builder.build(shell);
		return this;
	}
	
	public Application setTitle(String title) {
		shell.setText(title);
		return this;
	}
	
	public Application packShell() {
		shell.pack();
		return this;
	}

	public void run() {
		shell.setVisible(true);
		while(!shell.isDisposed()) {  //as long as my window is not closed.
			//read message from queue and dispatch to listners
			if(!display.readAndDispatch()) //if no message found
				display.sleep(); //wait till next message arrives.				
		}
	}
	
}
