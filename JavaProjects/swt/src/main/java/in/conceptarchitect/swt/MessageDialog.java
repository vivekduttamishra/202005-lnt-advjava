package in.conceptarchitect.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class MessageDialog {
	
	public static int show(String heading, String message, int style) {
		Shell shell=Display.getCurrent().getShells()[0];
		MessageBox mb=new MessageBox(shell,style);
		mb.setText(heading);
		mb.setMessage(message);
		return mb.open();
	}
	
	public static int info(String heading, String message) {
		return show(heading,message,SWT.ICON_INFORMATION);
	}
	
	public static int error(String heading, String message) {
		return show(heading,message,SWT.ICON_ERROR);
	}
	
	public static int warning(String heading, String message) {
		return show(heading,message,SWT.ICON_WARNING);
	}
	
	public static int yesNo(String heading, String message) {
		return show(heading,message,SWT.ICON_QUESTION|SWT.YES|SWT.NO);
	}
	
	public static int yesNoCancle(String heading, String message) {
		return show(heading,message,SWT.ICON_QUESTION|SWT.YES|SWT.NO|SWT.CANCEL);
	}
	
	

}