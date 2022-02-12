package kr.go.seoul.democracy.suggest.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.suggest.dao.SugDAO;
import kr.go.seoul.democracy.suggest.vo.Sug;

@Service("sugServiceImpl")
public class SugServiceImpl implements SugService {
	
	@Autowired
	@Qualifier("sugDAO")
    /// FIELDs
    private SugDAO sDAO;

	@Override
	public Sug sugView(int sugNo) {
			return sDAO.proposalView(sugNo);
	}
	
	@Override
	public List<Sug> selectAllList(int curPage, int recordCountPage) {
		// TODO Auto-generated method stub
		return sDAO.selectList(curPage,recordCountPage);
	}

	@Override
	public void insert(Sug sug) {
		sDAO.insert(sug);
	}




	


	
	
}

