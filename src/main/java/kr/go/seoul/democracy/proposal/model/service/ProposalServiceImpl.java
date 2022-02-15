package kr.go.seoul.democracy.proposal.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.proposal.model.dao.ProposalDAO;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;
import kr.go.seoul.democracy.proposal.model.vo.ProposalComment;

@Service("proposalServiceImpl")
public class ProposalServiceImpl implements ProposalService {
	
	@Autowired
	@Qualifier("proposalDAO")
	private ProposalDAO pDAO;

	@Override
	public Proposal proposalView(int proposalNo) {
			return pDAO.proposalView(proposalNo);
	}
	
	@Override
	public ArrayList<Proposal> selectAllList(int currentPage, int recordCountPage) {
		// TODO Auto-generated method stub
		return pDAO.selectList(currentPage,recordCountPage);
	}

	@Override
	public void insert(Proposal proposal) {
		 pDAO.insert(proposal);
	}


	@Override 
	public void modify(Proposal proposal) { 
		pDAO.modify(proposal);
		
	}

	@Override
	public void delete(int proposalNo) {
		pDAO.delete(proposalNo);
		
	}


	@Override
	public void comWrite(ProposalComment pcomment) {
		pDAO.comWrite(pcomment);
		
	}

	@Override
	public ArrayList<HashMap<String, Object>> getComment(int proposalNo, int currentCommentPage, int pageSize) {
		return pDAO.getComment(proposalNo,currentCommentPage,pageSize);
	}

	@Override
	public int commentTotalCount(int proposalNo) {
		return pDAO.commentTotalCount(proposalNo);
	}

	@Override
	public int listTotalCount() {
		// TODO Auto-generated method stub
		return pDAO.listTotalCount();
	}


	


	
	
}
