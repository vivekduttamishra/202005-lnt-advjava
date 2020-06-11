package in.conceptarchitect.practices.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogMessage {

	
	
	//@After("execution(* in.conceptarchitect.movies.SimpleMovieManager.*(..))")
	@After("@annotation(in.conceptarchitect.practices.aop.LogIt)")
	public void logAfterMethodCall(JoinPoint jp) {
		System.out.println(jp.getSignature()+" is called at "+new Date());
	}
	

}
