package in.conceptarchitect.practices.jdbc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

import javax.management.RuntimeErrorException;

public class ObjectResultSetMapper<E> implements ResultSetMapper<E> {

	Class<E> cls;

	public ObjectResultSetMapper(Class<E> cls) {
		// TODO Auto-generated constructor stub
		this.cls = cls;
	}

	@Override
	public E map(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		// step1 create a new object of type E
		E object = null;

		try {
			object = (E) cls.newInstance();

		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}

		// step2 get all setter methods that take one parameter

		for (Method method : cls.getMethods()) {

			try {
				if (!(method.getName().startsWith("set") && method.getParameterCount() == 1)) {
					continue; // ignore this method
				}

				//System.out.println("mehdod name " + method.getName());

				// now we have set method. let us find the set field name
				String name=method.getName().substring(3);
				String fieldName= name.substring(0,1).toLowerCase()+name.substring(1);
				
				
				
				Field field = cls.getDeclaredField(fieldName);
				
				TableColumn column= field.getDeclaredAnnotation(TableColumn.class);
				
				String columnName;
				
				if(column==null)
					columnName=fieldName.toLowerCase();
				else
					columnName= column.value();
				
				
				

				// now let us find if we have a correcponding value present in result set

				Class<?> parameterType = method.getParameters()[0].getType();

				Object value = null;
				if (parameterType.equals(String.class))
					value = rs.getString(columnName);
				else if (parameterType.equals(Double.class))
					value = rs.getDouble(columnName);

				method.invoke(object, value);
			} catch (Exception ex) {
				// throw new MapperException("Unable to Map "+cls.getName()+"."+fieldName);
				// ex.printStackTrace();
				int x=0;

			}

		}

		return object;

	}

	public static <E> ObjectResultSetMapper<E> forType(Class<E> cls) {

		return new ObjectResultSetMapper<E>(cls);
	}

}
