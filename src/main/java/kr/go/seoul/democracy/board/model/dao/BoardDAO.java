package kr.go.seoul.democracy.board.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;

@Repository
public class BoardDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;


	//게시글 리스트 불러오기
	public List<BoardNotice> noticeNewsList(int recordCountPage, int currentListPage) {
		   System.out.println("DAO 확인");
		   int offset = (currentListPage-1)*recordCountPage;
		   RowBounds rb=new RowBounds(offset,recordCountPage);
		   return sqlSession.selectList("board.list",null,rb);//(namespace.id,넣어줄값,그런것들)
	}




	public BoardNotice noticeNewsViews(int noticeNewsNo) {
		// TODO Auto-generated method stub
		return null;
	}





	

}
