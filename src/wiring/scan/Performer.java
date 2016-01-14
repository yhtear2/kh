package wiring.scan;

import wiring.exception.PerformanceException;

public interface Performer {
	public void perform() throws PerformanceException;
}
