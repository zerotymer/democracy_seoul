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
		BoardNotice boardNotice = sqlSession.selectOne("board.selectBoardNotice",noticeNewsNo);
		return boardNotice;
	}




	public int noticeTotalCount() {
		// TODO Auto-generated method stub
		int recordTotalCount = sqlSession.selectOne("board.noticeNewsTotalCount");
	
		return recordTotalCount;
		
	}



	//검색
	public List<BoardNotice> noticeNewsListSearch(int recordCountPerPage, int currentPage, BoardNotice boardNotice ) {
			System.out.println("DAO 확인");
		   int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("board.noticeNewsListSearch",boardNotice,rb);
	}

	public int noticeSerchCount(BoardNotice boardNotice) {
		return sqlSession.selectOne("board.noticeNewsListSearchCount",boardNotice);
	}

	//검색 제목
	public List<BoardNotice> noticeNewsListSearchTitle(int recordCountPerPage, int currentPage, BoardNotice boardNotice ) {
	   int offset = (currentPage-1)*recordCountPerPage;
	   RowBounds rb=new RowBounds(offset,recordCountPerPage);
	   return sqlSession.selectList("board.noticeNewsListSearchTitle",boardNotice,rb);
}

	public int noticeSearchTitleCount(BoardNotice boardNotice) {
		return sqlSession.selectOne("board.noticeNewsListSearchTitleCount",boardNotice);
	}
	
	
	public List<BoardNotice> noticeNewsListSearchContent(int recordCountPerPage, int currentPage, BoardNotice boardNotice ) {
		   int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("board.noticeNewsListSearchContent",boardNotice,rb);
	}

		public int noticeSearchContentCount(BoardNotice boardNotice) {
			return sqlSession.selectOne("board.noticeNewsListSearchContentCount",boardNotice);
		}




	

}
