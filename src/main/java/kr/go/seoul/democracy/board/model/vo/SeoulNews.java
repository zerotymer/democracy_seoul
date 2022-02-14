package kr.go.seoul.democracy.board.model.vo;

import java.sql.Date;

public class SeoulNews {
	
	
	private int seoulNewsNo;
	private String seoulTitle;
    private String seoulContent;
    private Date seoulDate;
    private char seoulDelYN;
    
    
	public SeoulNews() {}


	public SeoulNews(int seoulNewsNo, String seoulTitle, String seoulContent, Date seoulDate, char seoulDelYN) {
		super();
		this.seoulNewsNo = seoulNewsNo;
		this.seoulTitle = seoulTitle;
		this.seoulContent = seoulContent;
		this.seoulDate = seoulDate;
		this.seoulDelYN = seoulDelYN;
	}


	@Override
	public String toString() {
		return "SeoulNews [seoulNewsNo=" + seoulNewsNo + ", seoulTitle=" + seoulTitle + ", seoulContent=" + seoulContent
				+ ", seoulDate=" + seoulDate + ", seoulDelYN=" + seoulDelYN + "]";
	}


	public int getSeoulNewsNo() {
		return seoulNewsNo;
	}


	public void setSeoulNewsNo(int seoulNewsNo) {
		this.seoulNewsNo = seoulNewsNo;
	}


	public String getSeoulTitle() {
		return seoulTitle;
	}


	public void setSeoulTitle(String seoulTitle) {
		this.seoulTitle = seoulTitle;
	}


	public String getSeoulContent() {
		return seoulContent;
	}


	public void setSeoulContent(String seoulContent) {
		this.seoulContent = seoulContent;
	}


	public Date getSeoulDate() {
		return seoulDate;
	}


	public void setSeoulDate(Date seoulDate) {
		this.seoulDate = seoulDate;
	}


	public char getSeoulDelYN() {
		return seoulDelYN;
	}


	public void setSeoulDelYN(char seoulDelYN) {
		this.seoulDelYN = seoulDelYN;
	}

}
