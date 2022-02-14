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
import kr.go.seoul.democracy.board.model.vo.Event;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;

@Repository
public class EventDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;


	//게시글 리스트 불러오기
	public List<Event> eventList(int recordCountPage, int currentListPage) {
		   System.out.println("DAO 확인");
		   int offset = (currentListPage-1)*recordCountPage;
		   RowBounds rb=new RowBounds(offset,recordCountPage);
		   return sqlSession.selectList("event.list",null,rb);//(namespace.id,넣어줄값,그런것들)
	}



 
	public Event noticeNewsViews(int eventNo) {
		// TODO Auto-generated method stub
		Event event = sqlSession.selectOne("event.selectEvent",eventNo);
		return event;
	}


	public int noticeTotalCount() {
		// TODO Auto-generated method stub
		int recordTotalCount = sqlSession.selectOne("event.eventTotalCount");
	
		return recordTotalCount;
		
	}



	//검색 제목
	public List<Event> eventListSearchTitle(int recordCountPerPage, int currentPage, Event event ) {
		   int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("event.eventListSearchTitle",event,rb);
	}

		public int eventSearchTitleCount(Event event) {
			return sqlSession.selectOne("event.eventListSearchTitleCount",event);
		}




		public List<Event> eventListSearchAll(int recordCountPerPage, int currentPage, Event event) {
			  int offset = (currentPage-1)*recordCountPerPage;
			   RowBounds rb=new RowBounds(offset,recordCountPerPage);
			   return sqlSession.selectList("event.eventListSearchAll",event,rb);
		}




		public int totalSearchCount(Event event) {
			
			return sqlSession.selectOne("event.totalSearchCount",event);

		}




		public List<Event> eventListSearchContent(int recordCountPerPage, int currentPage, Event event) {
			  int offset = (currentPage-1)*recordCountPerPage;
			   RowBounds rb=new RowBounds(offset,recordCountPerPage);
			   return sqlSession.selectList("event.eventListSearchContent",event,rb);
		}




		public int totalSearchContentCount(Event event) {
			return sqlSession.selectOne("event.totalSearchContentCount",event);

		}





	

}
