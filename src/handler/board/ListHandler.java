package handler.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDataBean;
import handler.Commandhandler;
import dao.BoardDao;

@Controller
public class ListHandler implements Commandhandler {
	@Resource(name="boarddao")
	private BoardDao dao;

	@RequestMapping("/list")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 고정변수 
		// 보통 전역변수로 만들지만 여기서 쓰고 말꺼니깐 그냥 여기다가
		int pageSize=10;
		int pageBlock = 3;
	
		// 변수 선언
		int count = 0;	// 조회수
		String pageNum = null;	// 페이지 번호
		int currentPage = 0;	
		int start = 0;
		int end = 0;
		int number = 0;
		
		//-- 페이지 만들 편수 선언
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		
		count = dao.getCount();
		
		// 연산
		pageNum = request.getParameter("pageNum");
		if( pageNum == null){
			pageNum = "1";
		} 
		
		// 페이지 번호 계산
		//-- 짜투리가 생기면 페이지 하나 더 만들고 없으면 만들지 말아라
		pageCount = count / pageSize + ( count%pageSize >0 ? 1 : 0 );
		currentPage = Integer.parseInt(pageNum);
		// 마지막 페이지 지웠을때 생기는 문제 예외처리
		if( pageCount < currentPage){
			currentPage = pageCount;
			pageNum = String.valueOf( pageCount );
		}
		
		start = ( currentPage - 1) * pageSize + 1;
		end = start + pageSize -1;
		
		// 번호 계산
		number = count-( currentPage -1 ) * pageSize ;

		//--
		startPage = (currentPage / pageBlock) * pageBlock +1;
					// (  11		/ 10 ) * 10+1 	11	
		if( currentPage % pageBlock == 0) startPage -= pageBlock;
		endPage = startPage + pageBlock -1;
					// 11+ 10 - 1					20
		if( endPage > pageCount ) endPage = pageCount;
		
		// 보낼 맵 생성
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 보내기
		map.put("count", count);
		map.put("pageNum", pageNum);
		
		if(count != 0){
			// 글이 있는 경우
			ArrayList <BoardDataBean> list = dao.getArticles( start, end );
			map.put("list", list);		
		}
		
		map.put("number", number);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("pageBlock", pageBlock);
		map.put("currentPage", currentPage);
		map.put("pageCount", pageCount);
		
		map.put("page", "/board/list");
		return new ModelAndView("/main/main", map);
	}

}
