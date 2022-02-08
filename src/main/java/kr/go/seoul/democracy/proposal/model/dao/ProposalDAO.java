package kr.go.seoul.democracy.proposal.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.proposal.model.vo.Proposal;

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
	public Proposal proposalView(int proposalNo)throws Exception {
		return sqlSession.selectOne("proposal.proposalView",proposalNo);
	}

	public String getPageNavi(int curPage, int recordCountPage, int naviCountPerPage) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
