package handler.member;

import java.sql.Timestamp;
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
public class Member_InputProHandler implements Commandhandler {

	@Resource( name="dao" )
	private Dao dao;
	
	@RequestMapping("/inputPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		request.setCharacterEncoding("utf-8");
		LogonDataBean dto = new LogonDataBean();
		
		// id
		dto.setId(request.getParameter("id"));
		
		// passwd
		dto.setPasswd(request.getParameter("passwd"));
		
		// name
		dto.setName(request.getParameter("name"));
		
		// jumin
		dto.setJumin1(request.getParameter("jumin1"));
		dto.setJumin2(request.getParameter("jumin2"));

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
		
		if(email2.equals("0")){
			// 직접입력
			email = email1;
		} else {
			// 선택입력
			email = email1 + "@" + email2;
		}
		dto.setEmail( email );

		// reg_date
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));

		int result = dao.insertMember( dto );
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("page", "/member/inputPro");
		return new ModelAndView("/main/main", map);
	}

}
