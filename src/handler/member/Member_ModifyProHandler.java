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
public class Member_ModifyProHandler implements Commandhandler {
	@Resource( name="dao" )
	private Dao dao;

	@RequestMapping("/member_modifyPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		LogonDataBean dto = new LogonDataBean();
	
		// id	
		dto.setId((String)request.getSession().getAttribute("memId"));
		
		// passwd
		dto.setPasswd(request.getParameter("passwd"));
		
		// name
		dto.setName(request.getParameter("name"));

		// tel
		String tel = null;
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		if( ! tel1.equals("") && ! tel2.equals("") && ! tel3.equals("")){
			tel = tel1+"-"+tel2+"-"+tel3;	
		}
		dto.setTel( tel );

		// email
		String email = null;
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		if(! email1.equals("") &&! email2.equals("")){
			email = email1+"@"+email2;
		}
		dto.setEmail( email );
	
		int result = dao.updateMember( dto );
	
		// 전송부
		//request.setAttribute("result", result);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("page", "/member/modifyPro");
		return new ModelAndView("/main/main", map);
	}

}
