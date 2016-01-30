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
public class Member_DeleteProHandler implements Commandhandler {
	@Resource( name="dao" )
	private Dao dao;

	@RequestMapping("/member_deletePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 변수 선언
		String id = (String) request.getSession().getAttribute("memId");
		String passwd = request.getParameter("passwd"); 
		
		// 처리
		int resultCheck = dao.checkMember(id, passwd);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if( resultCheck == 1){
			int result = dao.deleteMember(id);
			map.put("result", result);
			//request.setAttribute("result", result);
		}
		
		// 보내기
		map.put("resultCheck", resultCheck);
		//request.setAttribute("resultCheck", resultCheck);
		
		map.put("page", "/member/deletePro");
		return new ModelAndView("/main/main", map);
	}

}
