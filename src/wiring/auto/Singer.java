package wiring.auto;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import wiring.exception.PerformanceException;

public class Singer implements Performer{
	@Value("조용필")
	private String name;
	@Autowired(required = false)
	private Collection<Song> songs;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Singer : " + name + "이 노래를 부릅니다.");
		for(Song song : songs){
			song.singing();
		}
	}
}
