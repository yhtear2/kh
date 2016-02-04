package handler.company;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.comp.CompDao;
import handler.Commandhandler;

@Controller
public class Comp_InputFormHandler implements Commandhandler {

	@Resource(name="compDao")
	private CompDao compDao;

	@RequestMapping("/compInputForm")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id 		= request.getSession().getAttribute("email").toString();
		String passwd 	= request.getParameter("passwd");
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		param.put("passwd", passwd);
//		int result = dao.checkComp(param);
		int result = 1;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "/FJ_COMP/compInputForm");
		map.put("result", result);
		
		return new ModelAndView("/main/main", map);
	}
}
