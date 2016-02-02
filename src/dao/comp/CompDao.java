package dao.comp;

import dto.comp.CompDataBean;

public interface CompDao {
	public int getComp(String id);
	public int getComp(String id, String passwd);
	public int insertComp(CompDataBean dto);
	public int updateComp(CompDataBean dto);
	public int deleteComp(CompDataBean dto);
}
