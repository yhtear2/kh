package aop;

import wiring.exception.PerformanceException;

public interface Thinker {
	public void thinking(String thoughts) throws PerformanceException;
}
