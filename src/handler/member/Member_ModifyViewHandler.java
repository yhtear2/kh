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
import dto.LogonDataBean;

@Controller
public class Member_ModifyViewHandler implements Commandhandler {
	@Resource( name="dao" )
	private Dao dao;
	
	@RequestMapping("/member_modifyView")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 변수 받기
		String id = (String)request.getSession().getAttribute("memId");
		String passwd = request.getParameter("passwd");
		
		// 처리
		int result = dao.checkMember(id, passwd);
		
		if (result == 1){
			LogonDataBean dto = dao.getMember( id );
			map.put("dto", dto);
			//request.setAttribute("dto", dto);
		}
		
		request.setAttribute("resultCheck", result);
		map.put("resultCheck", result);
		
		map.put("result", result);
		map.put("page", "/member/modifyView");
		return new ModelAndView("/main/main", map);

	}

}
