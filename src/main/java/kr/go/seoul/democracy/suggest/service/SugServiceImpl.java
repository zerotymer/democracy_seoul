package kr.go.seoul.democracy.suggest.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.suggest.dao.SugDAO;
import kr.go.seoul.democracy.suggest.vo.Sug;
import kr.go.seoul.democracy.suggest.vo.SugComment;

@Service("sugServiceImpl")
public class SugServiceImpl implements SugService {
	
	@Autowired
	@Qualifier("sugDAO")
    /// FIELDs
    private SugDAO sDAO;

	@Override
	public Sug sugView(int suggestNo) {
			return sDAO.sugView(suggestNo);
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


	@Override 
	public void modify(Sug sug) { 
		sDAO.modify(sug);
		
	}

	@Override
	public void delete(int suggestNo) {
		sDAO.delete(suggestNo);
		
	}

	@Override
	public List<SugComment> comlist(int userId) {
			return sDAO.comlist(userId);
	}

	@Override
	public void comWrite(Sug SugComment) {
		sDAO.comWrite(SugComment);
		
	}
	



	


	
	
}

