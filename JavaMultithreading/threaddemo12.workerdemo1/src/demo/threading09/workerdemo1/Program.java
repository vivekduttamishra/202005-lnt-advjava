package demo.threading09.workerdemo1;

import in.conceptarchitect.consoleutils.Input;
import static in.conceptarchitect.utils.PerformanceMeasure.*;

public class Program {


	public static void main(String[] args) {
		
		Input input=new Input();
		int workersCount=input.readInt("how many workers? ");
		int itemsToAdd=input.readInt("How many item each worker shall add ?" );
		boolean sameBasket=input.readBoolean("Use same basket for every one ? ");
		Basket singleBasket=new Basket();
		
		
		
		//Step 1 -- Crate the works
		Worker [] workers=new Worker[workersCount];
		System.out.println("Creating workers and assigning them basket");
		for(int i=0;i<workers.length;i++){
			
			Basket basket= sameBasket ? singleBasket : new Basket();
			
			Worker worker=new Worker(basket,itemsToAdd);
			
			workers[i]=worker;
			
		}
		
		//Step 2 -- Send the workers to work
		execute("Workers are Working", ()->{
		
			
			for(int i=0;i<workers.length;i++)
				workers[i].start();
			
			
			//Step 3 -- Wait for Workers to Return
			System.out.println("waiting for workers to finish");
			for(Worker worker :workers)
				worker.waitFor();
			
		});
		
		//Step 4 -- Count The Items the added
		long totalItemsAdded=0;
		
		if(sameBasket)
			totalItemsAdded=singleBasket.getItems();
		else{
			
			for(Worker worker : workers)
				totalItemsAdded+=worker.getBasket().getItems();
			
		}
		
		
		System.out.println("Total items added is "+totalItemsAdded);
		
		
		
	
	}

}
