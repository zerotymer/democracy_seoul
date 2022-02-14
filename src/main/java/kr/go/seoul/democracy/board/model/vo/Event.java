package kr.go.seoul.democracy.board.model.vo;

import java.sql.Date;

public class Event {
	
	
	private int eventNo;
	private String eventTitle;
    private String eventContent;
    private Date eventDate;
    private char eventDelYN;
    private String eventThumbnailName;
    private String eventThumbnailPath;
    
	public Event() {		// TODO Auto-generated constructor stub
	}

	public Event(int eventNo, String eventTitle, String eventContent, Date eventDate, char eventDelYN,
			String eventThumbnailName, String eventThumbnailPath) {
		super();
		this.eventNo = eventNo;
		this.eventTitle = eventTitle;
		this.eventContent = eventContent;
		this.eventDate = eventDate;
		this.eventDelYN = eventDelYN;
		this.eventThumbnailName = eventThumbnailName;
		this.eventThumbnailPath = eventThumbnailPath;
	}

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
				+ ", eventDate=" + eventDate + ", eventDelYN=" + eventDelYN + ", eventThumbnailName="
				+ eventThumbnailName + ", eventThumbnailPath=" + eventThumbnailPath + "]";
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventContent() {
		return eventContent;
	}

	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public char getEventDelYN() {
		return eventDelYN;
	}

	public void setEventDelYN(char eventDelYN) {
		this.eventDelYN = eventDelYN;
	}

	public String getEventThumbnailName() {
		return eventThumbnailName;
	}

	public void setEventThumbnailName(String eventThumbnailName) {
		this.eventThumbnailName = eventThumbnailName;
	}

	public String getEventThumbnailPath() {
		return eventThumbnailPath;
	}

	public void setEventThumbnailPath(String eventThumbnailPath) {
		this.eventThumbnailPath = eventThumbnailPath;
	}
	
	
	
	
    
    
    

}
