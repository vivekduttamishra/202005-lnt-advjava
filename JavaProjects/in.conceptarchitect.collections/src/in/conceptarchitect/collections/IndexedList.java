package in.conceptarchitect.collections;

public interface IndexedList<X> extends Collection<X>
{
	

	X get(int pos);

	void set(int pos, X value);
	
}