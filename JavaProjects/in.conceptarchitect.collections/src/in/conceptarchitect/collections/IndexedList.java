package in.conceptarchitect.collections;

public interface IndexedList<X> extends Collection<X>
{
	

	X get(int pos);

	void set(int pos, X value);
	
	
	//default methods based on get/set and add/size
	
	default int indexOf(X value) {
		
		for(int i=0;i<size();i++)
			if(get(i).equals(value))
				return i;
		
		return -1;
	}
	
	//static methods
	
	static <E> LinkedList<E> createList(E ... values){
		LinkedList<E> list=new LinkedList<E>();
		list.addMany(values);
		return list;
	}
	
	static <E> DynamicArray<E> createArray(E ... values){
		DynamicArray<E> list=new DynamicArray<E>(values.length);
		list.addMany(values);
		return list;
	}
}