package wiring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wiring.exception.PerformanceException;

public class BeanWiringTest {
	public static void main(String args[]) throws PerformanceException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("wiring/bean/ApplicationContext.xml");
		
		// 강한 결합
		// Juggler j = new Juggler();
		// j.perform();
		
		// 느슨한 결합
		// Performer p = new Juggler();
		// p.perform();
		
		// DI( Dependency Injection )
		// Simple Bean Wiring
		// Performer p = (Performer)ctx.getBean("john");
		// p.perform();

		/*
		// factory-method
		Stage s1 = new Stage();
		s1.disp();
		
		Stage s2 = Stage.getInstance();
		s2.disp();
		
		Stage s3 = (Stage)ctx.getBean("s3");
		s3.disp();
		
		Stage s4 = (Stage)ctx.getBean("s4");
		*/
		
		/*
		// singleton / prototype
		Ticket t1 = (Ticket)ctx.getBean("ticket");
		t1.reservation();
		 
		 
		System.out.println("t1 : " + t1);
		Ticket t2 = (Ticket)ctx.getBean("ticket");
		t2.reservation();
		System.out.println("t2 : " + t2);
		*/
		
		// init-method / destory-method

		// Property를 통한 주입
		Performer p = (Performer)ctx.getBean("instrumentalist");
		p.perform();
		
		
		// Singer
		// Performer s = (Performer)ctx.getBean("singer");
		// s.perform();
		
		
	
	}
}
