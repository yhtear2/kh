package wiring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import wiring.exception.PerformanceException;

public class Instrumentalist implements Performer {
	@Value("#{'Bounce'}")
	private String song;
	@Autowired(required = false)
	@Qualifier("piano")
	private Instrument instrument;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Instrumentalist : " + song + "을 연주합니다.");
		instrument.play();
	}

}
