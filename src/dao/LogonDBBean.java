package dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dto.LogonDataBean;

public class LogonDBBean extends JdbcDaoSupport implements Dao  {

	// 회원가입
	public int insertMember( LogonDataBean dto ){
		return getJdbcTemplate().update(
				"insert into member values( ?, ?, ?, ?, ?, ?, ?, ? )", 
				dto.getId(),
				dto.getPasswd(),
				dto.getName(),
				dto.getJumin1(),
				dto.getJumin2(),
				dto.getTel(),
				dto.getEmail(),
				dto.getReg_date()
		);
	}

	// 아이디 중복 체크용
	public int checkMember( String id ){
		int result=0;
		int count = getJdbcTemplate().queryForObject(
				"select count(*) from member where id=?",
				new Object[] {id},
				Integer.class
		);
		if( count == 0 ){
			// 아이디가 없다
			result = 0;
		}else {
			// 아이디가 있다
			result = 1;
		}
		return result;

	}

	// 로우맵퍼 구현부분
	RowMapper <LogonDataBean> mapper = new RowMapper<LogonDataBean>() {
		public LogonDataBean mapRow( ResultSet rs, int rows ) 
			throws SQLException {
			LogonDataBean dto = new LogonDataBean();
			dto.setId( rs.getString( "id" ) );
			dto.setPasswd( rs.getString( "passwd" ) );
			dto.setName( rs.getString( "name" ) );
			dto.setJumin1( rs.getString( "jumin1" ) );
			dto.setJumin2( rs.getString( "jumin2" ) );
			dto.setTel( rs.getString( "tel" ) );
			dto.setEmail( rs.getString( "email" ) );
			dto.setReg_date( rs.getTimestamp( "reg_date" ) );		
			return dto;			
		};
	};	

	
	// 로그인 할때 id 비밀번호 체크
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
			List<LogonDataBean> list = getJdbcTemplate().query(
					"select * from member where id=?",
					new Object[] {id},
					mapper
				);				
			// 어짜피 하나 밖에 없지만 반복문은 돌려야 해요~
			for( int i=0; i<list.size(); i++ ) {
				if( passwd.equals( list.get(i).getPasswd() ) ) {
					// 비밀번호가 같다
					result = 1;
				}else{
					// 비밀번호가 다르다
					result = 0;
				}
			}
		}
		return result;
	}
	
	// 삭제 메소드
	public int deleteMember( String id ){
		return getJdbcTemplate().update(
				"delete from member where id=?",
				id
		);
	}
	
	// 수정용 아이디로 데이터 받아오기 
	public LogonDataBean getMember( String id ){
		LogonDataBean dto = null;
		List<LogonDataBean> list = getJdbcTemplate().query(
				"select * from member where id=?", 
				new Object[] {id},
				mapper
		);
		
		for(int i=0; i<list.size(); i++){
			dto = new LogonDataBean();
			dto.setId(list.get(i).getId());
			dto.setPasswd( list.get(i).getPasswd() );
			dto.setName( list.get(i).getName() );
			dto.setJumin1( list.get(i).getJumin1() );
			dto.setJumin2( list.get(i).getJumin2() );
			dto.setTel( list.get(i).getTel() );
			dto.setEmail( list.get(i).getEmail() );
			dto.setReg_date( list.get(i).getReg_date() );
		}
		return dto;
	}
	
	// 수정사항 db에 반영
	public int updateMember(LogonDataBean dto){
		return getJdbcTemplate().update(
				"update member set passwd=?, name=?, tel=?, email=? where id = ?",
				dto.getPasswd(),
				dto.getName(),
				dto.getTel(),
				dto.getEmail(),
				dto.getId()
				);
	}
	
} // class


