package handler.board;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDataBean;
import dao.BoardDao;
import handler.Commandhandler;

@Controller
public class ContentHandler implements Commandhandler {
	@Resource( name ="boarddao" )
	private BoardDao dao;

	@RequestMapping("/content")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {

	String pageNum = request.getParameter("pageNum");
	String number = request.getParameter("number");
	int num = Integer.parseInt( request.getParameter("num") );

	
	//1번
	BoardDataBean dto = dao.getArticle( num );
	
	// 아이피를 가져와서 자기 아이피는 조회수를 안늘려야 하니
	// 요기다가 쓸꺼야~ 그게 아니면 저기 1번에다가 쓰면됨
	// 단점! 여기다 쓰면.. 읽고 목록으로 가면 조회수가 늘어남
	
	if( ! request.getRemoteAddr().equals(dto.getIp())){
		dao.addCount( num );
	}
	
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("pageNum", pageNum);
	map.put("number", number);
	map.put("dto", dto);
	
	map.put("page", "/board/content");
	return new ModelAndView("/main/main", map);
	}

}
