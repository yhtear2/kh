package handler;

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
			
			Reader reader = Resources.getResourceAsReader( "handler/sqlMapConfig.xml" );
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build( reader );
			// 여기서는 자동으로 커밋을 한다
			sqlSession = factory.openSession( true );	
			System.out.println( "DB 연결 성공" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		return sqlSession;
	}
}









