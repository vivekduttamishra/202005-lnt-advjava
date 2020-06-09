package in.conceptarchitect.swt;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Control;

public class Form {
	
	FormData fd; 
	
	public static Form data() {
		Form f=new Form();
		f.fd=new FormData();
		return f;
	}
	
	public static Form data(int width,int height) {
		Form f=new Form();
		f.fd=new FormData(width,height);
		return f;
	}
	
	
	public Form left(int percent) {
		fd.left=new FormAttachment(percent);
		return this;
	}
	
	public Form left(int percent,int offset) {
		fd.left=new FormAttachment(percent,offset);
		return this;
	}
	
	public Form left(int percent,int offset,int alignment) {
		fd.left=new FormAttachment(percent,offset,alignment);
		return this;
	}
	
	public Form left(Control control, int offset) {
		fd.left=new FormAttachment(control, offset);
		return this;
	}
	
	public Form left(Control control, int offset,int alignment) {
		fd.left=new FormAttachment(control, offset,alignment);
		return this;
	}
	
	public Form right(int percent) {
		fd.right=new FormAttachment(percent);
		return this;
	}
	
	public Form right(int percent,int offset) {
		fd.right=new FormAttachment(percent,offset);
		return this;
	}
	
	public Form right(int percent,int offset,int alignment) {
		fd.right=new FormAttachment(percent,offset,alignment);
		return this;
	}
	
	public Form right(Control control, int offset) {
		fd.right=new FormAttachment(control, offset);
		return this;
	}
	
	public Form right(Control control, int offset,int alignment) {
		fd.right=new FormAttachment(control, offset,alignment);
		return this;
	}
	
	
	public Form top(int percent) {
		fd.top=new FormAttachment(percent);
		return this;
	}
	
	public Form top(int percent,int offset) {
		fd.top=new FormAttachment(percent,offset);
		return this;
	}
	
	public Form top(int percent,int offset,int alignment) {
		fd.top=new FormAttachment(percent,offset,alignment);
		return this;
	}
	
	public Form top(Control control, int offset) {
		fd.top=new FormAttachment(control, offset);
		return this;
	}
	
	public Form top(Control control, int offset,int alignment) {
		fd.top=new FormAttachment(control, offset,alignment);
		return this;
	}
	
	public Form bottom(int percent) {
		fd.bottom=new FormAttachment(percent);
		return this;
	}
	
	public Form bottom(int percent,int offset) {
		fd.bottom=new FormAttachment(percent,offset);
		return this;
	}
	
	public Form bottom(int percent,int offset,int alignment) {
		fd.bottom=new FormAttachment(percent,offset,alignment);
		return this;
	}
	
	public Form bottom(Control control, int offset) {
		fd.bottom=new FormAttachment(control, offset);
		return this;
	}
	
	public Form bottom(Control control, int offset,int alignment) {
		fd.bottom=new FormAttachment(control, offset,alignment);
		return this;
	}

	
	public Form applyTo(Control control) {
		control.setLayoutData(fd);
		return this;
	}
	
	public FormData get() {
		return fd;
	}
	
	
	
	
	
}
