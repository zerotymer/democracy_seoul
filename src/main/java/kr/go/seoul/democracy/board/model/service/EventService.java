package kr.go.seoul.democracy.board.model.service;

import java.util.List;

import kr.go.seoul.democracy.board.model.vo.Event;

public interface EventService {
	    //행사 게시글 목록	 
		List<Event> eventList(int recordCountPage, int currentListPage) throws Exception;
		//행사 게시글
		Event eventNewsViews(int noticeNewsNo) throws Exception;
		//게시글개수
		int totalCount();
		//행사 제목 검색 로직
		List<Event> eventListSearchTitle(int recordCountPerPage, int currentPage, Event event) throws Exception;
		int totalSearchTitleCount(Event event);
		//행사 제목+내용 로직
		List<Event> eventListSearchAll(int recordCountPerPage, int currentPage, Event event) throws Exception;
		int totalSearchCount(Event event) ;
		//행사 내용 검색
		List<Event> eventListSearchContent(int recordCountPerPage, int currentPage, Event event) throws Exception;
		int totalSearchContentCount(Event event);


}
