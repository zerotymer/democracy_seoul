package kr.go.seoul.democracy.suggest.service;

import java.util.ArrayList;

import kr.go.seoul.democracy.suggest.vo.Sug;



public interface SugService {
	
	ArrayList<Sug> selectAllNoticeList(int currentPage, int recordCountPerPage);

	int noticeTotalCount();
	


}
