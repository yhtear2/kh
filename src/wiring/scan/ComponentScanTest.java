package wiring.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wiring.exception.PerformanceException;

public class ComponentScanTest {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("wiring/scan/ApplicationContext.xml");
		
		Performer p = (Performer)ctx.getBean("john");
		p.perform();
		

	}

}
