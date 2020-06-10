package in.conceptarchitect.practices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ValidationMessage {

	HashMap<String,Collection<String>> errors= new HashMap<>();
	
	public ValidationMessage addError(String key,String error) {
		if(! errors.containsKey(key))
			errors.put(key, new ArrayList<String>());
		
		errors.get(key).add(error);
		
		return this;
	}
	
	public ValidationMessage addErrorIf(boolean condition, String key, String error) {
		if(condition)
			return addError(key,error);
		else
			return this;
			
	}
	
	public ValidationMessage addErrorOnNullOrEmpty(Object object, String key, String error) {
		if(object==null || object.toString().isEmpty())
			return addError(key,error);
		else
			return this;
	}
	
	
	public boolean hasError() {return errors.size()==0; }
	
	public boolean hasError(String key) {return !errors.containsKey(key) || errors.get(key).size()==0;}
	
	public Set<String> getErrorFields(String key){
		return errors.keySet();
	}
	
	public Collection<String> getErrorsForField(String key){
		return errors.get(key);
	}
	
	public Collection<String> getAllErrors(){
		List<String> result=new ArrayList<String>();
		
		for(String key: errors.keySet() ) {
			for(String message: errors.get(key))
				result.add(key+":"+message);
		}
			
		return result;
	}
	
	public String getAllErrorsString() {
		String str="";
		
		for(String error : getAllErrors() )
			str+=(error+"\n");
		
		return str;
	}
	
	public String getErrorMessage(String key) {
		String str="";
		if(errors.containsKey(key))
			for(String error : errors.get(key))
				str+=error+"\n";
		
		return str;
	}
	
	public boolean isSuccess() {return errors.size()==0; }
	
	public static final ValidationMessage success=new ValidationMessage();
	
	public void raiseException() {
		if(hasError())
			throw new ValidationException(getAllErrorsString(), this);
	}
	
	
}
