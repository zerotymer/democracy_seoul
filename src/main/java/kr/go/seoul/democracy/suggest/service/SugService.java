package kr.go.seoul.democracy.suggest.service;


import java.util.List;


import kr.go.seoul.democracy.suggest.vo.Sug;
import kr.go.seoul.democracy.suggest.vo.SugComment;

public interface SugService {


	List<Sug> selectAllList(int curPage, int recordCountPage) throws Exception;


	Sug sugView(int suggestNo) throws Exception;


	
	
	void insert(Sug sug) throws Exception;

	
	
	
	
	void modify(Sug sug)throws Exception;
	 
	
	
	
	
	void delete(int suggestNo);

	 public List<SugComment> comlist(int userId);
	 
	 public void comWrite(Sug SugComment);

	

	}