package kr.go.seoul.democracy.suggest.vo;

import java.sql.Date;

public class Sug {
	private int sugNum;
	private String sugTitle;
	private String userId;
	private String sugContent;
	private Date sugDate;
	private Date sugStart;
	private Date sugEnd;
	private char sugDelYN;
	private int sugGory;
	private int sugArea;


	public Sug(int sugNum, String sugTitle, String userId, String sugContent, Date sugDate, Date sugStart, Date sugEnd,
			char sugDelYN, int sugGory, int sugArea) {
		super();
		this.sugNum = sugNum;
		this.sugTitle = sugTitle;
		this.userId = userId;
		this.sugContent = sugContent;
		this.sugDate = sugDate;
		this.sugStart = sugStart;
		this.sugEnd = sugEnd;
		this.sugDelYN = sugDelYN;
		this.sugGory = sugGory;
		this.sugArea = sugArea;


	}
	public Sug() {
		super();
	}

	/// GETTER_SETTER
	public int getSugNum() {
		return sugNum;
	}

	public void setSugNum(int sugNum) {
		this.sugNum = sugNum;
	}

	public String getSugTitle() {
		return sugTitle;
	}

	public void setSugTitle(String sugTitle) {
		this.sugTitle = sugTitle;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSugContent() {
		return sugContent;
	}

	public void setSugContent(String sugContent) {
		this.sugContent = sugContent;
	}

	public Date getSugDate() {
		return sugDate;
	}

	public void setSugDate(Date sugDate) {
		this.sugDate = sugDate;
	}

	public Date getSugStart() {
		return sugStart;
	}

	public void setSugStart(Date sugStart) {
		this.sugStart = sugStart;
	}

	public Date getSugEnd() {
		return sugEnd;
	}

	public void setSugEnd(Date sugEnd) {
		this.sugEnd = sugEnd;
	}

	public char getSugDelYN() {
		return sugDelYN;
	}

	public void setSugDelYN(char sugDelYN) {
		this.sugDelYN = sugDelYN;
	}

	public int getSugGory() {
		return sugGory;
	}

	public void setSugGory(int sugGory) {
		this.sugGory = sugGory;
	}

	public int getSugArea() {
		return sugArea;
	}

	public void setSugArea(int sugArea) {
		this.sugArea = sugArea;
	}

	@Override
	public String toString() {
		return "Sug [sugNum=" + sugNum + ", sugTitle=" + sugTitle + ", userId=" + userId + ", sugContent=" + sugContent
				+ ", sugDate=" + sugDate + ", sugStart=" + sugStart + ", sugEnd=" + sugEnd + ", sugDelYN=" + sugDelYN
				+ ", sugGory=" + sugGory + ", sugArea=" + sugArea + "]";
	}

}
