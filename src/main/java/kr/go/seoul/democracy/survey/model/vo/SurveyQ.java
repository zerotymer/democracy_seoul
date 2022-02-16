package kr.go.seoul.democracy.survey.model.vo;

public class SurveyQ {

	public int surveyQno;
	public int surveyNo;
	public int question;
	public char inputType;
	public String content;
	public String contentQ;
	
	
	public SurveyQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurveyQ(int surveyQno, int surveyNo, int question, char inputType, String content, String contentQ) {
		super();
		this.surveyQno = surveyQno;
		this.surveyNo = surveyNo;
		this.question = question;
		this.inputType = inputType;
		this.content = content;
		this.contentQ = contentQ;
	}
	

	public SurveyQ(int surveyNo, int question, char inputType, String content, String contentQ) {
		super();
		this.surveyNo = surveyNo;
		this.question = question;
		this.inputType = inputType;
		this.content = content;
		this.contentQ = contentQ;
	}

	public int getSurveyQno() {
		return surveyQno;
	}
	public void setSurveyQno(int surveyQno) {
		this.surveyQno = surveyQno;
	}
	public int getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public char getInputType() {
		return inputType;
	}
	public void setInputType(char inputType) {
		this.inputType = inputType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentQ() {
		return contentQ;
	}
	public void setContentQ(String contentQ) {
		this.contentQ = contentQ;
	}

	@Override
	public String toString() {
		return "SurveyQ [surveyQno=" + surveyQno + ", surveyNo=" + surveyNo + ", question=" + question + ", inputType="
				+ inputType + ", content=" + content + ", contentQ=" + contentQ + "]";
	}
	
	
	
}
