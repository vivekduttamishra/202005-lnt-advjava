package demo.threading09.workerdemo1;

public class Basket {
	
	long items;

	
//	public synchronized void addItem(){
//		long item=items;
//		item++;
//		items=item;
//	
//	}
	
	
	public  void addItem(){
		 
		//no lock here. look in the worker
		
			long item=items;
			item++;
			items=item;		
		
	
	
	}

	public long getItems() {
		return items;
	}

}



