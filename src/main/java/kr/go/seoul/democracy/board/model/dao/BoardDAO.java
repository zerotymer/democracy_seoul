package kr.go.seoul.democracy.board.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;

@Repository
public class BoardDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;


	public int noticeNewsTotalCount() {
	    return sqlSession.selectOne("board.discussTotalCount");

	}

	public ArrayList<BoardNotice> noticeNewsList(int pageSize, int currentListPage) {
		   RowBounds rb=new RowBounds((currentListPage-1)*pageSize,pageSize);
		   return new ArrayList<BoardNotice>(sqlSession.selectList("board.list",null,rb));
	}




	

}
