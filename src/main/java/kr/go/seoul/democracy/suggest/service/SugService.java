package kr.go.seoul.democracy.suggest.service;


import java.util.List;


import kr.go.seoul.democracy.suggest.vo.Sug;

public interface SugService {


	List<Sug> selectAllList(int curPage, int recordCountPage) throws Exception;


	Sug sugView(int sugNo) throws Exception;


	void insert(Sug sug) throws Exception;

	
	

	}