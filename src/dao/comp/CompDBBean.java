package dao.comp;

import org.apache.ibatis.session.SqlSession;

import dao.SqlMapClient;
import dto.comp.CompDataBean;

public class CompDBBean implements CompDao{
	private SqlSession sqlSession = SqlMapClient.getSqlSession();

	@Override
	public int insertComp(CompDataBean dto) {
		return sqlSession.insert("Comp.insertComp", dto);
	}

	@Override
	public int getComp(String id) {
		return 0;
	}

	@Override
	public int getComp(String id, String passwd) {
		return 0;
	}

	@Override
	public int updateComp(CompDataBean dto) {
		return 0;
	}

	@Override
	public int deleteComp(CompDataBean dto) {
		return 0;
	}

}
