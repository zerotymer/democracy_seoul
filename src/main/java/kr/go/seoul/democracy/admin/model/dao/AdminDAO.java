package kr.go.seoul.democracy.admin.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.admin.model.vo.Admin;

@Repository
public class AdminDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public Admin selectLoginAdmin(Admin admin) {
		
		return sqlSession.selectOne("admin.selectLoginAdmin", admin);
	}

}
