package kr.go.seoul.democracy.test.model.service;

import kr.go.seoul.democracy.test.model.dao.TestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
    @Override
    public String selectSysdate() {
    	System.out.println("TestService - selectSysdate()");
        return tDAO.selectSysdate();
    }

    @Override
    public String hashmapTest(HashMap<String, Object> map) {
        System.err.println("TestService - hashmapTest()");
        System.err.println(map);
        return null;
    }
}
