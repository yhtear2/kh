package dao;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBean {
	// DataSource
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("kham");
		ds.setPassword("kham");
		ds.setInitialSize(10);
		ds.setMaxActive(10);
		ds.setMaxWait(3000);
		return ds;
	}
	
	// JdbcMemberDao
	@Bean
	public MemberDao memberDao(){
		JdbcMemberDao memberDao = new JdbcMemberDao();
		memberDao.setDataSource(dataSource());
		return memberDao;
	}
}
