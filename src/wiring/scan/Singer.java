package wiring.scan;

import wiring.scan.Song;
import wiring.scan.Instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import wiring.exception.PerformanceException;

public class Singer implements Performer {
	private String name;
	private Song song;
	private Instrument instrument;
	
	public Singer(String name, Song song, Instrument instrument){
		this.name = name;
		this.song = song;
		this.instrument = instrument;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println(name + "이 노래를 부릅니다.");
		song.singing();
		instrument.play();
	}
}
