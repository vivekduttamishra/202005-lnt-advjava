package testapp15.taskmanagerdesktop;



import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import in.conceptarchitect.swt.ControlBuilder;
import in.conceptarchitect.swt.MessageDialog;
import in.conceptarchitect.swt.UIBuilder;

public class MainUiBuilder implements UIBuilder {

	
	
	public void build(Composite composite) {
		// TODO Auto-generated method stub
		ControlBuilder builder=new ControlBuilder(composite);
		
		composite.setLayout(new RowLayout());
		
		builder.button("Click Me")
		//.background(0, 0, 0)
		//.foreground(255, 255, 255)
		.get(Button.class)
		.addListener(SWT.Selection, e -> MessageDialog.info("Hello World", "Welcome to Task Manager"));
	
		
	}

}
