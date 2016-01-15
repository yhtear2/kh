package wiring.scan;

import wiring.exception.PerformanceException;

public class Drum implements Instrument{

	@Override
	public void play() throws PerformanceException {
		System.out.println("Drum : " + "드럼");
	}

}
