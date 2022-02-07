package kr.go.seoul.democracy.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.common.model.vo.Member;

@Repository
public class MemberDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	


	public Member selectLoginMember(Member member) {
		
		//("mapper의 namespace.select태그의 ID",member객체 넘겨주기)
		Member m = sqlSession.selectOne("member.selectLoginMember",member);
		System.out.println(m);
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
	
	
	
	
	
	
	
	
	
	
	
	
}
