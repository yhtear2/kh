package wiring.scan;

import wiring.exception.PerformanceException;

// 자바 기반 Bean 생성
public class Actor implements Performer {
	private String name;
	private String age;
	private Role role;
	
	public Actor(String name, String age, Role role) {
		this.name = name;
		this.age = age;
		this.role = role;
	}

	@Override
	public void perform() throws PerformanceException {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		role.play();
	}
}

/*
// Annotation
public class Actor implements Performer {
	@Value("#{new String('고병완')}")
	private String name;
	@Value("25")
	private String age;
	@Autowired(required = false)
	@Qualifier("teacher")
	private Role role;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		role.play();
	}
}
*/