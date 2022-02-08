package kr.go.seoul.democracy.discuss.model.service;

import java.util.ArrayList;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussComment;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

public interface DiscussService {

	ArrayList<Discuss> discussList(int pageSize,int currentListPage);
	
	int discussTotalCount();

	Discuss discussOne(int discussNo);

	ArrayList<DiscussComment> proComment(int discussNo,int pageSize,int currentCommentPage);

	ArrayList<DiscussComment> conComment(int discussNo,int pageSize,int currentCommentPage);
	
	int commentTotalCount(int discussNo);

	ArrayList<DiscussFile> file(int discussNo);


}
