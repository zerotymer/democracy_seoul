package kr.go.seoul.democracy.proposal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.proposal.dao.ProposalDAO;
import kr.go.seoul.democracy.proposal.vo.Proposal;

@Service("proposalServiceImpl")
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	@Qualifier("proposalDAO")
	private ProposalDAO pDAO;

	@Override
	public List<Proposal> selectAllList() throws Exception{
		return pDAO.selectAllList();
	}

	@Override
	public Proposal proposalView(int proposalNo) throws Exception {
			return pDAO.proposalView(proposalNo);
	}
	
	
}
