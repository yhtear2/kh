package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringDaoTest {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dao/ApplicationContext.xml");
		
		// dto
		Member kim = new Member();
		kim.setId("kim");
		kim.setPasswd("111");
		kim.setName("김길동");
		kim.setTel("1111-2222");
		
		// dao
		MemberDao memberDao = (MemberDao)ctx.getBean("memberDao");
		int result = 0;
		
		// select count
		int count = memberDao.getCount();
		System.out.println("회원 수 : " + count);
		
		System.out.println();
		
		// select
		for(Member member : memberDao.getMembers()){
			System.out.println(
					member.getId() + "\t"
					+ member.getPasswd() + "\t"
					+ member.getName() + "\t"
					+ member.getTel() + "\t\t"
					+ member.getLogtime()
					);
		}
		
		System.out.println();
		
		// delete
		result = memberDao.deleteMember(kim);
		if(result == 0){
			System.out.println("탈퇴 실패");
		}else{
			System.out.println("탈퇴 성공");
		}
		
		System.out.println();
		
		// insert
		result = memberDao.insertMember(kim);
		if(result == 0){
			System.out.println("가일 실패");
		}else{
			System.out.println("가입 성공");
		}
		
		System.out.println();
		
		// update
		Member newMember = new Member();
		newMember.setId(kim.getId());
		newMember.setPasswd("999");
		newMember.setTel("9999-9999");
		result = memberDao.updateMember(newMember);
		if(result == 0){
			System.out.println("수정 실패");
		}else{
			System.out.println("수정 성공");
		}
		
		System.out.println();
		
		Member member = memberDao.getMember(kim);
		System.out.println("아이디 : " 		+ member.getId());
		System.out.println("비밀번호 : " 	+ member.getPasswd());
		System.out.println("이름 : " 		+ member.getName());
		System.out.println("전화번호 : " 	+ member.getTel());
		System.out.println("가입일자 : " 	+ member.getLogtime());
		
		
	}
	
}


















