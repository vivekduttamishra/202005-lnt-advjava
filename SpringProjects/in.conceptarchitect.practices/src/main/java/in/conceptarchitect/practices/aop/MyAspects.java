package in.conceptarchitect.practices.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspects {

	
	
	//@AfterReturning(value="execution(* in.conceptarchitect.movies.SimpleMovieManager.*(*))",returning="result")
	@AfterReturning(value="@annotation(in.conceptarchitect.practices.aop.LogIt)", returning="result")

	public void logAfterMethodCall(JoinPoint jp,Object result) {
		
		
		
		
		
		String signature = getSignature(jp);
		
		
		System.out.printf("[%s] %s  => %s\n",new Date(), signature,result);
		System.out.println();
	}


	private String getSignature(JoinPoint jp) {
		String object= jp.getTarget().getClass().getSimpleName();
		String method=jp.getSignature().getName();
		String args="(";
		
		for(Object arg : jp.getArgs()) {
			if(!args.contentEquals("("))
				args+=" , ";
			args+=arg;
		}
		
		if(args.endsWith(","))
			args=args.substring(0,args.length()-1);
		
		args+=")";
		
		String signature= String.format("%s.%s%s", object,method,args);
		return signature;
	}
	

	@Around("@annotation(in.conceptarchitect.practices.aop.LogPerformance)")
	public Object logPerformance(ProceedingJoinPoint jp) {
		
		long start=System.currentTimeMillis();
		String signature = getSignature(jp);
		Throwable e=null;
		Object result=null;
		try {
			result= jp.proceed(); //call the actual function here
			
		
		
		}catch(Throwable ex) {
			e=ex;
		}
		finally {
			long end =System.currentTimeMillis();
		
			String error="";
			if(e!=null) {
				System.out.println("threw "+e.getClass().getSimpleName()+":"+e.getMessage());
			}
			
			System.out.printf("Total time taken by %s is %d ms \t%s", signature, end-start, error);
		}	
		
		return result;
		
	}
	
	@Around("@annotation(in.conceptarchitect.practices.aop.Ignore)")
	public Object dontExecute(ProceedingJoinPoint jp) {

		return null; 
		
	}
	
	
}
