package kr.go.seoul.democracy.test.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.member.model.dao.MemberDAO;
import kr.go.seoul.democracy.test.model.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDAO;


	@Override
	public int noticeNewsTotalCount() {
		
		return bDAO.noticeNewsTotalCount();

	}

	@Override
	public ArrayList<Discuss> noticeNewsList(int pageSize, int currentListPage) {
		
		return bDAO.noticeNewsList(pageSize,currentListPage);

	}



	



}
