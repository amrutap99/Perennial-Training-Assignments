package aspect_before_after_around;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//this is  aspect class that contains before,after,around advice.
@Aspect
public class TrackOperation {

	@Before("execution(* Operation.*(..))")
	public void myadvice(JoinPoint jp) {// it is advice (before advice)
		System.out.println("DEBUG: This is called by Before advice");
		System.out.println("DEBUG: Before advice entering method :" + jp.getSignature().getName());

	}
	
	@After("execution(* Operation.*(..))")
	public void myadviceAfter(JoinPoint jp) {// it is advice (after advice)
		System.out.println("DEBUG: This is called by After advice");
		System.out.println("DEBUG: After advice exiting method :" + jp.getSignature().getName());

	}

	@Around("execution(* Operation.*(..))")
	public void myadviceAround(ProceedingJoinPoint jp){// it is advice (around advice)
		System.out.println("DEBUG : Around Advice entering method "+jp.getSignature().getName());
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DEBUG : Around Advice exiting method "+jp.getSignature().getName());

	}

}
