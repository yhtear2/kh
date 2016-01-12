package wiring.bean;

public class Singer implements Performer{
	private String name;
	private String song;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Singer : " + name + "이 " + song + "을 부릅니다.");
	}
}
