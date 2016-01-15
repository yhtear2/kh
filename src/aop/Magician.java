package aop;

import wiring.exception.PerformanceException;

public interface Magician {
	public void interceptor(String thoughts) throws PerformanceException;
	public void openCard(String thoughts) throws PerformanceException;
}
