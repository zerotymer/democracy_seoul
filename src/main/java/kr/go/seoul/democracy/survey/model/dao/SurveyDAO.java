package kr.go.seoul.democracy.survey.model.dao;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.go.seoul.democracy.survey.model.vo.Survey;
import kr.go.seoul.democracy.survey.model.vo.SurveyQ;

@Repository
public class SurveyDAO {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public int addSurvey(Survey survey) {
		return sqlSession.insert("proposal.addSurvey",survey);
	}

	public int addQuestion(ArrayList<SurveyQ> list) {
		return sqlSession.insert("proposal.addQuestion",list);
	}
	
}
