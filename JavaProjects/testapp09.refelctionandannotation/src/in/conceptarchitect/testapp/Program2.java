package in.conceptarchitect.testapp;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		String className=Input.readString("Class?");
		
		if(!className.contains("."))
			className="in.conceptarchitect.animalkingdom."+className;
		
		Class<?> classObject= Class.forName(className);
		
		//ReflectionHelper.execute(classObject);
		
		//ReflectionHelper.executeSpecialBehavior(classObject);
		
		ReflectionHelper.executeSpeciality(classObject);
		
		
	}

}
