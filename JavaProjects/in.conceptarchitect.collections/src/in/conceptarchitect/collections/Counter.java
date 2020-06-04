package in.conceptarchitect.collections;

public class Counter {
	int value;
	
	public void increment() {
		value++;
	}
	public void decrement() {
		value--;
	}
	public void reset() {
		value=0;
	}
	public int getValue() {
		return value;
	}

}
