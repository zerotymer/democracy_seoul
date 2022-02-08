package kr.go.seoul.democracy.common.model.dao;

import kr.go.seoul.democracy.common.model.vo.HitsTableData;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("hitsDAO")
public class HitsDAO {
    /// FIELDs
    private SqlSessionTemplate session;

    /// CONSTRUCTORs
    @Autowired
    public HitsDAO(@Qualifier("sqlSessionTemplate") SqlSessionTemplate session) {
        this.session = session;
    }

    /// METHODs
    public int addCountHitsTable(String tableName, int boardNo) {
        HitsTableData table = new HitsTableData(tableName, boardNo);
        int exist = session.selectOne("hits.isExist", table);
        switch (exist) {
            case 0: exist = session.insert("hits.insertBoard", table);
            case 1: exist = session.insert("hits.insertBoard", table);
            default:
                return exist;
        }
    }
}
