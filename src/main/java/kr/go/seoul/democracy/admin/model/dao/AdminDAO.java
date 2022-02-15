package kr.go.seoul.democracy.admin.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.admin.model.vo.Admin;
import kr.go.seoul.democracy.common.model.vo.Member;

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
		
		return new ArrayList<Admin>(sqlSession.selectList("admin.selectAllMemberList", null, new RowBounds(0, 10)));
	}

	public int updateMemberEndYNChange(String userId, char endYN) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("userId", userId);
		map.put("endYN", endYN);
		return sqlSession.update("admin.updateMemberEndYNChange", map);
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.10
	 * Description : 모든 회원 정보 가져오는 페이지의 목록의 갯수 
	 */
	public ArrayList<Member> selectAllPostList(int recordCountPerPage, int currentPage) {
		
		int offset = ((currentPage-1) * recordCountPerPage);
		int limit = recordCountPerPage;
		RowBounds rb = new RowBounds(offset, limit);
		return new ArrayList<Member>(sqlSession.selectList("admin.selectAllPostList", null, rb));
	
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.10
	 * Description : 모든 회원 정보 가져오는 페이지의 총 게시글 갯수
	 */
	public int totalCount() {
		
		int recordTotalCount = sqlSession.selectOne("admin.selectMemberTotalCount");
		
		return recordTotalCount;
	}
	


}
