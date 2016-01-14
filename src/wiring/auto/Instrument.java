package wiring.auto;

import wiring.exception.PerformanceException;

public interface Instrument {
	public void play() throws PerformanceException;
}
