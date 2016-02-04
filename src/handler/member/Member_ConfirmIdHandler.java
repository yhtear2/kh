package handler.member;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import handler.Commandhandler;
import dao.Dao;

@Controller
public class Member_ConfirmIdHandler implements Commandhandler {
	@Resource( name="dao" )
	private Dao dao;
	
	@RequestMapping("/confirmId")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 변수 선언
	 	String id = request.getParameter("id");
	 	
	 	// 데이터 처리
	 	int result = dao.checkMember( id );
	 	
	 	// 출력
	 	Map<String, Object> map = new HashMap<String, Object>();
	 	map.put("result", result);
	 	map.put("id", id);
	 	
	 	map.put("page", "/member/confirmId");
		return new ModelAndView("/handler/main", map);
	}

}
