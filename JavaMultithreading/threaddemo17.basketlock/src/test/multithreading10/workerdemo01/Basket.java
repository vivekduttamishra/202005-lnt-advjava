package test.multithreading10.workerdemo01;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import in.conceptarchitect.threading.ThreadUtils;

public class Basket {

	long items;
	//TODO-1 Add a Field of type 'Lock'
	ReentrantLock lock;
	
	private boolean lockRequired;
	
	public Basket(boolean lockRequired){
		this.lockRequired=lockRequired;

		if(lockRequired)
			//TODO-2 Create a RenterentLock Object
			lock=new ReentrantLock();
	}
	
	

	public void addItem(){
	
		
		
		int attempt=0;
		boolean gotLock=false;
		try{
				
			
			if(lockRequired){
				
				while(attempt<3){
					//TODO-3 Try to Take a Lock 3 times at an interval of 10 ms 
					if(!lock.tryLock(10,TimeUnit.MILLISECONDS)) {
					    // if you can't get the lock try again in 10 ms
						attempt++;
						ThreadUtils.sleep(10);
					}
					else
						gotLock=true;
				}
				
				
				
				//If you fail to take the lock. Print and X and quit
				if(!gotLock){
					
					System.out.print("X");
					return ;
				}
			}
				
				
				//Do the Actual job it lock is successfull
				
			
				long x=items;
				x=x+1;
				items=x;
				
				
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			//TODO-4: Uncomment and complete the if below
			if(gotLock)
				lock.unlock(); //now others can enter.
		}
	}



	private void someOtherTime(int attempt) {
		
	}
	
	public long getItems() {
		return items;
	}

}
