package wiring.bean;

import wiring.exception.PerformanceException;

public class Juggler implements Performer {
	int beanBags;
	
	public Juggler(){
		
	}
	
	public Juggler(int beanBags){
		this.beanBags = beanBags;
	}
	
	@Override
	public void perform() throws PerformanceException {
		System.out.println("Juggler : " + beanBags + "개의 공을 저글링합니다.");
	}
}
