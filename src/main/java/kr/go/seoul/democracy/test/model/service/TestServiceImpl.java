package kr.go.seoul.democracy.test.model.service;

import kr.go.seoul.democracy.test.model.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("testServiceImpl")
public class TestServiceImpl implements TestService {
    /// FIELDs
    private TestDAO tDAO;

    /// CONSTRUCTORs
    @Autowired
    public TestServiceImpl(@Qualifier("testDAO") TestDAO tDAO) {
        this.tDAO = tDAO;
    }

    /// METHODs

    public String selectSysdate() {
        return tDAO.selectSysdate();
    }
}
