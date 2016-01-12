package wiring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		Performer p = (Performer)ctx.getBean("duke");
		p.perform();
		
		p = (Performer)ctx.getBean("singer");
		p.perform();
	
	}
}
