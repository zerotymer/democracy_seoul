package kr.go.democracySeoul.proposal.vo;

import java.sql.Date;

public class Proposal {
	private int proNo;
	private String proTitle;
	private String proContent;
	private Date proDate;
	private Date start;
	private Date end;
	private char proDelYN;
	private String thumbnail;
	private String thumbnail_path;
	
	
	@Override
	public String toString() {
		return "Proposal [proNo=" + proNo + ", proTitle=" + proTitle + ", proContent=" + proContent + ", proDate="
				+ proDate + ", start=" + start + ", end=" + end + ", proDelYN=" + proDelYN + ", thumbnail=" + thumbnail
				+ ", thumbnail_path=" + thumbnail_path + "]";
	}

	public Proposal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proposal(int proNo, String proTitle, String proContent, Date proDate, Date start, Date end, char proDelYN,
			String thumbnail, String thumbnail_path) {
		super();
		this.proNo = proNo;
		this.proTitle = proTitle;
		this.proContent = proContent;
		this.proDate = proDate;
		this.start = start;
		this.end = end;
		this.proDelYN = proDelYN;
		this.thumbnail = thumbnail;
		this.thumbnail_path = thumbnail_path;
	}
	
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getProTitle() {
		return proTitle;
	}
	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}
	public String getProContent() {
		return proContent;
	}
	public void setProContent(String proContent) {
		this.proContent = proContent;
	}
	public Date getProDate() {
		return proDate;
	}
	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public char getProDelYN() {
		return proDelYN;
	}
	public void setProDelYN(char proDelYN) {
		this.proDelYN = proDelYN;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getThumbnail_path() {
		return thumbnail_path;
	}
	public void setThumbnail_path(String thumbnail_path) {
		this.thumbnail_path = thumbnail_path;
	}
	
	
}
