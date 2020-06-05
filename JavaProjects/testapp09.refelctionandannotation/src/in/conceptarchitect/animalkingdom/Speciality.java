package in.conceptarchitect.animalkingdom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Speciality {

	String name();  //*required* name property defined as method

	int times() default(1);  //if not given

}
