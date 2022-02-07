package kr.go.seoul.democracy.suggest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import kr.go.seoul.democracy.suggest.dao.SugDAO;

@Service("sugServiceImpl")
public class SugServiceImpl implements SugService {
    /// FIELDs
    private SugDAO sDAO;

    /// CONSTRUCTORs
    @Autowired
    public SugServiceImpl(@Qualifier("sugDAO") SugDAO sDAO) {
        this.sDAO = sDAO;
    }

    
    
    /// METHODs
    public String selectSysdate() {
    	System.out.println("SugService - selectSysdate()");
        return sDAO.selectSysdate();
    }
}

