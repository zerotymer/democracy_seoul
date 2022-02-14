package kr.go.seoul.democracy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.board.model.dao.EventDAO;
import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.board.model.vo.Event;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventDAO eDAO;


	@Override
	public List<Event> eventList(int recordCountPage, int currentListPage) throws Exception {
		// TODO Auto-generated method stub
		return eDAO.eventList(recordCountPage, currentListPage);
	}

	@Override
	public Event eventNewsViews(int eventNo) throws Exception {
		// TODO Auto-generated method stub
		return eDAO.noticeNewsViews(eventNo);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return eDAO.noticeTotalCount();
	}
    //검색 제목
	@Override
	public List<Event> eventListSearchTitle(int recordCountPerPage, int currentPage, Event event)
			throws Exception {
		// TODO Auto-generated method stub
		return eDAO.eventListSearchTitle(recordCountPerPage, currentPage, event);
	}



	@Override
	public int totalSearchTitleCount(Event event) {
		// TODO Auto-generated method stub
		return eDAO.eventSearchTitleCount(event);
	}

	//검색 전체
	@Override
	public List<Event> eventListSearchAll(int recordCountPerPage, int currentPage, Event event) throws Exception{
		return eDAO.eventListSearchAll(recordCountPerPage, currentPage, event);

	}

	@Override
	public int totalSearchCount(Event event) {
		return eDAO.totalSearchCount(event);

	}

	
	//검색 내용
	@Override
	public List<Event> eventListSearchContent(int recordCountPerPage, int currentPage, Event event) throws Exception {
		return eDAO.eventListSearchContent(recordCountPerPage, currentPage, event);

	}

	@Override
	public int totalSearchContentCount(Event event) {
		return eDAO.totalSearchContentCount(event);

	}

}
