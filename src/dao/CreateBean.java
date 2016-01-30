package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
public class CreateBean {
	
	// dao
	@Bean
	public LogonDBBean dao() {
		return new LogonDBBean();
	}
	
	// dao
	@Bean
	public BoardDBBean boarddao() {
		return new BoardDBBean();
	}
	
	// viewResolver
	@Bean
	public UrlBasedViewResolver viewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass( JstlView.class );
		//viewResolver.setPrefix("/member/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}
