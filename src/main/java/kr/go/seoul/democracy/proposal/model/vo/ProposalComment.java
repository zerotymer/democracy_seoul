package kr.go.seoul.democracy.proposal.model.vo;

import java.sql.Date;

public class ProposalComment {
	private int proposalNo;
	private int commentNo;
	private String userId;
	private String commentContent;
	private Date commentDate;
	
	
	public ProposalComment(int proposalNo, int commentNo, String userId, String commentContent, Date commentDate) {
		super();
		this.proposalNo = proposalNo;
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}
	
	public ProposalComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(int proposalNo) {
		this.proposalNo = proposalNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "ProposalComment [proposalNo=" + proposalNo + ", commentNo=" + commentNo + ", userId=" + userId
				+ ", commentContent=" + commentContent + ", commentDate=" + commentDate + "]";
	}
	
	
	
}
