package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

@Component("memberDao")
public class JdbcMemberDao extends JdbcDaoSupport implements MemberDao{
//	@Autowired(required = false)
//	JdbcTemplate template;
	
	RowMapper<Member> mapper = new RowMapper<Member>(){
		@Override
		public Member mapRow(ResultSet rs, int rows) throws SQLException {
			Member member = new Member();
			member.setId(rs.getString("id"));
			member.setPasswd(rs.getString("passwd"));
			member.setName(rs.getString("name"));
			member.setTel(rs.getString("tel"));
			member.setLogtime(rs.getTimestamp("logtime"));
			return member;
		}
	};
	
	@Override
	public Member getMember(Member dto) {
		return getJdbcTemplate().queryForObject(
			"select * from dbtest where id=?"
			, new Object[] {dto.getId()}
			, mapper
			);
	}
	
	@Override
	public List<Member> getMembers() {
		return getJdbcTemplate().query(
			"select * from dbtest order by id asc"
			, mapper
			);
	}
	
	@Override
	public int getCount(){
		return getJdbcTemplate().queryForObject(
			"select count(*) from dbtest"
			, Integer.class
			);
	}
	
	@Override
	public int insertMember(Member dto){
		return getJdbcTemplate().update(
			"insert into dbtest values(?, ?, ?, ?, sysdate)"
			, dto.getId()
			, dto.getPasswd()
			, dto.getName()
			, dto.getTel()
			);
	}

	@Override
	public int updateMember(Member dto) {
		return getJdbcTemplate().update(
			"update dbtest set passwd=?, tel=? where id=?" 
			, dto.getPasswd()
			, dto.getTel()
			, dto.getId()
			);
	}
	
	@Override
	public int deleteMember(Member dto) {
		return getJdbcTemplate().update(
			"delete from dbtest where id=?"
			, dto.getId()
			);
	}

	


	
}// class
