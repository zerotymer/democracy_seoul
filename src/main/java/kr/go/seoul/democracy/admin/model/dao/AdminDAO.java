package kr.go.seoul.democracy.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public int adminUpdate(Admin a) {
		
		return sqlSession.update("admin.adminUpdate", a);
	}

	public int updatePassword(HashMap<String, Object> map) {
		
		return sqlSession.update("admin.updatePassword", map);
	}

	public int updateWithdraw(Admin admin) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("adminId", admin.getAdminId());
		map.put("adminPwd", admin.getAdminPwd());
		
		return sqlSession.update("admin.updateWithdraw", map);
	}

	public int insertAdminMember(Admin a) {
		
		return sqlSession.insert("admin.insertAdminMember", a);
	}

	public int selectAdminIdCheck(String adminId) {
		
		return sqlSession.selectOne("admin.selectAdminIdCheck", adminId) != null? 1:0;
	}

	public ArrayList<Admin> selectAllMemberList() {
		
		return new ArrayList<Admin>(sqlSession.selectList("admin.selectAllMemberList"));
	}

	public int updateMemberEndYNChange(String userId, char endYN) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("userId", userId);
		map.put("endYN", endYN);
		
		return sqlSession.update("member.updateMemberEndYNChange", map);
	}

	public List<Object> selectAllPostList(int currentPage, int recordCountPerPage) {
		
		ArrayList<Admin> list = new ArrayList();
		
		int start =  currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		return sqlSession.selectList("admin.selectAllPostList", list);
	}


}
