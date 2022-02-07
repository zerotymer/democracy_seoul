package kr.go.seoul.democracy.survey.dao;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
}
