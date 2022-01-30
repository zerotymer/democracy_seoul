package kr.go.seoul.democracy.test.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("testDAO")
public class TestDAO {
    /// FIELDs
    private SqlSessionTemplate sqlSession;

    /// CONSTRUCTGORs
    @Autowired
    public TestDAO(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    /// METHODs
    public String selectSysdate() {
        return sqlSession.selectOne("test.date");
    }

}
