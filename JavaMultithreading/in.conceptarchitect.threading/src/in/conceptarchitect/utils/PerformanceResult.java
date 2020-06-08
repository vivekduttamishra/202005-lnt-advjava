package in.conceptarchitect.utils;

public class PerformanceResult<E> {
	
	long startTime;
	long endTime;
	private E result;

	public PerformanceResult<E> start() {
		// TODO Auto-generated method stub
		startTime=System.currentTimeMillis();
		return this;
	}
	
	public PerformanceResult<E> stop() {
		endTime=System.currentTimeMillis();
		return this;
	}
	
	public PerformanceResult<E> setResult(E result){
		this.result=result;
		return this;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public E getResult() {
		return result;
	}
	
	public long timeTaken() {
		return endTime-startTime;
	}

}
