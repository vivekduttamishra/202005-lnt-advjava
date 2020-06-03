package in.conceptarchitect.collections;

public class CollectionHelper {
	
	public static <E> int id(E item) {
		return item.hashCode();
	}

	public static <E> String str(E item) {
		return item.toString();
	}

	public static  int indexInObjectList(IndexedList<Object> list, Object value) {
		
		
		for(int p=0; p<list.size(); p++) {
			Object listValue= list.get(p)   ; 
			if(listValue.equals(value))
				return p;
		}
		
		list.add("hello world"); //you can add invalid object
		
		return -1;
	}
	
	public static  int indexOf(IndexedList<?> list, Object value) {
		
		
		for(int p=0; p<list.size(); p++) {
			Object listValue= list.get(p)   ; 
			if(listValue.equals(value))
				return p;
		}
		
		//List of ? doesn't allow modification
		//list.add("hello world");
		
		return -1;
	}

	
	public static <E> void copy(IndexedList<E> from, IndexedList<E> to) {
		for(E value : from) {
			to.add(value);
		}
	}
	
	public static <E> void copy2(IndexedList<E> from, IndexedList<? super E> to) {
		for(E value : from) {
			to.add(value);
		}
	}
	
	
	
}
