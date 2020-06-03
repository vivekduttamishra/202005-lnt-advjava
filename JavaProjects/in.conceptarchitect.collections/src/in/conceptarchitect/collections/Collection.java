package in.conceptarchitect.collections;

import java.util.Iterator;


public interface Collection<X> extends Iterable<X> {

	
	//abstract methods
	void add(X value);
	int size();
	
	//default methods
	default void addMany(X ... values) {
		for(X value :values)
			add(value);
	}

	default boolean isEmpty() {
		return size()==0;
	}
	
	default boolean contains(X value) {
		for(X cvalue : this) {
			if(cvalue.equals(value))
				return true;
		}
		
		return false;
	}
	
    default boolean containsAny(X ... items) {
    	for(X item : items) {
    		if(contains(item))
    			return true;
    	}
    	
    	return false;
    }
    
    default boolean containsAll(X ... items) {
    	for(X item : items) {
    		if(!contains(item))
    			return false;
    	}
    	
    	return true;
    }
    
    default IndexedList<X> search(Matcher<X> matcher) {
		
		LinkedList<X> result=new LinkedList<X>();
		for(X item : this) {
			if(matcher.isMatch(item))
				result.add(item);
		}
		return result;
	}

    
    
    
    
    //static helper methods
    
    static <E> void copy(Collection<? extends E> from, Collection<? super E> to) {
    	for(E value : from)
    		to.add(value);
    }
    
    
    
}
