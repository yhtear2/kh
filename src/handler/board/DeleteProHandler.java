package handler.board;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BoardDao;
import handler.Commandhandler;

@Controller
public class DeleteProHandler implements Commandhandler {
	@Resource( name="boarddao" )
	private BoardDao dao;

	@RequestMapping("/deletePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String passwd = request.getParameter("passwd");
	
	

		int resultCheck = dao.checkArticle(num, passwd);
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCheck", resultCheck);
		map.put("pageNum", pageNum);
		
		if( resultCheck != 0 ){
			int result = dao.deletArticle(num);
			map.put("result", result);
		}
		
		map.put("page", "/board/deletePro");
		return new ModelAndView("/main/main", map);
	}

}
