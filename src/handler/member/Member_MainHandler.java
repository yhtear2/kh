package handler.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.Commandhandler;

@Controller
public class Member_MainHandler implements Commandhandler {

	@RequestMapping("/main")
	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("page", "/member/main");
		return new ModelAndView("/main/main", map);
	}

}
