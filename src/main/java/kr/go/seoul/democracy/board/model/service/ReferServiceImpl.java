package kr.go.seoul.democracy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.board.model.dao.ReferDAO;
import kr.go.seoul.democracy.board.model.dao.SeoulNewsDAO;
import kr.go.seoul.democracy.board.model.vo.Referenceroom;
import kr.go.seoul.democracy.board.model.vo.SeoulNews;

@Service
public class ReferServiceImpl implements ReferService {
	
	
	@Autowired
	private ReferDAO rDAO;

	@Override
	public List<Referenceroom> referList(int recordCountPage, int currentListPage) {
	
		return rDAO.referList(recordCountPage,currentListPage);
	}

	@Override
	public double totalCount() {
		
		return rDAO.ReferTotalCount();

	}

	@Override
	public Referenceroom referViews(int referNo) {

		return rDAO.referViews(referNo);

	}

	@Override
	public List<Referenceroom> referenceroomSearchTitle(int recordCountPerPage, int currentPage,
			Referenceroom referenceroom) {
		return rDAO.referenceroomSearchTitle(recordCountPerPage, currentPage, referenceroom);

	}

	@Override
	public int totalSearchTitleCount(Referenceroom referenceroom) {
		return rDAO.totalSearchTitleCount(referenceroom);

	}

	@Override
	public List<Referenceroom> referenceroomSearchAll(int recordCountPerPage, int currentPage,
			Referenceroom referenceroom) {
		return rDAO.referenceroomSearchAll(recordCountPerPage, currentPage, referenceroom);

	}

	@Override
	public int totalSearchCount(Referenceroom referenceroom) {
		return rDAO.totalSearchCount(referenceroom);

	}

	@Override
	public List<Referenceroom> referenceroomSearchContent(int recordCountPerPage, int currentPage,
			Referenceroom referenceroom) {
		return rDAO.referenceroomSearchContent(recordCountPerPage, currentPage, referenceroom);

	}

	@Override
	public int totalSearchContentCount(Referenceroom referenceroom) {
		return rDAO.totalSearchContentCount(referenceroom);

	}

}
