package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import dao.comp.CompDBBean;
import dao.comp.CompDao;

@Configuration
public class CreateBean {
	
	@Bean
	public CompDao compDao() {
		return new CompDBBean();
	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass( JstlView.class );
		viewResolver.setSuffix( ".jsp" );		
		return viewResolver;
	}
}












