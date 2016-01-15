package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wiring.exception.PerformanceException;

public class AopTest {
	public static void main(String[] args) throws PerformanceException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/ApplicationContext.xml");
		/*
		Performer john = (Performer)ctx.getBean("john");
		john.perform();
		*/
		
		Thinker michael = (Thinker)ctx.getBean("michael");
		michael.thinking("집 가고싶다..");
/*
		Performer kenny = (Performer)ctx.getBean("kenny");
		kenny.perform();
		/*
		Thinker michael = (Thinker)ctx.getBean("michael");
		michael.thinking("집 가고싶다..");
		*/
		/*
		Thinker michael = (Thinker)ctx.getBean("michael");
		michael.thinking2("집 가고싶다..", "정말 가고싶다");
		*/
	}
}
