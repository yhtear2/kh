package wiring.scan;

import org.springframework.beans.factory.annotation.Value;

import wiring.exception.PerformanceException;

public class Company implements Role {
	@Value("정우성")
	private String name;
	
	@Override
	public void play() throws PerformanceException {
		System.out.println(name + "이라는 회사원을 연기합니다.");
	}
}
