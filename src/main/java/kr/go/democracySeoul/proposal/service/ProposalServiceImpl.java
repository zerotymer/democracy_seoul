package kr.go.democracySeoul.proposal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.democracySeoul.proposal.dao.ProposalDAO;
import kr.go.democracySeoul.proposal.vo.Proposal;

@Service
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	private ProposalDAO pDAO;

	@Override
	public List<Proposal> selectAllList(){
		return pDAO.selectAllList();
	}
	
	
}
