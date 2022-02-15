package kr.go.seoul.democracy.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {
	
	@RequestMapping(value="/survey/adminWriteForm.do", method = RequestMethod.GET)
	public String adminWriteForm() {
		return "survey/adminWriteForm";
	}
	
	@RequestMapping(value="/survey/adminWrite.do", method = RequestMethod.POST)
	public void adminWrite(ModelAndView mav,@RequestParam String questionContent,@RequestParam String questionInputType,@RequestParam String contentQ) {
		
		
		System.out.println(questionContent);
		System.out.println(questionInputType);
		System.out.println(contentQ);
	}
}
