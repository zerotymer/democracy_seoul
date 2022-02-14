package kr.go.seoul.democracy.board.model.service;

import java.util.List;

import kr.go.seoul.democracy.board.model.vo.SeoulNews;

public interface SeoulNewsService {

	double totalCount();

	List<SeoulNews> seoulNewsList(int recordCountPage, int currentListPage);

	SeoulNews seoulNewsNewsViews(int seoulNewsNo);

	List<SeoulNews> seoulNewsListSearchTitle(int recordCountPerPage, int currentPage, SeoulNews seoulNews) throws Exception;

	int totalSearchTitleCount(SeoulNews seoulNews);

	List<SeoulNews> seoulNewsListSearchAll(int recordCountPerPage, int currentPage, SeoulNews seoulNews) throws Exception;

	int totalSearchCount(SeoulNews seoulNews);

	List<SeoulNews> seoulNewsListSearchContent(int recordCountPerPage, int currentPage, SeoulNews seoulNews) throws Exception;

	int totalSearchContentCount(SeoulNews seoulNews);


}
