package kr.go.seoul.democracy.discuss.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.discuss.model.dao.DiscussDAO;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussComment;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Service
public class DiscussServiceImpl implements DiscussService {
	
	@Autowired
	private DiscussDAO dDAO;
	
	@Override
	public ArrayList<Discuss> discussList() {
		return dDAO.discussList();
	}

	@Override
	public Discuss discussOne(int discussNo) {
		return dDAO.discussOne(discussNo);
	}

	@Override
	public ArrayList<DiscussComment> proComment(int discussNo) {
		return dDAO.proComment(discussNo);
	}

	@Override
	public ArrayList<DiscussComment> conComment(int discussNo) {
		return dDAO.conComment(discussNo);
	}

	@Override
	public ArrayList<DiscussFile> file(int discussNo) {
		return dDAO.file(discussNo);
	}

}
