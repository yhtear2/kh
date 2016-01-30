package handler.board;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDataBean;
import dto.LogonDataBean;
import dao.BoardDao;
import dao.Dao;
import handler.Commandhandler;

@Controller
public class WriteProHandler implements Commandhandler {
	@Resource(name="boarddao")
	private BoardDao dao;
	
	@Resource(name="dao")
	private Dao dao1;

	@RequestMapping("/writePro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

	   request.setCharacterEncoding("utf-8");
	   String pageNum = request.getParameter("pageNum");
	   BoardDataBean dto = new BoardDataBean();
	   
	   String id = (String)request.getSession().getAttribute("memId");
	   LogonDataBean dto1 = dao1.getMember( id );
		// 입력 받은거
		dto.setWriter(dto1.getName());
		dto.setEmail(dto1.getEmail());
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd("111");
		
		// 데이터 넘긴거
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		// reg_date
		dto.setReg_date(new Timestamp( System.currentTimeMillis()));
	
		// ip
		dto.setIp( request.getRemoteAddr());

		// 처리 및 데이터 보내기 //
		int result = dao.insertArticle( dto );

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("pageNum", pageNum);
		
		map.put("page", "/board/writePro");
		return new ModelAndView("/main/main", map);
	}

}
