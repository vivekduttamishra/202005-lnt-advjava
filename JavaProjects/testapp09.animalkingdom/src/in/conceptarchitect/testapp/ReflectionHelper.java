package in.conceptarchitect.testapp;

import java.lang.reflect.Method;

public class ReflectionHelper {

	public static void execute(Class<?> classObject) {
		// TODO Auto-generated method stub

		try {
			Object object= classObject.newInstance();
			execute(object);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	private static void execute(Object object) {
		// TODO Auto-generated method stub
		
		Class<?> classType= object.getClass();
		
		for(Method method : classType.getMethods()) {
			
			
			if(method.getDeclaringClass().equals(Object.class))
				continue; //I don't want to talk about Object class method
			

			if(method.getParameterCount()!=0)
				continue; //we will work with 0 parameter methods only for now
			
			try {
				System.out.print("executing "+method.getName()+"...");
				Object result =method.invoke(object);
				System.out.println(result);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
			
			
		}
	}

}
