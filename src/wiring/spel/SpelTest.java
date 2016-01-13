package wiring.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("wiring/spel/ApplicationContext.xml");
		
		Props props = (Props)ctx.getBean("props");
		
		System.out.println("data : " + props.getProp());
	}

}
