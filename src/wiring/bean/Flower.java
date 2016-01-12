package wiring.bean;

import wiring.exception.PerformanceException;

public class Flower implements Poem{
	private String str 
		= "내가 그의 이름을 불러주기 전에는\n"
		+ "그는 다만\n"
		+ "하나의 몸짓에 지나지 않았다.";
	
	@Override
	public void recite() throws PerformanceException {
		System.out.println("김춘수 - 꽃\n" + str);
	}

}
