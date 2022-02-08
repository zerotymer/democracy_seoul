package kr.go.seoul.democracy.survey.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.survey.model.dao.SurveyDAO;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	@Qualifier("surveyDAO")
	private SurveyDAO sDAO;
	
	
	
	
	
}
