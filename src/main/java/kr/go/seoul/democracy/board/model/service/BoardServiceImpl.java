package kr.go.seoul.democracy.board.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.board.model.dao.BoardDAO;
import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.member.model.dao.MemberDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDAO;

	
	
	
	
	@Override
	public List<BoardNotice> noticeNewsList(int recordCountPage, int currentListPage) {
		System.out.println("목록구현 정상구동");
		return bDAO.noticeNewsList(recordCountPage,currentListPage);

	}
	
	
	
	@Override
	public BoardNotice noticeNewsViews(int noticeNewsNo) throws Exception {
		
		return bDAO.noticeNewsViews(noticeNewsNo);
	}



	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return bDAO.noticeTotalCount();
	}



	@Override
	public List<BoardNotice> noticeNewsListSearch(int recordCountPerPage, int currentPage, BoardNotice boardNotice) throws Exception {
		
		return bDAO. noticeNewsListSearch(recordCountPerPage,currentPage,boardNotice);

	}



	@Override
	public int totalSerchCount(BoardNotice boardNotice) {
		// TODO Auto-generated method stub
		return bDAO.noticeSerchCount(boardNotice);
	}



	@Override
	public List<BoardNotice> noticeNewsListSearchTitle(int recordCountPerPage, int currentPage, BoardNotice boardNotice)
			throws Exception {
		// TODO Auto-generated method stub
		return bDAO.noticeNewsListSearchTitle(recordCountPerPage, currentPage, boardNotice);
	}



	@Override
	public int totalSearchTitleCount(BoardNotice boardNotice) {
		// TODO Auto-generated method stub
		return bDAO.noticeSearchTitleCount(boardNotice);
	}
	
	
	@Override
	public List<BoardNotice> noticeNewsListSearchContent(int recordCountPerPage, int currentPage, BoardNotice boardNotice)
			throws Exception {
		// TODO Auto-generated method stub
		return bDAO.noticeNewsListSearchContent(recordCountPerPage, currentPage, boardNotice);
	}



	@Override
	public int totalSearchContentCount(BoardNotice boardNotice) {
		// TODO Auto-generated method stub
		return bDAO.noticeSearchContentCount(boardNotice);
	}


	

	






	



}
