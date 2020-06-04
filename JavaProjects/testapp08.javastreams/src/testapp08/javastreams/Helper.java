package testapp08.javastreams;

import java.util.ArrayList;
import java.util.List;

public class Helper {
	
	public static <E> void tabprint(E value) {
		System.out.print(value+"\t");
	}
	
	
	public static List<Integer> range(int max){
		ArrayList<Integer> values=new ArrayList<>();
		for(int i=0;i<max;i++)
			values.add(i);
		
		return values;
	}
	
}
