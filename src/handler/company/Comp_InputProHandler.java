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
import dto.comp.CompDataBean;
import handler.Commandhandler;

@Controller
public class Comp_InputProHandler implements Commandhandler {

	@Resource(name="dao")
	private CompDao dao;

	@RequestMapping("/compInputPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		
		CompDataBean dto = new CompDataBean();
		dao.insertComp(dto);
		
		
		String page = "/FJ_COMP/compInputPro";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", page);
		
		return new ModelAndView("/main/main", map);
	}
}
