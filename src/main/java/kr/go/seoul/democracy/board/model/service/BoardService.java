package kr.go.seoul.democracy.board.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.go.seoul.democracy.board.model.vo.BoardNotice;


public interface BoardService {

	int noticeNewsTotalCount();

	ArrayList<BoardNotice> noticeNewsList(int pageSize, int currentListPage);


}
