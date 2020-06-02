package in.conceptarchitect.collections;

import java.util.Iterator;

public interface Collection<X> extends Iterable<X> {

	
	void add(X value);
	int size();


}
