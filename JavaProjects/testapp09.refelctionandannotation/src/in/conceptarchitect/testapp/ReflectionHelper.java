package in.conceptarchitect.testapp;

import java.lang.reflect.Method;

import javax.management.RuntimeErrorException;

import in.conceptarchitect.animalkingdom.SpecialBehavior;
import in.conceptarchitect.animalkingdom.Speciality;

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

	public static void execute(Object object) {
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
	
	public  static  void executeSpecialBehavior(Object object) {
		
		Class<?> classType=null;
		
		if(object instanceof Class) {
			try {
				
				classType=(Class<?>) object;
				object= classType.newInstance();
			} catch(Exception ex) {
				throw new RuntimeException(ex.getMessage(),ex);
			}
		}else
			classType= object.getClass();
		
		
		int specialMethods=0;
		for(Method method : classType.getMethods()) {
			
			
			if(method.getDeclaringClass().equals(Object.class))
				continue; //I don't want to talk about Object class method
			

			
			if(method.getParameterCount()!=0)
				continue; //we will work with 0 parameter methods only for now
	
			
			//check if this special method or not
			if(method.getAnnotationsByType(SpecialBehavior.class).length==0)
				continue ; //this is not a special method
			
			
			
			
			try {
				specialMethods++;
				System.out.print("executing "+method.getName()+"...");
				Object result =method.invoke(object);
				System.out.println(result);
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
			
		}
		
		if(specialMethods==0)
			System.err.println(classType.getSimpleName()+" has no special behavior");
	
	}


	public  static  void executeSpeciality(Object object) {
		
		Class<?> classType=null;
		
		if(object instanceof Class) {
			try {
				
				classType=(Class<?>) object;
				object= classType.newInstance();
			} catch(Exception ex) {
				throw new RuntimeException(ex.getMessage(),ex);
			}
		}else
			classType= object.getClass();
		
			
		
	   Speciality speciality= classType.getAnnotation(Speciality.class);
		
	   if(speciality==null) {
		   System.err.println(classType.getSimpleName()+" has no speciality");
		   return;
	   }
	   
	   try {
		
		   Method specialityMethod = classType.getMethod(speciality.name());
		
		   for(int i=0;i<speciality.times();i++) {
			   Object result=specialityMethod.invoke(object);
			   System.out.println(speciality.name()+"#"+(i+1)+":\t"+result);;
		   }
		   return ;
		
		
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		System.err.println(classType.getSimpleName()+" has no speciality called "+speciality.name());
	}catch(Exception ex) {
		throw new RuntimeException(ex.getMessage(), ex);
	}
	   
	   
	   
	}

	
	
	
	
	
	

}
