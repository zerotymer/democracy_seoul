package kr.go.seoul.democracy.survey.vo;

public class Survey {
	private int surveyNo;
	private int proposalNo;
	private String SurveyTitle;
	
	
	
	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Survey(int surveyNo, int proposalNo, String surveyTitle) {
		super();
		this.surveyNo = surveyNo;
		this.proposalNo = proposalNo;
		SurveyTitle = surveyTitle;
	}

	
	

	public int getSurveyNo() {
		return surveyNo;
	}


	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}


	public int getProposalNo() {
		return proposalNo;
	}


	public void setProposalNo(int proposalNo) {
		this.proposalNo = proposalNo;
	}


	public String getSurveyTitle() {
		return SurveyTitle;
	}


	public void setSurveyTitle(String surveyTitle) {
		SurveyTitle = surveyTitle;
	}


	@Override
	public String toString() {
		return "Survey [surveyNo=" + surveyNo + ", proposalNo=" + proposalNo + ", SurveyTitle=" + SurveyTitle + "]";
	}
	
	
	
	
}
