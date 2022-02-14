package kr.go.seoul.democracy.board.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.board.model.vo.Event;
import kr.go.seoul.democracy.board.model.vo.Referenceroom;

@Repository
public class ReferDAO {
	
	@Autowired
	@Qualifier(value="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public double ReferTotalCount() {

		int recordTotalCount = sqlSession.selectOne("referenceroom.referTotalCount");
	
		return recordTotalCount;
	}


	public List<Referenceroom> referList(int recordCountPage, int currentListPage) {
		   
		   System.out.println("DAO 확인");
		   int offset = (currentListPage-1)*recordCountPage;
		   RowBounds rb=new RowBounds(offset,recordCountPage);
		   return sqlSession.selectList("referenceroom.list",null,rb);
	}

	public Referenceroom referViews(int referNo) {
	
		Referenceroom referenceroom = sqlSession.selectOne("referenceroom.selectRefer",referNo);
		return referenceroom;
	}


	public List<Referenceroom> referenceroomSearchTitle(int recordCountPerPage, int currentPage,
			Referenceroom referenceroom) {
		   int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("referenceroom.referenceroomSearchTitle",referenceroom,rb);	
		   }
	


	public int totalSearchTitleCount(Referenceroom referenceroom) {
		return sqlSession.selectOne("referenceroom.totalSearchTitleCount",referenceroom);

	}


	public List<Referenceroom> referenceroomSearchAll(int recordCountPerPage, int currentPage,
			Referenceroom referenceroom) {
		 int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("referenceroom.referenceroomSearchAll",referenceroom,rb);	
	}


	public int totalSearchCount(Referenceroom referenceroom) {
		return sqlSession.selectOne("referenceroom.totalSearchCount",referenceroom);

	}


	public List<Referenceroom> referenceroomSearchContent(int recordCountPerPage, int currentPage,
			Referenceroom referenceroom) {
		 int offset = (currentPage-1)*recordCountPerPage;
		   RowBounds rb=new RowBounds(offset,recordCountPerPage);
		   return sqlSession.selectList("referenceroom.referenceroomSearchContent",referenceroom,rb);	
	}


	public int totalSearchContentCount(Referenceroom referenceroom) {
		return sqlSession.selectOne("referenceroom.totalSearchContentCount",referenceroom);

	}

}
