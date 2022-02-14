package kr.go.seoul.democracy.board.model.vo;

import java.sql.Date;
import java.util.List;

public class Referenceroom {
	
	
	private int referNo;
	private String referTitle;
    private String referContent;
    private Date referDate;
    private char referDelYN;
	public Referenceroom() {
	}
	public Referenceroom(int referNo, String referTitle, String referContent, Date referDate, char referDelYN) {
		super();
		this.referNo = referNo;
		this.referTitle = referTitle;
		this.referContent = referContent;
		this.referDate = referDate;
		this.referDelYN = referDelYN;
	}
	@Override
	public String toString() {
		return "Referenceroom [referNo=" + referNo + ", referTitle=" + referTitle + ", referContent=" + referContent
				+ ", referDate=" + referDate + ", referDelYN=" + referDelYN + "]";
	}
	public int getReferNo() {
		return referNo;
	}
	public void setReferNo(int referNo) {
		this.referNo = referNo;
	}
	public String getReferTitle() {
		return referTitle;
	}
	public void setReferTitle(String referTitle) {
		this.referTitle = referTitle;
	}
	public String getReferContent() {
		return referContent;
	}
	public void setReferContent(String referContent) {
		this.referContent = referContent;
	}
	public Date getReferDate() {
		return referDate;
	}
	public void setReferDate(Date referDate) {
		this.referDate = referDate;
	}
	public char getReferDelYN() {
		return referDelYN;
	}
	public void setReferDelYN(char referDelYN) {
		this.referDelYN = referDelYN;
	}

    
	
	

    
    

}
