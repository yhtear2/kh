package wiring.scan;

import wiring.exception.PerformanceException;

public class Teacher implements Role {
	private String name;
	
	public Teacher(String name) {
		this.name = name;
	}

	@Override
	public void play() throws PerformanceException {
		System.out.println(name + "이라는 선생님을 연기합니다.");
	}
}

/*
public class Teacher implements Role {
	@Value("조인성")
	private String name;
	
	@Override
	public void play() throws PerformanceException {
		System.out.println(name + "이라는 선생님을 연기합니다.");
	}
}
*/