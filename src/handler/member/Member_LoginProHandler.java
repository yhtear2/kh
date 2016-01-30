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
public class Member_LoginProHandler implements Commandhandler{
	// 오토와이어드 해서 넣어도 되고
	// 그걸 대신해주는게 리소스라고 있어요
	// 이걸 써주면 되요
	@Resource( name="dao" )
	private Dao dao;
	
	@RequestMapping("/loginPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		int result = dao.checkMember( id, passwd );
		
		//request.setAttribute("result", result);
		//request.setAttribute("id", id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("id", id);

		map.put("page", "/member/loginPro");
		return new ModelAndView("/main/main", map);
	}

}
