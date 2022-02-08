package kr.go.seoul.democracy.suggest.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
        return sqlSession.selectOne("test.date");
    }

}

