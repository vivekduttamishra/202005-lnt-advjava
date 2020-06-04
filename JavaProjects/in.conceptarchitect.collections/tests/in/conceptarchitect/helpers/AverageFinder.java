package in.conceptarchitect.helpers;

import in.conceptarchitect.collections.Action;

public class AverageFinder<E extends Number> implements Action<E, Double>{

	double sum;
	double count;
	
	@Override
	public boolean init() {
		// TODO Auto-generated method stub
		sum=0;
		count=0;
		return true;
		
	}
	
	@Override
	public void execute(E value) {
		// TODO Auto-generated method stub
		sum+=value.doubleValue();
		count++;
	}
	
	@Override
	public Double result() {
		// TODO Auto-generated method stub
		return sum/count;
	}

}
