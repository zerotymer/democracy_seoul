package kr.go.seoul.democracy.proposal.model.service;

import java.util.ArrayList;
import java.util.List;

import kr.go.seoul.democracy.proposal.model.vo.Proposal;

public interface ProposalService {

	 List<Proposal> selectAllList(int start, int end, String searchOption, String keyword) throws Exception;
	 
	 Proposal proposalView(int proposalNo) throws Exception;
	 
	 //게시글 레코드 갯수 
	int countArticle(String searchOption, String keyword); 


}
