package wiring.auto;

import wiring.exception.PerformanceException;

public class Piano implements Instrument{

	@Override
	public void play() throws PerformanceException {
		System.out.println("Piano : " + "피아노");
	}

}
