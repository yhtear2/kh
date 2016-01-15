package aop;

import aop.Song;
import aop.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import wiring.exception.PerformanceException;

@Component("kenny")
public class Singer implements Performer {
	@Value("고병완")
	private String name;
	@Autowired(required = false)
	@Qualifier("hello")
	private Song song;
	@Autowired(required = false)
	@Qualifier("drum")
	private Instrument instrument;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + "이 노래를 부릅니다.");
		song.singing();
//		instrument.play();
	}
}
