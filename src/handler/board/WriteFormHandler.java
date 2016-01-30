package handler.board;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.Dao;
import dto.LogonDataBean;
import handler.Commandhandler;

@Controller
public class WriteFormHandler implements Commandhandler {
	@Resource(name="dao")
	private Dao dao;

	@RequestMapping("/writeForm")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		// 제목글인 경우		<- list.jsp
		int num = 0;		// 제목글 / 답변글
		int ref = 1;		// 그룹화 아이디
		int re_step = 0;	// 글순서	그룹내에서 출력되는 순서
		int re_level = 0;	// 글레벨	제목글이냐 답글이냐를 구분 그리고 답변중에 재답변이 이있으니
							// 		몇번째 답글인지 알려준다
		
		// 답글인 경우		<- content.jsp
		// 넘어오는 값이 있음
		if( request.getParameter("num") != null ){
			num = Integer.parseInt( request.getParameter("num") );
			ref = Integer.parseInt( request.getParameter("ref") );
			re_step = Integer.parseInt( request.getParameter("re_step") );
			re_level = Integer.parseInt( request.getParameter("re_level") );
		}
		
		String pageNum = request.getParameter("pageNum");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("num", num);
		map.put("ref", ref);
		map.put("re_step", re_step);
		map.put("re_level", re_level);
		
		String id = (String)request.getSession().getAttribute("memId");
		LogonDataBean dto = dao.getMember( id );
		
		map.put("dto", dto);
		
		map.put("page", "/board/writeForm");
		return new ModelAndView("/main/main", map);
	}

}
