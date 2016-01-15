package dao;

import java.util.List;

public interface MemberDao {
	public Member getMember(Member dto);
	public List<Member> getMembers();
	public int getCount();
	public int insertMember(Member dto);
	public int updateMember(Member dto);
	public int deleteMember(Member dto);
}
