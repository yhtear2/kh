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
public class Comp_InputCheck implements Commandhandler {

	@Resource(name="dao")
	private CompDao dao;

	@RequestMapping("/compInputCheck")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "/FJ_COMP/compInputCheck");
		
		return new ModelAndView("/main/main", map);
	}
}
