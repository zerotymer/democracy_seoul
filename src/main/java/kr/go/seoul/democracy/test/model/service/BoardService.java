package kr.go.seoul.democracy.test.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;

public interface BoardService {

	int noticeNewsTotalCount();

	ArrayList<Discuss> noticeNewsList(int pageSize, int currentListPage);

}
