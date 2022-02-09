package kr.go.seoul.democracy.proposal.model.vo;

import java.sql.Date;


public class Proposal {
	private int proposalNo;
	private String proposalTitle;
	private String proposalContent;
	private Date proposalDate;
	private Date proposalStart;
	private Date proposalEnd;
	private char proposalDelYN;
	private String proposalThumbnail;
	private String proposalThumbnailPath;
	
	
	public Proposal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Proposal(int proposalNo, String proposalTitle, String proposalContent, Date proposalDate, Date proposalStart,
			Date proposalEnd, char proposalDelYN, String proposalThumbnail, String proposalThumbnailPath) {
		super();
		this.proposalNo = proposalNo;
		this.proposalTitle = proposalTitle;
		this.proposalContent = proposalContent;
		this.proposalDate = proposalDate;
		this.proposalStart = proposalStart;
		this.proposalEnd = proposalEnd;
		this.proposalDelYN = proposalDelYN;
		this.proposalThumbnail = proposalThumbnail;
		this.proposalThumbnailPath = proposalThumbnailPath;
	}


	public int getProposalNo() {
		return proposalNo;
	}


	public void setProposalNo(int proposalNo) {
		this.proposalNo = proposalNo;
	}


	public String getProposalTitle() {
		return proposalTitle;
	}


	public void setProposalTitle(String proposalTitle) {
		this.proposalTitle = proposalTitle;
	}


	public String getProposalContent() {
		return proposalContent;
	}


	public void setProposalContent(String proposalContent) {
		this.proposalContent = proposalContent;
	}


	public Date getProposalDate() {
		return proposalDate;
	}


	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}


	public Date getProposalStart() {
		return proposalStart;
	}


	public void setProposalStart(Date proposalStart) {
		this.proposalStart = proposalStart;
	}


	public Date getProposalEnd() {
		return proposalEnd;
	}


	public void setProposalEnd(Date proposalEnd) {
		this.proposalEnd = proposalEnd;
	}


	public char getProposalDelYN() {
		return proposalDelYN;
	}


	public void setProposalDelYN(char proposalDelYN) {
		this.proposalDelYN = proposalDelYN;
	}


	public String getProposalThumbnail() {
		return proposalThumbnail;
	}


	public void setProposalThumbnail(String proposalThumbnail) {
		this.proposalThumbnail = proposalThumbnail;
	}


	public String getProposalThumbnailPath() {
		return proposalThumbnailPath;
	}


	public void setProposalThumbnailPath(String proposalThumbnailPath) {
		this.proposalThumbnailPath = proposalThumbnailPath;
	}


	@Override
	public String toString() {
		return "Proposal [proposalNo=" + proposalNo + ", proposalTitle=" + proposalTitle + ", proposalContent="
				+ proposalContent + ", proposalDate=" + proposalDate + ", proposalStart=" + proposalStart
				+ ", proposalEnd=" + proposalEnd + ", proposalDelYN=" + proposalDelYN + ", proposalThumbnail="
				+ proposalThumbnail + ", proposalThumbnailPath=" + proposalThumbnailPath + "]";
	}
	
	

	
}
