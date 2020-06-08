package threaddemo01.mainthread;

import static in.conceptarchitect.threading.ThreadUtils.println;

import static in.conceptarchitect.threading.ThreadUtils.*;
import static in.conceptarchitect.utils.PerformanceMeasure.*;

public class Program {


	public static void main(String[] args) {
	
		int n=7, r=2;
		
		
		execute("Permutation without using Thread", ()->permutation(n,r) );
		
		
		execute("Permutation with threads", ()->permutation4(n,r));
		
	}
	
	
	public static int permutation4(int n,int r) {
		
		Factorial fn=   new Factorial(n);
		
		Factorial fn_r= new Factorial(n-r);
		
		
		System.out.println("factorial calculations started...");
		
		// the two task have started on different threads
		//But have they finished?
		//They may take 7 seconds and 5 seconds to completee
		//we reach here in few ms.
		//we must wait for them to finish
		//if you check for result, it waits till result is ready
		return fn.result()/ fn_r.result();
		
	}
	
	
	public static int permutation3(int n,int r) {
		
		Factorial fn=   new Factorial(n);
		
		Factorial fn_r= new Factorial(n-r);
		
		
		System.out.println("factorial calculations started...");
		
		// the two task have started on different threads
		//But have they finished?
		//They may take 7 seconds and 5 seconds to completee
		//we reach here in few ms.
		//we must wait for them to finish
		fn.await();      //should a factorial function have await() or stop()?
		fn_r.await();
		
		return fn.result()/ fn_r.result();
		
	}
	
	
	public static int permutation2(int n,int r) {
		
		Factorial fn=   new Factorial(n);
		
		Factorial fn_r= new Factorial(n-r);
		
		
		System.out.println("factorial calculations started...");
		
		// the two task have started on different threads
		//But have they finished?
		//They may take 7 seconds and 5 seconds to completee
		//we reach here in few ms.
		
		return fn.result()/ fn_r.result();
		
	}
	
	public static int permutation(int n, int r) {
		
		int fn=Factorial.calculate(n);
		int fn_r=Factorial.calculate(n-r);
		return fn/fn_r;
		
	}
	
	
	
	

	private static void measurePerformanceTest() {
		execute("How must time sleep 3000 takes", ()->{
			
			try {
				Thread.sleep(3000);
			}catch(Exception e) {
				
			}
			
			
		});
	}
	
	
}
