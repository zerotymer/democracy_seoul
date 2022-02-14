package kr.go.seoul.democracy.suggest.vo;

import java.sql.Date;

public class Sug {
	private int suggestNo;
	private String suggestTitle;
	private String userId;
	private String suggestContent;
	private Date suggestDate;
	private Date suggestStart;
	private Date suggestEnd;
	private char suggestDelYN;
	private int suggestGory;
	private int suggestArea;
	
	
	
	
	
	
	
	
	
	
	public Sug(int suggestNo, String suggestTitle, String userId, String suggestContent, Date suggestDate,
			Date suggestStart, Date suggestEnd, char suggestDelYN, int suggestGory, int suggestArea) {
		super();
		this.suggestNo = suggestNo;
		this.suggestTitle = suggestTitle;
		this.userId = userId;
		this.suggestContent = suggestContent;
		this.suggestDate = suggestDate;
		this.suggestStart = suggestStart;
		this.suggestEnd = suggestEnd;
		this.suggestDelYN = suggestDelYN;
		this.suggestGory = suggestGory;
		this.suggestArea = suggestArea;
	}




	public Sug() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Sug [suggestNo=" + suggestNo + ", suggestTitle=" + suggestTitle + ", userId=" + userId
				+ ", suggestContent=" + suggestContent + ", suggestDate=" + suggestDate + ", suggestStart="
				+ suggestStart + ", suggestEnd=" + suggestEnd + ", suggestDelYN=" + suggestDelYN + ", suggestGory="
				+ suggestGory + ", suggestArea=" + suggestArea + "]";
	}
	
	
	
	
	public int getSuggestNo() {
		return suggestNo;
	}
	public void setSuggestNo(int suggestNo) {
		this.suggestNo = suggestNo;
	}
	public String getSuggestTitle() {
		return suggestTitle;
	}
	public void setSuggestTitle(String suggestTitle) {
		this.suggestTitle = suggestTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSuggestContent() {
		return suggestContent;
	}
	public void setSuggestContent(String suggestContent) {
		this.suggestContent = suggestContent;
	}
	public Date getSuggestDate() {
		return suggestDate;
	}
	public void setSuggestDate(Date suggestDate) {
		this.suggestDate = suggestDate;
	}
	public Date getSuggestStart() {
		return suggestStart;
	}
	public void setSuggestStart(Date suggestStart) {
		this.suggestStart = suggestStart;
	}
	public Date getSuggestEnd() {
		return suggestEnd;
	}
	public void setSuggestEnd(Date suggestEnd) {
		this.suggestEnd = suggestEnd;
	}
	public char getSuggestDelYN() {
		return suggestDelYN;
	}
	public void setSuggestDelYN(char suggestDelYN) {
		this.suggestDelYN = suggestDelYN;
	}
	public int getSuggestGory() {
		return suggestGory;
	}
	public void setSuggestGory(int suggestGory) {
		this.suggestGory = suggestGory;
	}
	public int getSuggestArea() {
		return suggestArea;
	}
	public void setSuggestArea(int suggestArea) {
		this.suggestArea = suggestArea;
	}

	
	
	
	
}
