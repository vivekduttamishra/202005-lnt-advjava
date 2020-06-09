package in.conceptarchitect.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;

public class Grid {
	GridData data;
	
	public static Grid data() {
		Grid grid = new Grid();
		grid.data=new GridData();		
		return grid;
	}
	
	public Grid horizontalAlignment(int style) {
		data.horizontalAlignment=style;
		return this;
	}
	
	public Grid horizontalStretch() {
		data.horizontalAlignment=SWT.FILL;
		return this;
	}
	public Grid horizontalCenter() {
		data.horizontalAlignment=SWT.CENTER;
		return this;
	}
	
	public Grid verticalAlignment(int style) {
		data.verticalAlignment=style;
		return this;
	}
	
	public Grid verticalStretch() {
		data.verticalAlignment=SWT.FILL;
		return this;
	}
	public Grid verticalCenter() {
		data.verticalAlignment=SWT.CENTER;
		return this;
	}
	
	public Grid stretch() {
		horizontalStretch();
		verticalStretch();
		return this;
	}
	
	public Grid center() {
		horizontalCenter();
		verticalCenter();
		return this;
	}
	
	public Grid hgrab() {
		data.grabExcessHorizontalSpace=true;
		return this;
	}
	
	public Grid vgrab() {
		data.grabExcessVerticalSpace=true;
		return this;
	}
	
	public Grid grab() {
		hgrab();
		vgrab();
		return this;
	}
	
	public Grid size(int width,int height) {
		data.widthHint=width;
		data.heightHint=height;
		return this;
	}
	
	public Grid applyTo(Control control) {
		control.setLayoutData(data);
		return this;
	}
	
	public GridData get() {
		return data;
	}
	
	public Grid hspan(int cols) {
		data.horizontalSpan=cols;
		return this;
	}
	public Grid vspan(int rows) {
		data.verticalSpan=rows;
		return this;
	}
	
	
	
}
