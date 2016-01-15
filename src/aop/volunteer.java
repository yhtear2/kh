package aop;

import org.springframework.stereotype.Component;

import wiring.exception.PerformanceException;

@Component("michael")
public class volunteer implements Thinker {

	@Override
	public void thinking(String thoughts) throws PerformanceException {
		System.out.println("지원자의 생각 : " + thoughts);
	}

}