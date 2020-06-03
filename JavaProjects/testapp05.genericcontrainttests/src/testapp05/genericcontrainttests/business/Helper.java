package testapp05.genericcontrainttests.business;

import in.conceptarchitect.collections.IndexedList;

public class Helper {

	
	public static <E extends Animal> double averageAge(IndexedList<E> list) {
		double sum=0;
		for(int i=0;i<list.size();i++) {
			E item= list.get(i);
			sum+= item.getAge();
			
		}
		
		return sum/list.size();
	}
	
	public static  double averageAge2(IndexedList<? extends Animal> list) {
		double sum=0;
		for(int i=0;i<list.size();i++) {
			Animal item= list.get(i);
			sum+= item.getAge();
			
		}
		
		return sum/list.size();
	}
}
