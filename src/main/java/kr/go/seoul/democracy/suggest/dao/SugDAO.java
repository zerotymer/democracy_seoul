package kr.go.seoul.democracy.suggest.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.suggest.vo.Sug;
import kr.go.seoul.democracy.suggest.vo.SugComment;

@Repository("sugDAO")
public class SugDAO {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	// @@미완성
	public List<Sug> selectList(int recordCountPage, int curPage) {
		int offset = (curPage - 1) * recordCountPage;
		RowBounds rows = new RowBounds(offset, recordCountPage);
		return sqlSession.selectList("suggest.selectAllList", null, rows);
	}

	public Sug sugView(int SuggestNo) {
		return sqlSession.selectOne("suggest.sugView", SuggestNo);
	}

	//
	public String selectSysdate() {
		return sqlSession.selectOne("suggest.date");
	}

	public void insert(Sug sug) {
		System.err.println(sug);
		sqlSession.insert("suggest.insert", sug);

	}

	// 04. 글수정하기
	public void modify(Sug sug) {
		System.err.println(sug);
		sqlSession.update("suggest.modify", sug);
	}

	/* 05.글삭제하기 */
	public void delete(int suggestNo) {
		sqlSession.update("suggest.delete", suggestNo);
	}

	public List<SugComment> comlist(int userId) {
		return sqlSession.selectList("suggestComment", userId);
	}

	public void comWrite(Sug SuggestComment) {
		sqlSession.insert("suggestComment", SuggestComment);
	}

}
