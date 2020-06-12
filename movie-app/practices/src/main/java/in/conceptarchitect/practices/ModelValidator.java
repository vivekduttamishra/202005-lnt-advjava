package in.conceptarchitect.practices;

import java.util.Collection;
import java.util.HashMap;

public interface ModelValidator<E> {

	ValidationMessage validate(E item);
}
