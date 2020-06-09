package in.conceptarchitect.swt;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.junit.Test;


public class GridTests {

	@Test
	public void gridHorizontalStretchSetsHorizontalAligntmentToFill() {
		
		GridData data=Grid.data().horizontalStretch().get();
		
		assertEquals(SWT.FILL, data.horizontalAlignment);     
		
	}
	
}
