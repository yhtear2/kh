package wiring.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBean {
	@Bean
	public Role student(){
		return new Student("고병완");
	}
	
	@Bean
	public Role company(){
		return new Company("고병완");
	}
	
	@Bean
	public Role teacher(){
		return new Teacher("고병완");
	}
	
	@Bean
	public Performer actor(){
		return new Actor("고병완", "25", teacher());
	}
	
	@Bean
	public Performer singer(){
		return new Singer("고병완", hello(), piano());
	}
	
	@Bean
	public Song hello(){
		return new Hello();
	}
	
	@Bean
	public Song bounce(){
		return new Bounce();
	}
	
	@Bean
	public Instrument guitar(){
		return new Guitar();
	}
	
	@Bean
	public Instrument drum(){
		return new Drum();
	}
	
	@Bean
	public Instrument piano(){
		return new Piano();
	}
	
}





























