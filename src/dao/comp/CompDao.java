package dao.comp;

import dto.comp.CompDataBean;

public interface CompDao {
	public CompDataBean getComp(String id);
	public int insertComp(CompDataBean dto);
	public int updateComp(CompDataBean dto);
	public int deleteCdomp(String id);
}
