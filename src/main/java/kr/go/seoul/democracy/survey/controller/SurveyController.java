package kr.go.seoul.democracy.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {
	
	@RequestMapping(value="/survey/adminWriteForm.do", method = RequestMethod.GET)
	public String adminWriteForm() {
		return "survey/adminWriteForm";
	}
}
