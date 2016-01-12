package wiring.bean;

public class Juggler implements Performer {
	private int beanBags;
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Juggler : " + beanBags + "개의 공을 저글링합니다.");
	}
}
