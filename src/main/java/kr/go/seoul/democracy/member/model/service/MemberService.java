package kr.go.seoul.democracy.member.model.service;


import kr.go.seoul.democracy.common.model.vo.Member;


public interface MemberService {
	
	//로그인
	Member selectLoginMember(Member member);
	//회원가입
	int insertMember(Member member);
	//아이디 중복 체크
	int selectIdCheck(String userId);
    //닉네임 중복 체크
	int selectNickCheck(String nick);
	//이메일 중복 체크 
	int selectEmailCheck(String email);


}
