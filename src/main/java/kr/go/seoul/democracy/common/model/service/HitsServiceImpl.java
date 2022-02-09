package kr.go.seoul.democracy.common.model.service;

import kr.go.seoul.democracy.common.model.dao.HitsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("hitsServiceImpl")
public class HitsServiceImpl implements HitsService {
    /// FIELDs
    private HitsDAO hDAO;

    /// CONSTRUCOTRs
    @Autowired
    public HitsServiceImpl(@Qualifier("hitsDAO") HitsDAO hDAO) {
        this.hDAO = hDAO;
    }

    /// METHODs

    @Override
    public boolean addCountHitsTable(String tableName, int boardNo) {
        return hDAO.addCountHitsTable(tableName, boardNo) == 1;
    }

}
