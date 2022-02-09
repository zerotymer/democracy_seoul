package kr.go.seoul.democracy.member.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.vo.MemberProfile;

@Repository
public class MemberDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	


	public Member selectLoginMember(Member member) {
		
		//("mapper의 namespace.select태그의 ID",member객체 넘겨주기)		
		//return sqlSession.selectOne("member.selectLoginMember", member);
		System.out.println(member);
		Member m = sqlSession.selectOne("member.selectLoginMember",member);
		System.out.println("DB에서 갖고오는 데이터 :"+m);
		return m;

		
	}



	public int insertMember(Member member) {
		
		return sqlSession.insert("member.insertMember",member);
		
}


	public int selectIdCheck(String userId) {
		
		return sqlSession.selectOne("member.selectIdCheck",userId)!=null?1:0;
	}



	public int selectNickCheck(String nick) {
		return sqlSession.selectOne("member.selectNickCheck",nick)!=null?1:0;
	}



	public int selectEmailCheck(String email) {
		return sqlSession.selectOne("member.selectEmailCheck",email)!=null?1:0;

	}



	public Member searchId(Member member) {
		
		Member m = sqlSession.selectOne("member.searchId",member);
		System.out.println(m);
		return m;
	}



	public Member searchPwd(Member member) {
		
		Member m = sqlSession.selectOne("member.searchPwd",member);
		System.out.println(m);
		return m;
	}
	
	public MemberProfile selectMemberProfile(Member member) {
		MemberProfile mf = sqlSession.selectOne("selectMemberProfile",member);
		return mf;
	}
	
	public int updateMemberProfile(MemberProfile memberProfile) {
		return sqlSession.update("updateMemberProfile",memberProfile);
	}
	
	public int insertMemberProfile(MemberProfile memberProfile) {
		return sqlSession.insert("insertMemberProfile",memberProfile);
	}
	
	
	
	public int resetPassword(Member member) {
		
		return sqlSession.update("member.resetPassword",member);
	}



	public int memberUpdateEmail(Map<String, String> Map) {

		return sqlSession.update("member.memberUpdateEmail",Map);
	}



	public int myPageUpdatePassword(Map<String, String> Map) {
		System.out.println(Map);
		return sqlSession.update("member.myPageUpdatePassword",Map);

	}





	public int updateMemberWithdraw(HashMap<String, Object> map) {
		System.out.println("삭제로직 DAO"+map);
		return sqlSession.update("member.updateMemberWithdraw",map);
	}



	public int myPageUpdateNick(Map<String, String> map) {
		System.out.println("닉네임 변경 로직 DAO 상황: "+map);
		return sqlSession.update("member.myPageUpdateNick",map);

	}
	
	
	
	
	
}
