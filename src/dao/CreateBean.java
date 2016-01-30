package dao;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;



@Configuration
public class CreateBean {
	// dataSource
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName( "oracle.jdbc.driver.OracleDriver" );
		ds.setUrl( "jdbc:oracle:thin:@localhost:1521:xe" );
		ds.setUsername( "kham" );
		ds.setPassword( "kham" );
		ds.setInitialSize( 10 );
		ds.setMaxActive( 10 );
		ds.setMaxWait( 3000 );		
		return ds;
	}
	
	// dao
	@Bean
	public Dao dao() {
		LogonDBBean dao = new LogonDBBean();
		dao.setDataSource( dataSource() );
		return dao;
	}
	
	// dao
	@Bean
	public BoardDBBean boarddao() {
		BoardDBBean dao = new BoardDBBean();
		dao.setDataSource( dataSource() );
		return dao;
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
