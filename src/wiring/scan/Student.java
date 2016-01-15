package wiring.scan;

import wiring.exception.PerformanceException;

public class Student implements Role {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}

	@Override
	public void play() throws PerformanceException {
		System.out.println(name + "이라는 학생을 연기합니다.");
	}
}

/*
public class Student implements Role {
	@Value("강동원")
	private String name;
	
	@Override
	public void play() throws PerformanceException {
		System.out.println(name + "이라는 학생을 연기합니다.");
	}
}
*/
