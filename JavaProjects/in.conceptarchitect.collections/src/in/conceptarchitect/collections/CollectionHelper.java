package in.conceptarchitect.collections;

public class CollectionHelper {
	
	public static <E> int id(E item) {
		return item.hashCode();
	}

	public static <E> String str(E item) {
		return item.toString();
	}

	public static  int indexOf(IndexedList<Object> list, Object value) {
		int p=0;
		
		for(int p=0; p<list.size(); p++) {
			Object listValue= list.get(p)   ; 
			if(listValue.equals(value))
				return p;
		}
		
		list.add("hello world");
		
		return -1;
	}
	
	public static  int indexOf(IndexedList<?> list, Object value) {
		int p=0;
		
		for(int p=0; p<list.size(); p++) {
			Object listValue= list.get(p)   ; 
			if(listValue.equals(value))
				return p;
		}
		
		list.add("hello world");
		
		return -1;
	}

	
}
