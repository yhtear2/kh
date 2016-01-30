package handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultHandler implements Commandhandler {

	@RequestMapping("*")
	@Override
	public ModelAndView process(HttpServletRequest req, HttpServletResponse resp) throws Throwable {
		String result = "요청을 처리할 수 없습니다.";

		return new ModelAndView("default", "result", result);
	}

}
