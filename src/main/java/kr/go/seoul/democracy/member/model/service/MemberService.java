package kr.go.seoul.democracy.member.model.service;


import java.util.HashMap;
import java.util.Map;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.vo.MemberProfile;


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
	// 아이디 찾기 로직
	Member searchId(Member member);
	// 비밀번호 찾기 로직에서 이메일로 인증코드 보내주기
	Member searchPwd(Member member);
	//Mypage에서 프로필 사진
	MemberProfile selcetMemberProfile(Member member);
	//Mypage에서 프로필 사진 변경
	int updateMemberProfile(MemberProfile memberProfile);
	//Mypage에서 프로필 사진 등록
	int insertMemberProfile(MemberProfile memberProfile);
	//비밀번호 찾기시 이메일 인중 후  비밀번호 재설정
	int resetPassword(Member member);
	//Mypage에서 이메일 인증 후 이메일 주소 변경
	int memberUpdateEmail(Map<String, String> Map);
	//MyPage에서 비밀번호 변경
	int myPageUpdatePassword(Map<String, String> Map);
	//MyPage에서 삭제로직
	int updateMemberWithdraw(HashMap<String, Object> map);
	//MyPage에서 닉네임 변경로직
	int myPageUpdateNick(Map<String, String> map);
}
