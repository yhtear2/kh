package aop;

import wiring.exception.PerformanceException;

public class Guitar implements Instrument {

	@Override
	public void play() throws PerformanceException {
		System.out.println("Guitar : " + "기타");
	}
}
