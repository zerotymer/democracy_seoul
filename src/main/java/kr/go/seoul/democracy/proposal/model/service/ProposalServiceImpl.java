package kr.go.seoul.democracy.proposal.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.proposal.model.dao.ProposalDAO;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;

@Service("proposalServiceImpl")
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	@Qualifier("proposalDAO")
	private ProposalDAO pDAO;

	@Override
	public Proposal proposalView(int proposalNo) throws Exception {
			return pDAO.proposalView(proposalNo);
	}
	
	@Override
	public List<Proposal> selectAllList(int curPage, int recordCountPage) throws Exception {
		// TODO Auto-generated method stub
		return pDAO.selectList(curPage,recordCountPage);
	}


	
	
}
