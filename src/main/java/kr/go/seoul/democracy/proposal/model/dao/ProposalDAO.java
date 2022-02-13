package kr.go.seoul.democracy.proposal.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.proposal.model.vo.Proposal;
import kr.go.seoul.democracy.proposal.model.vo.ProposalComment;

@Repository("proposalDAO")
public class ProposalDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;//mybatis 사용을 위한 

	//01. 게시글리스트 보기
	public List<Proposal> selectList(int curPage, int recordCountPage) {
		int offset = (curPage-1)*recordCountPage; 
		RowBounds rows = new RowBounds(offset,recordCountPage);
		return sqlSession.selectList("proposal.selectAllList",null,rows);
	}
	
	//02. 게시글 상세보기
	public Proposal proposalView(int proposalNo) {
		return sqlSession.selectOne("proposal.proposalView",proposalNo);
	}

	//글작성하기
	public void insert(Proposal proposal) {
		System.err.println(proposal);
		sqlSession.insert("proposal.insert",proposal);
		
	}
	
	//04. 글수정하기
	public void modify(Proposal proposal){
		System.err.println(proposal);
		sqlSession.update("proposal.modify",proposal); 
	}
	 
	/* 05.글삭제하기 */
	 public void delete(int proposalNo) {
	 sqlSession.update("proposal.delete",proposalNo); 
	 }
	 
	/* 댓글쓰기 */
	 public List<ProposalComment> comlist(int userId){
		  return sqlSession.selectList("proposalComment",userId);
	 }
	
	public void comWrite(Proposal ProposalComment) {
		sqlSession.insert("proposalComment",ProposalComment);
	}


	 
}
