package testapp08.javastreams;

public class Primes {
	
	
	public static  boolean isPrime(Integer v) {
		int value=v;
		if(value<2) return false;
		if(value==2) return true;
		
		for(int i=2;i<value;i++)
			if(value%i==0)
				return false;
		
		return true;
	}

	
}
