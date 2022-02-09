package kr.go.seoul.democracy.discuss.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Repository
public class DiscussDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public ArrayList<Discuss> discussList(int pageSize, int currentListPage) {
		RowBounds rb=new RowBounds((currentListPage-1)*pageSize,pageSize);
		return new ArrayList<Discuss>(sqlSession.selectList("discuss.list",null,rb));
	}

	public int discussTotalCount() {
		return sqlSession.selectOne("discuss.discussTotalCount");
	}

	public Discuss discussOne(int discussNo) {
		return sqlSession.selectOne("discuss.onePost",discussNo);
	}

	public ArrayList<HashMap<String, Object>> proComment(int discussNo,int pageSize,int currentCommentPage) {
		RowBounds rb=new RowBounds((currentCommentPage-1)*pageSize,pageSize);
		ArrayList<HashMap<String, Object>> test=new ArrayList<HashMap<String, Object>>(sqlSession.selectList("discuss.proCommentList",null,rb));
		System.out.println(test);
		return new ArrayList<HashMap<String, Object>>(sqlSession.selectList("discuss.proCommentList",null,rb));
	}

	/*public ArrayList conComment(int discussNo,int pageSize,int currentCommentPage) {
		RowBounds rb=new RowBounds((currentCommentPage-1)*pageSize,pageSize);
		return new ArrayList(sqlSession.selectList("discuss.conCommentList",null,rb));
	}*/

	public int commentTotalCount(int discussNo) {
		return sqlSession.selectOne("discuss.commentTotalCount",discussNo);
	}

	public ArrayList<DiscussFile> file(int discussNo) {
		return new ArrayList<DiscussFile>(sqlSession.selectList("discuss.fileList",discussNo));
	}

	public int write(Discuss discuss) {
		return sqlSession.selectOne("discuss.write",discuss);
	}

}
