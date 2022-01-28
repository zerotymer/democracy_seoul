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
		return sqlSession.selectOne("member.selectLoginMember",member);

		
	}
	
	

}
