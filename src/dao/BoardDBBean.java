package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dto.BoardDataBean;

 
public class BoardDBBean extends JdbcDaoSupport implements BoardDao {
	
	// rowMaper
	RowMapper<BoardDataBean> mapper = new RowMapper<BoardDataBean>(){
		@Override
		public BoardDataBean mapRow(ResultSet rs, int rows) throws SQLException {
				BoardDataBean dto = new BoardDataBean();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setEmail( rs.getString("email"));
				dto.setSubject(rs.getString("subject"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getTimestamp("reg_date"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setRef(rs.getInt("ref"));
				dto.setRe_step(rs.getInt("re_step"));
				dto.setRe_level(rs.getInt("re_level"));
				dto.setContent(rs.getString("content"));
				dto.setIp(rs.getString("ip"));
				return dto;			
		
		};
	};
	
	// 게시글 카운트
	public int getCount(){
		return getJdbcTemplate().queryForObject(
				"select count( * ) from board",
				Integer.class);
	}
	
	// 리스트
	public ArrayList<BoardDataBean> getArticles( int start, int end){
		String sql = "select num,writer,email,subject,passwd,";
		sql+= "reg_date,ref,re_step,re_level,content,ip,readcount,r ";
		sql+= "from (select num,writer,email,subject,passwd,reg_date,ref,re_step";
		sql+= ",re_level,content,ip,readcount,rownum r from ";
		sql+= "(select num,writer,email,subject,passwd,reg_date,ref,re_step,re_level ";
		sql+= ",content,ip,readcount from board order by ref desc, re_step asc) ";
		sql+= "order by ref desc, re_step asc ) where r >= ? and r <= ?";
		
		return (ArrayList<BoardDataBean>) getJdbcTemplate().query(
				sql,
				new Object[]{ start, end },
				mapper);
	}
	

	// 글 입력
	public int insertArticle( BoardDataBean dto ){
			//			ref		re_step		re_level
			// 제목글		8		0			0
			//  ㄴ답글	8		2			1
			//   ㄴ재답글	8		2			2
			//	ㄴ답글	8		1			1
			// 답글일때 ref는 상관없으나 step, level은 하나씩 증가
			// 
			// 최신 답글이 위로 보이게 하게하기 위해서 re_step을 사용한다
			// 자기보다 큰 값의 글만 1 증가 자기자신은 나중에 1증가
			// 이렇게 하려면 업데이트로 DB에 넣어야 한다
	
		int num = dto.getNum();
		int ref = dto.getRef();
		int re_step = dto.getRe_step();
		int re_level = dto.getRe_level();
		
		if( num == 0 ) {
			// 제목글
			// ref 충돌이 안나면서 기본의 ref값 보다 커야한다.
			int count = getCount();
			if( count > 0){
				// 글이 있는 경우
				int maxNum = getJdbcTemplate().queryForObject(
						"select max( num ) from board", 
						Integer.class
					);
				
				ref = maxNum + 1;	// 그룹화 아이디 = 글번호 최대값 +1
			} else {
				// 글이 없는 경우
				ref = 1;
			}
		} else {
			// 답변글
			getJdbcTemplate().update(
					"update board set re_step=re_step+1 where ref=? and re_step>?",
					ref,
					re_step);
			re_step ++;
			re_level ++;
		}
		return getJdbcTemplate().update(
			"insert into board( num, writer, email, subject, passwd, " 
			+ "reg_date, ref, re_step, re_level, content, ip) "
			+ "values( board_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
			dto.getWriter(),
			dto.getEmail(),
			dto.getSubject(),
			dto.getPasswd(),
			dto.getReg_date(),
			ref,
			re_step,
			re_level,
			dto.getContent(),
			dto.getIp()
			);
	}


	// 글 보 기
	public BoardDataBean getArticle(int num){
		BoardDataBean dto = null;
		List<BoardDataBean> list = getJdbcTemplate().query(
				"select * from board where num=?",
				new Object[]{num},
				mapper);
		for(int i=0; i<list.size(); i++){
			dto = new BoardDataBean();
			dto.setNum(list.get(i).getNum());
			dto.setWriter(list.get(i).getWriter());
			dto.setEmail(list.get(i).getEmail());
			dto.setSubject(list.get(i).getSubject());
			dto.setPasswd(list.get(i).getPasswd());
			dto.setReg_date(list.get(i).getReg_date());
			dto.setReadcount(list.get(i).getReadcount());
			dto.setRef(list.get(i).getRef());
			dto.setRe_step(list.get(i).getRe_step());
			dto.setRe_level(list.get(i).getRe_level());
			dto.setContent(list.get(i).getContent());
			dto.setIp(list.get(i).getIp());
		}
		return dto;
	}
	
	// 조회수 늘어나는거
	public void addCount( int num ){
		getJdbcTemplate().update(
				"update board set readcount=readcount+1 where num=?",
				num
		);	
	}
	
	// 비밀번호 확인
	public int checkArticle( int num, String passwd ){
		int result = 0; 
		BoardDataBean dto = getArticle(num);
		
		if(dto.getPasswd().equals(passwd)){
			result = 1;	
		}else{
			result = 0;	
		}
		return result;
	}

	// 게시글 수정하기
	public int updateArticle( BoardDataBean dto){
		
		return getJdbcTemplate().update(
			"update board set email=?, subject=?, content=?, passwd=? where num=? ",
			dto.getEmail(),
			dto.getSubject(),
			dto.getContent(),
			dto.getPasswd(),
			dto.getNum()
		);
	}

	// 게시글 삭제
	public int deletArticle( int num ){
		int result = 0;
		BoardDataBean dto = getArticle(num);

		// -1  답글이 있어서 삭제 불가능
		// 0  삭제 실패
		// 1 삭제 성공
		
		// 답글이 있을때 게시글이 지워지지 않게 하기 위해서
		// ref		=		// 같아야 한다	
		// re_step	> + 1	// 자기 아래보다 하나만 클때
		// re_level >		// 자기보다 큰 숫자가 있을때
		
		// 삭제 처리를 하면 가지고 있는 값을 번화를 시켜줘야 한다
		// 즉! re_step를 줄여준다
		// 값을 먼저 꺼내온다
	
		int test = getJdbcTemplate().queryForObject(
			"select count(*) from board where ref=? and re_step=?+1 and re_level>?",
			new Object[]{dto.getRef(), dto.getRe_step(), dto.getRe_level()},
			Integer.class
		);
						
		if( test != 0 ){
			//답글이 있는 경우
			result = -1;
		} else {
			// 답글이 없는 경우
			// 글 레벨 다시 정하고
			getJdbcTemplate().update(
				"update board set re_step=re_step-1 where ref=? and re_step>?",
				dto.getRef(),
				dto.getRe_step()
			);
			// 실제로 삭제
			result = getJdbcTemplate().update(
				"delete from board where num=?",
				num
			);
		}
		return result;
	}

} // class
