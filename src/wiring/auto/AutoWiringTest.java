package wiring.auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wiring.exception.PerformanceException;

public class AutoWiringTest {
	public static void main(String args[]) throws PerformanceException{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("wiring/auto/ApplicationContext.xml");
		
		Performer p = (Performer)ctx.getBean("john");
		p.perform();

		Performer s = (Performer)ctx.getBean("singer");
		s.perform();
	}
}
