package wiring.bean;

import wiring.exception.PerformanceException;

public interface Performer {
	public void perform() throws PerformanceException;
}
