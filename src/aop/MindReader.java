package aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import wiring.exception.PerformanceException;

@Aspect
@Component
public class MindReader implements Magician {
	@Pointcut("execution(* aop.Thinker.thinking(String)) && args(thoughts)")
	public void think(String thoughts){
		
	}
	
	@Override
	@Before("think(thoughts)")
	public void interceptor(String thoughts) throws PerformanceException {
		System.out.println("독심술사의 생각 : " + thoughts);
	}

	@Override
	@AfterReturning("think(thoughts)")
	public void openCard(String thoughts) throws PerformanceException {
		System.out.println("카드 오픈 : " + thoughts);
	}
}
