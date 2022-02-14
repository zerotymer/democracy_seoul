package kr.go.seoul.democracy.board.model.service;

import java.util.List;

import kr.go.seoul.democracy.board.model.vo.Referenceroom;
import kr.go.seoul.democracy.board.model.vo.SeoulNews;

public interface ReferService {

	List<Referenceroom> referList(int recordCountPage, int currentListPage);

	double totalCount();

	Referenceroom referViews(int referNo);

	List<Referenceroom> referenceroomSearchTitle(int recordCountPerPage, int currentPage, Referenceroom referenceroom);

	int totalSearchTitleCount(Referenceroom referenceroom);

	List<Referenceroom> referenceroomSearchAll(int recordCountPerPage, int currentPage, Referenceroom referenceroom);

	int totalSearchCount(Referenceroom referenceroom);

	List<Referenceroom> referenceroomSearchContent(int recordCountPerPage, int currentPage, Referenceroom referenceroom);
	
	int totalSearchContentCount(Referenceroom referenceroom);


}
