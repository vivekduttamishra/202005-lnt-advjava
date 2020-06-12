package in.conceptarchitect.practices;

public class ValidationException extends RuntimeException {

	ValidationMessage validationMessage;

	public ValidationException(String message, ValidationMessage validationMessage) {
		super(message);
		this.validationMessage = validationMessage;
	}
	
	
}
