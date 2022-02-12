package kr.go.seoul.democracy.suggest.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import kr.go.seoul.democracy.suggest.vo.Sug;

@Repository("sugDAO")
public class SugDAO {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	//
    private SqlSessionTemplate sqlSession;

	public Sug proposalView(int SugNo) {
		return sqlSession.selectOne("proposal.proposalView",SugNo);
	}

    //
    public String selectSysdate() {
        return sqlSession.selectOne("sug.date");
    }

    //@@미완성
	public List<Sug> selectList(int recordCountPage, int curPage) {
		int offset = (curPage-1)*recordCountPage;
		RowBounds rows = new RowBounds(offset,recordCountPage);
		return sqlSession.selectList("sug.selectAllList",null,rows);
	}

	public void insert(Sug sug) {
		System.err.println(sug);
		sqlSession.insert("sug.insert",sug);
		
	}

	



}

