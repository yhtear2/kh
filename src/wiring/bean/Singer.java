package wiring.bean;

import java.util.Collection;

import wiring.exception.PerformanceException;

public class Singer implements Performer{
	private String name;
	private Collection<Song> songs;
	
	public Singer(){}
	public Singer(String name, Song song){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Song> getSongs() {
		return songs;
	}
	public void setSongs(Collection<Song> songs) {
		this.songs = songs;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Singer : " + name + "이 노래를 부릅니다.");
		for(Song song : songs){
			song.singing();
		}
	}
}
