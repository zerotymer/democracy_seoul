package kr.go.seoul.democracy.discuss.model.service;

import java.util.ArrayList;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussComment;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

public interface DiscussService {

	ArrayList<Discuss> discussList();

	Discuss discussOne(int discussNo);

	ArrayList<DiscussComment> proComment(int discussNo);

	ArrayList<DiscussComment> conComment(int discussNo);

	ArrayList<DiscussFile> file(int discussNo);

}
