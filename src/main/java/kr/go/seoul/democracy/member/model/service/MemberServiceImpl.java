package kr.go.seoul.democracy.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.dao.MemberDAO;
import kr.go.seoul.democracy.member.model.vo.MemberProfile;

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



	@Override
	public Member searchId(Member member) {
		System.out.println("[MemberService] - searchId 메소드 호출");
		
		return mDAO.searchId(member);	
		}



	@Override
	public Member searchPwd(Member member) {
		System.out.println("[MemberService] - searchPwd 메소드 호출");

		return mDAO.searchPwd(member);	
	}



	@Override
	public int insertMemberProfile(MemberProfile memberProfile) {
		// TODO Auto-generated method stub
		return mDAO.insertMemberProfile(memberProfile);
	}



	@Override
	public MemberProfile selcetMemberProfile(Member member) {
		// TODO Auto-generated method stub
		return mDAO.selectMemberProfile(member);
	}



	@Override
	public int updateMemberProfile(MemberProfile memberProfile) {
		// TODO Auto-generated method stub
		return mDAO.updateMemberProfile(memberProfile);
	}



	@Override
	public int resetPassword(Member member) {
		
		System.out.println("[MemberService] - resetPassword 메소드 호출");

		
		return mDAO.resetPassword(member);
	}



	@Override
	public int memberUpdateEmail(Member member) {

		System.out.println("[MemberService] - resetPassword 메소드 호출");

		return mDAO.memberUpdateEmail(member);
	}



	@Override
	public int myPageUpdatePassword(Map<String, String> passwordMap) {
		
		
		return mDAO.myPageUpdatePassword(passwordMap);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
