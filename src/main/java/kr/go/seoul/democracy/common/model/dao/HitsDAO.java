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
    /**
     * 조회수를 적용하는 메서드
     * @param tableName 테이블명
     * @param boardNo 보드번호
     * @return 성공여부. 1: 정상
     * @author 신현진
     */
    public int addCountHitsTable(String tableName, int boardNo) {
        HitsTableData table = new HitsTableData(tableName, boardNo);
        int exist = session.selectOne("hits.isExist", table);
        switch (exist) {
            case 0: exist = session.insert("hits.insertBoard", table); break;
            case 1: exist = session.update("hits.updateBoard", table); break;
        }
        return exist;
    }
}
