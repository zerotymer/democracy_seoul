package kr.go.seoul.democracy.adminNotice.model.vo;

import java.sql.Date;

public class AdminNotice {
	
	
	/// FIELDs
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private char noticeDelYN;
	private String noticeThumbnailName;
	private String noticeThumbnailPath;
	
	/// CONSTRUCTORs
	public AdminNotice() 
	{	super();	}
	public AdminNotice(int noticeNo, String noticeTitle, String noticeContent, Date noticeDate, char noticeDelYN,
			String noticeThumbnailName, String noticeThumbnailPath) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeDelYN = noticeDelYN;
		this.noticeThumbnailName = noticeThumbnailName;
		this.noticeThumbnailPath = noticeThumbnailPath;
	}
	
	
	/// GETTERs + SETTERs
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public char getNoticeDelYN() {
		return noticeDelYN;
	}
	public void setNoticeDelYN(char delYN) {
		this.noticeDelYN = delYN;
	}
	public String getNoticeThumbnailName() {
		return noticeThumbnailName;
	}
	public void setNoticeThumbnailName(String noticeThumbnailName) {
		this.noticeThumbnailName = noticeThumbnailName;
	}
	public String getNoticeThumbnailPath() {
		return noticeThumbnailPath;
	}
	public void setNoticeThumbnailPath(String noticeThumbnailPath) {
		this.noticeThumbnailPath = noticeThumbnailPath;
	}
	
	
	/// METHODs
	@Override
	public String toString() {
		return "AdminNotice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeDate=" + noticeDate + ", noticeDelYN=" + noticeDelYN + ", noticeThumbnailName=" + noticeThumbnailName
				+ ", noticeThumbnailPath=" + noticeThumbnailPath + "]";
	}
	

}
