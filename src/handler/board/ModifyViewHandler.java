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
import dto.LogonDataBean;
import dao.BoardDao;
import dao.Dao;
import handler.Commandhandler;

@Controller
public class ModifyViewHandler implements Commandhandler {
	@Resource(name="boarddao")
	private BoardDao dao;
	
	@Resource(name="dao")
	private Dao dao1;

	@RequestMapping("/modifyView")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");

		int num = Integer.parseInt( request.getParameter("num") );
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
		

		BoardDataBean dto = dao.getArticle(num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("pageNum", pageNum);
		map.put("passwd", passwd);
		map.put("dto", dto);
		
		String id = (String)request.getSession().getAttribute("memId");
		LogonDataBean dto1 = dao1.getMember( id );
		
		map.put("dto1", dto1);
		map.put("id", id);
		
		map.put("page", "/board/modifyView");
		return new ModelAndView("/main/main", map);
	}

}
