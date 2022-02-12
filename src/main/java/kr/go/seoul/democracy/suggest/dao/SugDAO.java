package kr.go.seoul.democracy.suggest.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.suggest.vo.Sug;

@Repository("sugDAO")
public class SugDAO {
    /// FIELDs
    private SqlSessionTemplate sqlSession;

    /// CONSTRUCTGORs
    @Autowired
    public SugDAO(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /// METHODs
    public String selectSysdate() {
        return sqlSession.selectOne("sug.date");
    }

    //@@미완성
	public ArrayList<Sug> selectAllNoticeList(int recordCountPerPage, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public int noticeTotalCount() {
		// TODO Auto-generated method stub
		int recordTotalCount = sqlSession.selectOne("notice.selectNoticeTotalCount");
		
		return recordTotalCount;
	}

}

