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

	@Override
	public ArrayList<HashMap<String, Object>> getComment(int discussNo, int currentCommentPage,int pageSize) {
		return dDAO.getComment(discussNo,currentCommentPage,pageSize);
	}

	@Override
	public int writeComment(HashMap<String, Object> comment) {
		return dDAO.writeComment(comment);
	}

	@Override
	public HashMap<String, Object> myComment(int discussNo, String userId) {
		return dDAO.myComment(discussNo,userId);
	}

	@Override
	public int vote(HashMap<String, Object> vote) {
		return dDAO.vote(vote);
	}

	@Override
	public HashMap<String, Object> getVote(int discussNo) {
		return dDAO.getVote(discussNo);
	}

	@Override
	public ArrayList<Discuss> getList(int currentListPage, int pageSize) {
		return dDAO.getList(currentListPage,pageSize);
	}

	@Override
	public int fileUpload(HashMap<String, Object> file) {
		return dDAO.fileUpload(file);
	}

	@Override
	public int fileUpdate(int discussNo, int fileNo) {
		return dDAO.fileUpdate(discussNo,fileNo);
	}

}
