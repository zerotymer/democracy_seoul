package kr.go.seoul.democracy.survey.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.survey.model.dao.SurveyDAO;
import kr.go.seoul.democracy.survey.model.vo.Survey;
import kr.go.seoul.democracy.survey.model.vo.SurveyQ;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	@Qualifier("surveyDAO")
	private SurveyDAO sDAO;

	@Override
	public int addSurvey(Survey survey) {
		return sDAO.addSurvey(survey);
	}

	@Override
	public int addQuestion(ArrayList<SurveyQ> list) {
		return sDAO.addQuestion(list);
	}
	
}
