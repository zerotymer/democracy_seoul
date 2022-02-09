package kr.go.seoul.democracy.proposal.model.service;

import java.util.ArrayList;
import java.util.List;

import kr.go.seoul.democracy.proposal.model.vo.Proposal;

public interface ProposalService {
	//게시글 목록 
	 List<Proposal> selectAllList(int curPage,int recordCountPage) throws Exception;
	 
	 //게시글보기
	 Proposal proposalView(int proposalNo) throws Exception;

	 //게시글 등록
	 void insert(Proposal proposal)throws Exception;
	 
	 //게시글수정
	public void modify(Proposal proposal);



	 
	

}
