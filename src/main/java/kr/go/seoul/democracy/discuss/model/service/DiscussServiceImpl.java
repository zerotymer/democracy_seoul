package kr.go.seoul.democracy.discuss.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.discuss.model.dao.DiscussDAO;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Service
public class DiscussServiceImpl implements DiscussService {
	
	@Autowired
	private DiscussDAO dDAO;
	
	@Override
	public ArrayList<Discuss> discussList(int pageSize,int currentListPage) {
		return dDAO.discussList(pageSize,currentListPage);
	}

	@Override
	public int discussTotalCount() {
		return dDAO.discussTotalCount();
	}

	@Override
	public Discuss discussOne(int discussNo) {
		return dDAO.discussOne(discussNo);
	}

	@Override
	public ArrayList<HashMap<String, Object>> proComment(int discussNo,int pageSize,int currentCommentPage) {
		return dDAO.proComment(discussNo,pageSize,currentCommentPage);
	}

	@Override
	public ArrayList<HashMap<String, Object>> conComment(int discussNo,int pageSize,int currentCommentPage) {
		return dDAO.conComment(discussNo,pageSize,currentCommentPage);
	}

	@Override
	public int commentTotalCount(int discussNo) {
		return dDAO.commentTotalCount(discussNo);
	}

	@Override
	public ArrayList<DiscussFile> file(int discussNo) {
		return dDAO.file(discussNo);
	}

	@Override
	public int write(Discuss discuss) {
		return dDAO.write(discuss);
	}

}
