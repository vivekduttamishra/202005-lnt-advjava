package in.conceptarchitect.collections;


@FunctionalInterface
public interface Action<E,R> {

	default boolean init() {return true; }
	
	/*
	 * called for each item of the collection
	 * if you want to stop processing throw ActionAbortException
	 * ActionAbortException can contain result 
	 */
	void execute(E value);
	
	default R result() {
		return null;
	}
	
}
