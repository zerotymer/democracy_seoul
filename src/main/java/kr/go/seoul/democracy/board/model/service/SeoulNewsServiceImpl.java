package kr.go.seoul.democracy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.board.model.dao.SeoulNewsDAO;
import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.board.model.vo.SeoulNews;

@Service
public class SeoulNewsServiceImpl implements SeoulNewsService{
	
	@Autowired
	private SeoulNewsDAO sDAO;

	@Override
	public double totalCount() {

		return sDAO.seoulNewsTotalCount();
	}

	@Override
	public List<SeoulNews> seoulNewsList(int recordCountPage, int currentListPage) {
		
		return sDAO.seoulNewsList(recordCountPage,currentListPage);

	}

	@Override
	public SeoulNews seoulNewsNewsViews(int seoulNewsNo) {
	
		return sDAO.seoulNewsNewsViews(seoulNewsNo);

	}

	@Override
	public List<SeoulNews> seoulNewsListSearchTitle(int recordCountPerPage, int currentPage, SeoulNews seoulNews) throws Exception {
	
		return sDAO.seoulNewsListSearchTitle(recordCountPerPage, currentPage, seoulNews);

	}

	@Override
	public int totalSearchTitleCount(SeoulNews seoulNews) {
		return sDAO.totalSearchTitleCount(seoulNews);

	}

	@Override
	public List<SeoulNews> seoulNewsListSearchAll(int recordCountPerPage, int currentPage, SeoulNews seoulNews) throws Exception{
		
		return sDAO.seoulNewsListSearchAll(recordCountPerPage, currentPage, seoulNews);

	}

	@Override
	public int totalSearchCount(SeoulNews seoulNews) {
		return sDAO.totalSearchCount(seoulNews);

	}

	@Override
	public List<SeoulNews> seoulNewsListSearchContent(int recordCountPerPage, int currentPage, SeoulNews seoulNews)  throws Exception{
		return sDAO.seoulNewsListSearchContent(recordCountPerPage, currentPage, seoulNews);

	}

	@Override
	public int totalSearchContentCount(SeoulNews seoulNews) {
		return sDAO.totalSearchContentCount(seoulNews);

	}
	
	

}
