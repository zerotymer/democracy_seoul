package kr.go.seoul.democracy.adminNotice.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.adminNotice.model.vo.AdminNotice;
import kr.go.seoul.democracy.common.model.vo.Member;

@Repository
public class AdminNoticeDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.11
	 * Description : 모든 공지사항 정보 가져오는 페이지의 목록의 갯수 
	 */
	public ArrayList<AdminNotice> selectAllNoticeList(int recordCountPerPage, int currentPage) {
		int offset = ((currentPage-1) * recordCountPerPage);
		int limit = recordCountPerPage;
		RowBounds rb = new RowBounds(offset, limit);
		return new ArrayList<AdminNotice>(sqlSession.selectList("notice.selectAllNoticeList", null, rb));
	}
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.11
	 * Description : 모든 공지사항 정보 가져오는 페이지의 총 게시글 갯수
	 */
	public int noticeTotalCount() {
		
		int recordTotalCount = sqlSession.selectOne("notice.selectNoticeTotalCount");
		
		return recordTotalCount;
	}

	public int insertNoticeWrite(AdminNotice an) {
		
		//HashMap<String, Object> map = new HashMap<String, Object>();
		
		//map.put("noticeTitle", noticeTitle);
		//map.put("noticeContent", noticeContent);
		
		System.err.print(an);
		System.out.println(an);
		
		return sqlSession.insert("notice.insertNoticeWrite", an);
	}
	

	public AdminNotice selectOneNotice(int noticeNo) {
		return sqlSession.selectOne("notice.selectOneNotice", noticeNo);
	}

	public int noticeUpdate(AdminNotice an) {
		
		return sqlSession.update("notice.noticeUpdate",an);
	}

	public int noticeDelete(AdminNotice an) {
		
		return sqlSession.update("notice.noticeDelete", an);
	}


}
