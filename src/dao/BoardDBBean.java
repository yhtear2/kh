package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.BoardDataBean;
import handler.SqlMapClient;

 
public class BoardDBBean implements BoardDao {
	private SqlSession sqlSession = SqlMapClient.getSqlSession();
	
	private Map<String, Object> map = null;
	// 게시글 카운트
	public int getCount(){
		return sqlSession.selectOne("Board.getCount");
	}
	
	// 리스트
	public ArrayList<BoardDataBean> getArticles( int start, int end){
		map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List<BoardDataBean> list = null;
		list = sqlSession.selectList("Board.getArticles", map);
		return (ArrayList<BoardDataBean>) list;

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
				int maxNum = sqlSession.selectOne("Board.maxNum");			
				ref = maxNum + 1;	// 그룹화 아이디 = 글번호 최대값 +1
			} else {
				// 글이 없는 경우
				ref = 1;
			}
		} else {
			// 답변글
			sqlSession.update("Board.insertUpdate", dto);
			re_step ++;
			re_level ++;
		}
		dto.setRef(ref);
		dto.setRe_step(re_step);
		dto.setRe_level(re_level);
		return sqlSession.update("Board.insertArticle", dto);
	}


	// 글 보 기
	public BoardDataBean getArticle(int num){
		return sqlSession.selectOne("Board.getArticle", num);
	}
	
	
	// 조회수 늘어나는거
	public void addCount( int num ){
		sqlSession.update("Board.addCount", num);
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
		return sqlSession.update("Board.updateArticle", dto);
	}

	
	// 게시글 삭제
	public int deletArticle( int num ){
		int result = 0;
		BoardDataBean dto = getArticle(num);
	
		int test = sqlSession.selectOne("Board.deletCount", dto);
				
		if( test != 0 ){
			//답글이 있는 경우
			result = -1;
		} else {
			// 답글이 없는 경우
			// 글 레벨 다시 정하고
			sqlSession.update("Board.deletUpdate", dto);
			// 실제로 삭제
			result = sqlSession.delete("Board.deletArticle", num);

		}
		return result;
	}

} // class
