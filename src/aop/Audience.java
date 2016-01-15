package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Audience {
	@Pointcut("execution(* aop.Performer.perform(..))")
	public void performance(){
		
	}
	
	@Before("performance()")
	public void takeSeat(){
		System.out.println("자리에 앉는다.");
	}
	
	@Before("performance()")
	public void turnOffPhone(){
		System.out.println("핸드폰을 끈다.");
	}
	
	@AfterReturning("performance()")
	public void applud(){
		System.out.println("짝! 짝! 짝! 짝!");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("우~! 돈 내놔라!!!");
	}
	
	// Around
	public void watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("공연시간 : " + (end - start));
	}
	
	
	
	
}
