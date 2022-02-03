package kr.go.seoul.democracy.discuss.model.vo;

public class DiscussFile {
	private int discussNo;
	private int discussFileNo;
	private String discussFileName;
	private String discussFilePath;
	
	
	public DiscussFile() {
		super();
	}
	public DiscussFile(int discussNo, int discussFileNo, String discussFileName, String discussFilePath) {
		super();
		this.discussNo = discussNo;
		this.discussFileNo = discussFileNo;
		this.discussFileName = discussFileName;
		this.discussFilePath = discussFilePath;
	}
	
	
	public int getDiscussNo() {
		return discussNo;
	}
	public void setDiscussNo(int discussNo) {
		this.discussNo = discussNo;
	}
	public int getDiscussFileNo() {
		return discussFileNo;
	}
	public void setDiscussFileNo(int discussFileNo) {
		this.discussFileNo = discussFileNo;
	}
	public String getDiscussFileName() {
		return discussFileName;
	}
	public void setDiscussFileName(String discussFileName) {
		this.discussFileName = discussFileName;
	}
	public String getDiscussFilePath() {
		return discussFilePath;
	}
	public void setDiscussFilePath(String discussFilePath) {
		this.discussFilePath = discussFilePath;
	}
}
