package in.conceptarchitect.streams;

import java.util.Random;
import java.util.stream.Stream;

public class RandomNumbers {
	
	Random random=new Random();
	
	int min=Integer.MIN_VALUE;
	int max=Integer.MAX_VALUE;
	int count=Integer.MAX_VALUE;
	
	
	public RandomNumbers() {
		super();
	}

	public RandomNumbers(int min, int max, int count) {
		super();
		
		this.min = min;
		this.max = max;
		this.count = count;
	}

	int getRandom() {
		
		int r= random.nextInt();
		
		if(min!=Integer.MIN_VALUE && max!=Integer.MAX_VALUE) {
			
			r= min + Math.abs(r)%(max-min+1);
		}
		
		return r;
	}
	
	public Stream<Integer> stream(){
		return Stream.generate(this::getRandom).limit(count);
	}

}
