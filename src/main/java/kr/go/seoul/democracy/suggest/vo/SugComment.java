package kr.go.seoul.democracy.suggest.vo;

import java.sql.Date;

public class SugComment {
	private int suggestNo;
	private int commentNo;
	private String userId;
	private String commentContent;
	private char heart;
	private Date commentDate;
	
	
	
	
	
	
	
	
	
	public SugComment() {
		super();
		// TODO Auto-generated constructor stub
	}





	public SugComment(int suggestNo, int commentNo, String userId, String commentContent, char heart,
			Date commentDate) {
		super();
		this.suggestNo = suggestNo;
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.heart = heart;
		this.commentDate = commentDate;
	}





	@Override
	public String toString() {
		return "SugComment [suggestNo=" + suggestNo + ", commentNo=" + commentNo + ", userId=" + userId
				+ ", commentContent=" + commentContent + ", heart=" + heart + ", commentDate=" + commentDate + "]";
	}
	
	
	
	
	
	public int getSuggestNo() {
		return suggestNo;
	}
	public void setSuggestNo(int suggestNo) {
		this.suggestNo = suggestNo;
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
	public char getHeart() {
		return heart;
	}
	public void setHeart(char heart) {
		this.heart = heart;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
	
	
	
	
}
