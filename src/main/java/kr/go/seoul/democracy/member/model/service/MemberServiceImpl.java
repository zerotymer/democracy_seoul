package kr.go.seoul.democracy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO mDAO; 
	
	
	//common-context.xml에 이메일 설정 추가
	
	@Override
	public Member selectLoginMember(Member member) {
		
		System.out.println("[MemberService] - selectLoginMember 메소드 호출");
		
		return mDAO.selectLoginMember(member);
	}
	
	

	@Override
	public int insertMember(Member member) {
	
		
		return mDAO.insertMember(member);
		
	}



	@Override
	public int selectIdCheck(String userId) {

		
		return mDAO.selectIdCheck(userId);
		
	}



	@Override
	public int selectNickCheck(String nick) {
		
		return mDAO.selectNickCheck(nick);
	}



	@Override
	public int selectEmailCheck(String email) {
		
		return mDAO.selectEmailCheck(email);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
