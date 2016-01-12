package wiring.bean;

public class Stage {
	private int number;
	
	public Stage(){
		
	}
	
	public Stage(int number){
		this.number = number;
	}
	
	public static Stage getInstance(){
		return new Stage(5);
	}
	
	public void disp(){
		System.out.println(number + "번 무대가 준비중입니다.");
	}
}
