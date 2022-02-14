package kr.go.seoul.democracy.board.model.vo;

import java.sql.Date;

public class EventFile {
	
	private int eventNo;
	private int eventFileNo;
	private String eventFileName;
    private String eventFilePath;
	
    public EventFile() {
		
	}

	public EventFile(int eventNo, int eventFileNo, String eventFileName, String eventFilePath) {
		super();
		this.eventNo = eventNo;
		this.eventFileNo = eventFileNo;
		this.eventFileName = eventFileName;
		this.eventFilePath = eventFilePath;
	}

	@Override
	public String toString() {
		return "EventFile [eventNo=" + eventNo + ", eventFileNo=" + eventFileNo + ", eventFileName=" + eventFileName
				+ ", eventFilePath=" + eventFilePath + "]";
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public int getEventFileNo() {
		return eventFileNo;
	}

	public void setEventFileNo(int eventFileNo) {
		this.eventFileNo = eventFileNo;
	}

	public String getEventFileName() {
		return eventFileName;
	}

	public void setEventFileName(String eventFileName) {
		this.eventFileName = eventFileName;
	}

	public String getEventFilePath() {
		return eventFilePath;
	}

	public void setEventFilePath(String eventFilePath) {
		this.eventFilePath = eventFilePath;
	}
    
    
    
    


}
