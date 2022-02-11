package kr.go.seoul.democracy.board.model.vo;

import java.sql.Date;

public class BoardNotice {
		
		private int noticeNewsNo;
		private String noticeNewsTitle;
	    private String noticeNewsContent;
	    private Date noticeNewsDate;
	    private char noticeNewsDelYN;
	    //private String noticeNewsThumbnailName;
	    //private String noticeNewsThumbnailPath;
	    
		public BoardNotice() {}
		
		public BoardNotice(int noticeNewsNo, String noticeNewsTitle, String noticeNewsContent, Date noticeNewsDate,
				char noticeNewsDelYN) {
			super();
			this.noticeNewsNo = noticeNewsNo;
			this.noticeNewsTitle = noticeNewsTitle;
			this.noticeNewsContent = noticeNewsContent;
			this.noticeNewsDate = noticeNewsDate;
			this.noticeNewsDelYN = noticeNewsDelYN;
		}
		
		@Override
		public String toString() {
			return "Board [noticeNewsNo=" + noticeNewsNo + ", noticeNewsTitle=" + noticeNewsTitle
					+ ", noticeNewsContent=" + noticeNewsContent + ", noticeNewsDate=" + noticeNewsDate
					+ ", noticeNewsDelYN=" + noticeNewsDelYN + "]";
		}

		public int getNoticeNewsNo() {
			return noticeNewsNo;
		}

		public void setNoticeNewsNo(int noticeNewsNo) {
			this.noticeNewsNo = noticeNewsNo;
		}

		public String getNoticeNewsTitle() {
			return noticeNewsTitle;
		}

		public void setNoticeNewsTitle(String noticeNewsTitle) {
			this.noticeNewsTitle = noticeNewsTitle;
		}

		public String getNoticeNewsContent() {
			return noticeNewsContent;
		}

		public void setNoticeNewsContent(String noticeNewsContent) {
			this.noticeNewsContent = noticeNewsContent;
		}

		public Date getNoticeNewsDate() {
			return noticeNewsDate;
		}

		public void setNoticeNewsDate(Date noticeNewsDate) {
			this.noticeNewsDate = noticeNewsDate;
		}

		public char getNoticeNewsDelYN() {
			return noticeNewsDelYN;
		}

		public void setNoticeNewsDelYN(char noticeNewsDelYN) {
			this.noticeNewsDelYN = noticeNewsDelYN;
		}

	

}
