package kr.go.seoul.democracy.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.survey.dao.SurveyDAO;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	@Qualifier("SurveyDAO")
	private SurveyDAO sDAO;
	
	
	
	
	
}
