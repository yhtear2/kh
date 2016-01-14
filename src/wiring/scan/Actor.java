package wiring.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import wiring.bean.Performer;
import wiring.exception.PerformanceException;

public class Actor implements Performer {
	@Value("고병완")
	private String name;
	@Value("25")
	private String age;
	@Autowired(required = false)
	@Qualifier("#{wiring.scan.Actor}")
	private Role role;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		role.play();
	}
}
