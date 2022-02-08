package kr.go.seoul.democracy.proposal.model.service;

import java.util.ArrayList;
import java.util.List;

import kr.go.seoul.democracy.proposal.model.vo.Proposal;

public interface ProposalService {

	 List<Proposal> selectAllList(int curPage,int recordCountPage) throws Exception;
	 
	 Proposal proposalView(int proposalNo) throws Exception;

	String getPageNavi(int curPage, int recordCountPage, int naviCountPerPage);
	 
	

}
