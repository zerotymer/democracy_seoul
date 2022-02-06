package kr.go.seoul.democracy.survey.vo;

public class SurveyA {

	public int surveyAno;
	public int surveyNo;
	public String userId;
	public String answer01;
	public String answer02;
	public String answer03;
	public String answer04;
	public String answer05;
	public String answer06;
	public String answer07;
	public String answer08;
	public String answer09;
	public String answer10;
	
	
	
	public SurveyA() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurveyA(int surveyAno, int surveyNo, String userId, String answer01, String answer02, String answer03,
			String answer04, String answer05, String answer06, String answer07, String answer08, String answer09,
			String answer10) {
		super();
		this.surveyAno = surveyAno;
		this.surveyNo = surveyNo;
		this.userId = userId;
		this.answer01 = answer01;
		this.answer02 = answer02;
		this.answer03 = answer03;
		this.answer04 = answer04;
		this.answer05 = answer05;
		this.answer06 = answer06;
		this.answer07 = answer07;
		this.answer08 = answer08;
		this.answer09 = answer09;
		this.answer10 = answer10;
	}
	
	public int getSurveyAno() {
		return surveyAno;
	}
	public void setSurveyAno(int surveyAno) {
		this.surveyAno = surveyAno;
	}
	public int getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(int surveyNo) {
		this.surveyNo = surveyNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAnswer01() {
		return answer01;
	}
	public void setAnswer01(String answer01) {
		this.answer01 = answer01;
	}
	public String getAnswer02() {
		return answer02;
	}
	public void setAnswer02(String answer02) {
		this.answer02 = answer02;
	}
	public String getAnswer03() {
		return answer03;
	}
	public void setAnswer03(String answer03) {
		this.answer03 = answer03;
	}
	public String getAnswer04() {
		return answer04;
	}
	public void setAnswer04(String answer04) {
		this.answer04 = answer04;
	}
	public String getAnswer05() {
		return answer05;
	}
	public void setAnswer05(String answer05) {
		this.answer05 = answer05;
	}
	public String getAnswer06() {
		return answer06;
	}
	public void setAnswer06(String answer06) {
		this.answer06 = answer06;
	}
	public String getAnswer07() {
		return answer07;
	}
	public void setAnswer07(String answer07) {
		this.answer07 = answer07;
	}
	public String getAnswer08() {
		return answer08;
	}
	public void setAnswer08(String answer08) {
		this.answer08 = answer08;
	}
	public String getAnswer09() {
		return answer09;
	}
	public void setAnswer09(String answer09) {
		this.answer09 = answer09;
	}
	public String getAnswer10() {
		return answer10;
	}
	public void setAnswer10(String answer10) {
		this.answer10 = answer10;
	}

	@Override
	public String toString() {
		return "SurveyA [surveyAno=" + surveyAno + ", surveyNo=" + surveyNo + ", userId=" + userId + ", answer01="
				+ answer01 + ", answer02=" + answer02 + ", answer03=" + answer03 + ", answer04=" + answer04
				+ ", answer05=" + answer05 + ", answer06=" + answer06 + ", answer07=" + answer07 + ", answer08="
				+ answer08 + ", answer09=" + answer09 + ", answer10=" + answer10 + "]";
	}	
	
	
	
}
