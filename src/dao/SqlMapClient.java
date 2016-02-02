package dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapClient {
	public static SqlSession sqlSession;
	static {
		try {
			Reader reader = Resources.getResourceAsReader( "dao/sqlMapConfig.xml" );
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build( reader );
			sqlSession = factory.openSession( true );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		return sqlSession;
	}
}









