package handler.board;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDataBean;
import dao.BoardDao;
import handler.Commandhandler;

@Controller
public class ModifyProHandler implements Commandhandler {
	@Resource(name="boarddao")
	private BoardDao dao;

	@RequestMapping("/modifyPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
	
		String pageNum = request.getParameter("pageNum");


		// 빈에다가 입력
		BoardDataBean dto = new BoardDataBean();
		
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setNum(Integer.parseInt(request.getParameter("num")));

		int result = dao.updateArticle( dto );
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageNum", pageNum);
		map.put("result", result);
	
		map.put("page", "/board/modifyPro");
		return new ModelAndView("/main/main", map);
	}

}
