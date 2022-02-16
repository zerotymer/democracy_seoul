package kr.go.seoul.democracy.survey.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.survey.model.service.SurveyService;
import kr.go.seoul.democracy.survey.model.vo.Survey;
import kr.go.seoul.democracy.survey.model.vo.SurveyQ;

@Controller
public class SurveyController {
	
	@Autowired
	private SurveyService surveyService;
	
	@RequestMapping(value="/survey/adminWriteForm.do", method = RequestMethod.GET)
	public String adminWriteForm() {
		return "survey/adminWriteForm";
	}
	
	@RequestMapping(value="/survey/adminWrite.do", method = RequestMethod.POST)
	public void adminWrite(ModelAndView mav,
							//@RequestParam int proposalNo,
							@RequestParam String title, //설문지 제목
							@RequestParam String qNo, //몇번까지 작성했는지
							@RequestParam String contentQValue, // 질문
							@RequestParam String questionInputType, // 타입
							@RequestParam String questionContent) { // 번호/문항/문항/문항
		
		int proposalNo=46;
		int question=Integer.parseInt(qNo);
		System.out.println(proposalNo);
		System.out.println(title);
		//새 설문 생성
		Survey survey=new Survey();
		int resultSurvey=surveyService.addSurvey(survey);
		
		
		//새 설문 내용
		String contentQArray[]=contentQValue.split(",");
		String inputTypeArray[]=questionInputType.split(",");
		String contentArray[]=null;
		
		/*String qInputType[]=questionInputType.split(",");
		for(int i=0;i<qInputType.length;i++) {
			String qinputType[]=qInputType[i].split("/");
			inputTypeArray[i]=qinputType[1];
		}*/
		
		String question_content[]=questionContent.split(",");
		for(int i=0;i<question_content.length;i++) {
			String qContent[]=question_content[i].split("/");
			
			String content=qContent[1];
			for(int j=2;j<qContent.length;j++) {
				content+="/"+qContent[j];
			}
			contentArray[i]=content;
		}
		
		ArrayList<SurveyQ> list=new ArrayList<SurveyQ>();
		
		for(int i=0;i<question;i++) {
			char inputType=inputTypeArray[i].charAt(0);
			String content=contentArray[i];
			String contentQ=contentQArray[i];
			
			System.out.println(inputType);
			System.out.println(content);
			System.out.println(contentQ);
			
			SurveyQ surveyQ=new SurveyQ(survey.getSurveyNo(),i+1,inputType,content,contentQ);
			list.add(surveyQ);
		}
		
		int resultSurveyQ=surveyService.addQuestion(list);
		
		System.out.println(questionContent);
		System.out.println(questionInputType);
		System.out.println(contentQValue);
	}
}
