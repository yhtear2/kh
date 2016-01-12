package wiring.bean;

import wiring.exception.PerformanceException;

public class Picnic implements Poem{
	private String str
		= "나 하늘로 돌아가리라.\n"
		+ "새벽빛 와 닿으면 스러지는\n"
		+ "이슬 더불어 손에 손을 잡고,\n"
		+ "나 하늘로 돌아가리라.";
	
	@Override
	public void recite() throws PerformanceException {
		System.out.println("천상병 - 귀천\n" + str);
	}
	
}
