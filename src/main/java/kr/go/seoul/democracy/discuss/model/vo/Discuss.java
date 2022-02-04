package kr.go.seoul.democracy.discuss.model.vo;

import java.sql.Date;

public class Discuss {
	private int discussNo;
	private String discussTitle;
    private String userId;
    private String discussContent;
    private Date discussDate;
    private Date discussStart;
    private Date discussEnd;
    private char discussDelYN;
    private String discussThumbnailName;
    private String discussThumbnailPath;
    
    
	@Override
	public String toString() {
		return "Discuss [discussNo=" + discussNo + ", discussTitle=" + discussTitle + ", userId=" + userId
				+ ", discussContent=" + discussContent + ", discussDate=" + discussDate + ", discussStart="
				+ discussStart + ", discussEnd=" + discussEnd + ", discussDelYN=" + discussDelYN
				+ ", discussThumbnailName=" + discussThumbnailName + ", discussThumbnailPath=" + discussThumbnailPath
				+ "]";
	}
	
	
	public Discuss() {
		super();
	}
	public Discuss(int discussNo, String discussTitle, String userId, String discussContent, Date discussDate,
			Date discussStart, Date discussEnd, char discussDelYN, String discussThumbnailName,
			String discussThumbnailPath) {
		super();
		this.discussNo = discussNo;
		this.discussTitle = discussTitle;
		this.userId = userId;
		this.discussContent = discussContent;
		this.discussDate = discussDate;
		this.discussStart = discussStart;
		this.discussEnd = discussEnd;
		this.discussDelYN = discussDelYN;
		this.discussThumbnailName = discussThumbnailName;
		this.discussThumbnailPath = discussThumbnailPath;
	}


	public int getDiscussNo() {
		return discussNo;
	}
	public void setDiscussNo(int discussNo) {
		this.discussNo = discussNo;
	}
	public String getDiscussTitle() {
		return discussTitle;
	}
	public void setDiscussTitle(String discussTitle) {
		this.discussTitle = discussTitle;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDiscussContent() {
		return discussContent;
	}
	public void setDiscussContent(String discussContent) {
		this.discussContent = discussContent;
	}
	public Date getDiscussDate() {
		return discussDate;
	}
	public void setDiscussDate(Date discussDate) {
		this.discussDate = discussDate;
	}
	public Date getDiscussStart() {
		return discussStart;
	}
	public void setDiscussStart(Date discussStart) {
		this.discussStart = discussStart;
	}
	public Date getDiscussEnd() {
		return discussEnd;
	}
	public void setDiscussEnd(Date discussEnd) {
		this.discussEnd = discussEnd;
	}
	public char getDiscussDelYN() {
		return discussDelYN;
	}
	public void setDiscussDelYN(char discussDelYN) {
		this.discussDelYN = discussDelYN;
	}
	public String getDiscussThumbnailName() {
		return discussThumbnailName;
	}
	public void setDiscussThumbnailName(String discussThumbnailName) {
		this.discussThumbnailName = discussThumbnailName;
	}
	public String getDiscussThumbnailPath() {
		return discussThumbnailPath;
	}
	public void setDiscussThumbnailPath(String discussThumbnailPath) {
		this.discussThumbnailPath = discussThumbnailPath;
	}
}
