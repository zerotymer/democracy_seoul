package kr.go.seoul.democracy.survey.model.service;

import java.util.ArrayList;

import kr.go.seoul.democracy.survey.model.vo.Survey;
import kr.go.seoul.democracy.survey.model.vo.SurveyQ;

public interface SurveyService {

	int addSurvey(Survey survey);

	int addQuestion(ArrayList<SurveyQ> list);

}
