package kr.go.seoul.democracy.admin.model.dao;

import java.util.HashMap;

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

	public int updatePassword(HashMap<String, Object> map) {
		
		return sqlSession.update("admin.updatePassword", map);
	}

	public int updateWithdraw(String adminId, String adminPwd) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("adminId", adminId);
		map.put("adminPwd", adminPwd);
		
		return sqlSession.update("admin.updateWithdraw", map);
	}

	public int insertAdminMember(Admin a) {
		
		return sqlSession.insert("admin.insertAdminMember", a);
	}

}
