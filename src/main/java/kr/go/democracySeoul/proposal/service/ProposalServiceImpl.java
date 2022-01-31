package kr.go.democracySeoul.proposal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.democracySeoul.proposal.dao.ProposalDAO;

@Service
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	private ProposalDAO pDAO;
	
	
}
