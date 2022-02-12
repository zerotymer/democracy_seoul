package kr.go.seoul.democracy.board.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.go.seoul.democracy.board.model.vo.BoardNotice;


public interface BoardService {

	//공지사항 게시글 목록
	List<BoardNotice> noticeNewsList(int recordCountPage, int currentListPage) throws Exception;
	//공지사항 게시글
	BoardNotice noticeNewsViews(int noticeNewsNo) throws Exception;
	//공지사항 
	int noticeNewsTotalCount();


	
}
