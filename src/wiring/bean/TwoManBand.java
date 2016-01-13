package wiring.bean;

import java.util.Map;

import wiring.exception.PerformanceException;

public class TwoManBand implements Performer {
	private Map<String, String> songs;
	private Map<String, Instrument> instruments;
	
	public Map<String, String> getSongs() {
		return songs;
	}

	public void setSongs(Map<String, String> songs) {
		this.songs = songs;
	}

	public Map<String, Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	@Override
	public void perform() throws PerformanceException {
		for(String song : songs.keySet()){
			System.out.println(song + " : " + songs.get(song));
		}
		
		for(String instrument : instruments.keySet()){
			System.out.print(instrument + " : ");
			instruments.get(instrument).play();
		}
	}
}
