package dao;

import dto.LogonDataBean;

public interface Dao {
		public int insertMember( LogonDataBean dto );
		public int checkMember( String id );
		public int checkMember(String id, String passwd);
		public int deleteMember( String id );
		public LogonDataBean getMember( String id );
		public int updateMember(LogonDataBean dto);
}
