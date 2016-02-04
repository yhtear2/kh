package handler.board;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.Commandhandler;

@Controller
public class DeleteFromHandler implements Commandhandler{

	@RequestMapping("/deletefrom")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", num);
		map.put("pageNum", pageNum);
		
		map.put("page", "/board/deletefrom");
		return new ModelAndView("/main/main", map);
	}

}
