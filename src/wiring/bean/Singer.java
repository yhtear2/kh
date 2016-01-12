package wiring.bean;

import wiring.exception.PerformanceException;

public class Singer implements Performer{
	private String name;
	private Song song;
	
	public Singer(){}
	public Singer(String name, Song song){
		this.name = name;
		this.song = song;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Singer : " + name + "이 노래를 부릅니다.");
		song.singing();
	}
}
