package dao;

import org.apache.ibatis.session.SqlSession;

import dto.LogonDataBean;
import handler.SqlMapClient;

public class LogonDBBean implements Dao  {
	private SqlSession sqlSession = SqlMapClient.getSqlSession();
	
	// 회원가입
		public int insertMember( LogonDataBean dto ){
			return sqlSession.insert("Logon.insertMember", dto);
		}

		// 아이디 중복 체크용
		public int checkMember( String id ){
			int result=0;
			int count = sqlSession.selectOne("Logon.checkId", id);
			if( count == 0 ){
				// 아이디가 없다
				result = 0;
			}else {
				// 아이디가 있다
				result = 1;
			}
			return result;

		}
		
		//로그인 할때 id 비밀번호 체크
		public int checkMember(String id, String passwd){
			int result=0;
			// 아이디 체크를 있냐 없냐를 카운트로 물어볼꺼야
			int count = checkMember( id );
			
			// 아이디가 같은게 당연히 하나밖에 없으니깐
			if( count == 0 ){
				// 아이디가 없다
				result = -1;
			}else{
				// 아이디가 있다
				// 이 아이 입장에서는 id가 프라이머리키 인줄 모르니... 쿼리로 해야한다
				LogonDataBean dto = getMember( id );
					if( passwd.equals( dto.getPasswd() ) ) {
						// 비밀번호가 같다
						result = 1;
					}else{
						// 비밀번호가 다르다
						result = 0;
					}
			}
			return result;
		}
		
		// 삭제 메소드
		public int deleteMember( String id ){
			return sqlSession.delete("Logon.deleteMember", id);
		}
		
		
		// 수정용 아이디로 데이터 받아오기 
		public LogonDataBean getMember( String id ){
			return sqlSession.selectOne("Logon.getMember", id);
		}
		
		// 수정사항 db에 반영
		public int updateMember(LogonDataBean dto){
			return sqlSession.update("Logon.updateMember", dto);
		}
	
} // class


