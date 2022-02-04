package kr.go.seoul.democracy.discuss.model.vo;

import java.sql.Date;

public class DiscussComment {
	private int discussNo;
	private int commentNo;
	private String userId;
	private String commentContent;
	private char commentVote;
	private Date commentDate;

	
	@Override
	public String toString() {
		return "DiscussComment [discussNo=" + discussNo + ", commentNo=" + commentNo + ", userId=" + userId
				+ ", commentContent=" + commentContent + ", commentVote=" + commentVote + ", commentDate=" + commentDate
				+ "]";
	}
	
	
	public DiscussComment() {
		super();
	}
	public DiscussComment(int discussNo, int commentNo, String userId, String commentContent, char commentVote,
			Date commentDate) {
		super();
		this.discussNo = discussNo;
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentVote = commentVote;
		this.commentDate = commentDate;
	}
	
	
	public int getDiscussNo() {
		return discussNo;
	}
	public void setDiscussNo(int discussNo) {
		this.discussNo = discussNo;
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
	public char getCommentVote() {
		return commentVote;
	}
	public void setCommentVote(char commentVote) {
		this.commentVote = commentVote;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
}
