package wiring.bean;

import wiring.exception.PerformanceException;

public class PoeticJuggler extends Juggler {
	private Poem poem;
	
	public PoeticJuggler(){}
	public PoeticJuggler(int beanBags, Poem poem){
		super(beanBags);
		this.poem = poem;
	}
	
	@Override
	public void perform() throws PerformanceException{
		System.out.println("PoeticJuggler : " + beanBags + "개의 공을 저글링합니다.");
		poem.recite();
	}
}
