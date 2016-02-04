package handler.company;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import custom.CustomUtil;
import dao.comp.CompDao;
import dto.comp.CompDataBean;
import handler.Commandhandler;

@Controller
public class Comp_InputProHandler implements Commandhandler {

	@Resource(name="dao")
	private CompDao dao;

	@RequestMapping("/compInputPro")
	@Override
	public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		CompDataBean dto = new CompDataBean();
		dto.setEmail(request.getSession().getAttribute("email").toString());
		dto.setCeo(request.getParameter("ceo"));
		dto.setComp_type(request.getParameter("comp_type"));
		dto.setTel(request.getParameter("tel"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddress(request.getParameter("address"));
		dto.setInfo(request.getParameter("info"));
		dto.setCapital(request.getParameter("capital"));
		if(!CustomUtil.isNull(request.getParameter("year_sale"))){
			dto.setYear_sale(Integer.parseInt(request.getParameter("year_sale")));
		}
		if(!CustomUtil.isNull(request.getParameter("emp_count"))){
			dto.setEmp_count(Integer.parseInt(request.getParameter("emp_count")));
		}
		if(!CustomUtil.isNull(request.getParameter("like_count"))){
			dto.setLike_count(Integer.parseInt(request.getParameter("like_count")));
		}
		if(!CustomUtil.isNull(request.getParameter("comp_reg_date"))){
			dto.setComp_reg_date(Timestamp.valueOf(request.getParameter("comp_reg_date").toString()));
		}
		
		int result = dao.updateComp(dto);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "/FJ_COMP/compInputPro");
		map.put("result", result);
		
		return new ModelAndView("/main/main", map);
	}
}
