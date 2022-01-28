package kr.go.seoul.democracy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO mDAO; 
	
	@Override
	public Member selectLoginMember(Member member) {
		
		System.out.println("[MemberService] - selectLoginMember 메소드 호출");
		
		Member m = mDAO.selectLoginMember(member);
		

		return m;
		
	}
	

}
