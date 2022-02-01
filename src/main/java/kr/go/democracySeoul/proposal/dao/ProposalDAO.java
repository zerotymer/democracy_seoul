package kr.go.democracySeoul.proposal.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.democracySeoul.proposal.vo.Proposal;

@Repository
public class ProposalDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;//mybatis 사용을 위한 

	public List<Proposal> selectAllList(){
	return sqlSession.selectList("proposal.selectAllList");
	} 
	
	
}
