package wiring.bean;

import java.util.Collection;

import wiring.exception.PerformanceException;

public class OneManBand implements Performer {
	private Collection<String> songs;
	private Collection<Instrument> instruments;
	

	public Collection<String> getSongs() {
		return songs;
	}

	public void setSongs(Collection<String> songs) {
		this.songs = songs;
	}

	public Collection<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for(String song : songs){
			System.out.println("OneManBand : " + song + "을 연주합니다.");
		}
		for(Instrument instrument : instruments){
			instrument.play();
		}
	}
	
	
}
