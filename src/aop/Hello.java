package aop;

import wiring.exception.PerformanceException;

public class Hello implements Song {

	@Override
	public void singing() throws PerformanceException {
		System.out.println("헬로!");
	}
}
