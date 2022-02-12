package kr.go.seoul.democracy.suggest.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import kr.go.seoul.democracy.suggest.dao.SugDAO;
import kr.go.seoul.democracy.suggest.vo.Sug;

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



	@Override
	public ArrayList<Sug> selectAllNoticeList(int currentPage, int recordCountPerPage) {
		// TODO Auto-generated method stub
		return sDAO.selectAllNoticeList(recordCountPerPage, currentPage);
	}



	@Override
	public int noticeTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}

