package kr.go.seoul.democracy.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.board.model.vo.SeoulNews;

@Repository
public class SeoulNewsDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public double seoulNewsTotalCount() {
		int recordTotalCount = sqlSession.selectOne("seoulNews.seoulNewsTotalCount");
		
		return recordTotalCount;
	}

	public List<SeoulNews> seoulNewsList(int recordCountPage, int currentListPage) {
		   System.out.println("DAO 확인");
		   int offset = (currentListPage-1)*recordCountPage;
		   RowBounds rb=new RowBounds(offset,recordCountPage);
		   return sqlSession.selectList("seoulNews.list",null,rb);//(namespace.id,넣어줄값,그런것들)
	}

	public SeoulNews seoulNewsNewsViews(int seoulNewsNo) {
		SeoulNews seoulNews = sqlSession.selectOne("seoulNews.selectSeoulNews",seoulNewsNo);
		return seoulNews;
	}

	public List<SeoulNews> seoulNewsListSearchTitle(int recordCountPerPage, int currentPage, SeoulNews seoulNews) {
		   int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("seoulNews.seoulNewsListSearchTitle",seoulNews,rb);	}

	public int totalSearchTitleCount(SeoulNews seoulNews) {
		return sqlSession.selectOne("seoulNews.totalSearchTitleCount",seoulNews);

	}

	public List<SeoulNews> seoulNewsListSearchAll(int recordCountPerPage, int currentPage, SeoulNews seoulNews) {
		   int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("seoulNews.seoulNewsListSearchAll",seoulNews,rb);	}
	

	public int totalSearchCount(SeoulNews seoulNews) {
		return sqlSession.selectOne("seoulNews.totalSearchCount",seoulNews);

	}

	public List<SeoulNews> seoulNewsListSearchContent(int recordCountPerPage, int currentPage, SeoulNews seoulNews) {
		  int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("seoulNews.seoulNewsListSearchContent",seoulNews,rb);	}


	public int totalSearchContentCount(SeoulNews seoulNews) {
		return sqlSession.selectOne("seoulNews.totalSearchContentCount",seoulNews);

	}



}
