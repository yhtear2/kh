package wiring.bean;

public class Ticket {
	private int cnt = 1;
	public Ticket(){
		
	}
	public Ticket(int cnt){
		this.cnt = cnt;
	}
	public void reservation(){
		System.out.println("티켓번호 : " + cnt++);
	}
}
