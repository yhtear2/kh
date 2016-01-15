package wiring.scan;

import wiring.exception.PerformanceException;

public class Bounce implements Song {

	public void singing() throws PerformanceException {
		System.out.println("빠운스");
	}

}
