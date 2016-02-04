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
public class Member_ModifyFormHandler implements Commandhandler {

	@RequestMapping("/member_modifyForm")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("page", "/member/modifyForm");
		return new ModelAndView("/main/main", map);

	}

}
