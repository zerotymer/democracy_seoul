package kr.go.seoul.democracy.proposal.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.go.seoul.democracy.proposal.model.vo.Proposal;
import kr.go.seoul.democracy.proposal.model.vo.ProposalComment;

public interface ProposalService {
	//게시글 목록 
	 List<Proposal> selectAllList(int curPage,int recordCountPage) throws Exception;
	 
	 //게시글보기
	 Proposal proposalView(int proposalNo) throws Exception;

	 //게시글 등록
	 void insert(Proposal proposal)throws Exception;
	 
	 //게시글수정
	 void modify(Proposal proposal)throws Exception;
	 
	 //게시글삭제 
	void delete(int proposalNo);

	 
	public void comWrite(ProposalComment pcomment);

	ArrayList<HashMap<String, Object>> getComment(int proposalNo, int currentCommentPage, int pageSize);

	int commentTotalCount(int proposalNo);




	 
	

}
