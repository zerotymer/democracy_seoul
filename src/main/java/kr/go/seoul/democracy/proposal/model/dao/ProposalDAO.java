package kr.go.seoul.democracy.proposal.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Proposal> selectAllList() throws Exception{
	return  sqlSession.selectList("proposal.selectAllList");

	}
	//02. 게시글 상세보기
	public Proposal proposalView(int proposalNo)throws Exception {
		return sqlSession.selectOne("proposal.proposalView",proposalNo);
	}
	
	//03. 게시글 레코드 갯수
	public int countArticle(String searchOption, String keyword) {
		//검색옵션, 키워드 를 맵에 저장한다. 
		Map<String,String>map = new HashMap<String,String>();
		map.put("searchOption",searchOption);
		map.put("keyword",keyword);
		return sqlSession.selectOne("proposal.countArticle",map);
	} 
	
	
}
