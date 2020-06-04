package in.conceptarchitect.collections;

@FunctionalInterface
public interface Matcher<T> {

	boolean isMatch(T item);
	
	default boolean isNotMatch(T item) {
		return !isMatch(item);
	}

}




/*

			1. Functional interface can have default methods
			2. Lambda will always be mapped to abstract method. not default

*/