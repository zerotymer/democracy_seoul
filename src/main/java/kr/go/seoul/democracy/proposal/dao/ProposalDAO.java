package kr.go.seoul.democracy.proposal.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.proposal.vo.Proposal;

@Repository("proposalDAO")
public class ProposalDAO {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;//mybatis 사용을 위한 

	public List<Proposal> selectAllList(){
//		return sqlSession.selectList("proposal.selectAllList");
		List<Proposal> list = sqlSession.selectList("proposal.selectAllList");
		System.err.println(list);
		return null;
	} 
	
	
}
