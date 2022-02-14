package kr.go.seoul.democracy.suggest2.model.vo;

import java.sql.Date;

public class Suggest {
    /// FIELDs
    private int suggestNo;
    private String suggestTitle;
    private String userId;
    private String suggestContent;
    private Date suggestDate;
    private Date suggestStart;
    private Date suggestEnd;
    private char suggestDelYN;
    private int suggestGory;
    private int suggestLocal;

    /// CONSTRUCTORs
    public Suggest() {
        this.suggestNo = 0;
        this.suggestTitle = "";
        this.suggestContent = "";
        this.suggestGory = 1;
        this.suggestLocal = 1;
    }

    public Suggest(int suggestNo, String suggestTitle, String userId, String suggestContent, Date suggestDate, Date suggestStart, Date suggestEnd, char suggestDelYN, int suggestGory, int suggestLocal) {
        this.suggestNo = suggestNo;
        this.suggestTitle = suggestTitle;
        this.userId = userId;
        this.suggestContent = suggestContent;
        this.suggestDate = suggestDate;
        this.suggestStart = suggestStart;
        this.suggestEnd = suggestEnd;
        this.suggestDelYN = suggestDelYN;
        this.suggestGory = suggestGory;
        this.suggestLocal = suggestLocal;
    }

    /// GETTERs
    public int getSuggestNo() { return suggestNo; }
    public String getSuggestTitle() { return suggestTitle; }
    public String getUserId() { return userId; }
    public String getSuggestContent() { return suggestContent; }
    public Date getSuggestDate() { return suggestDate; }
    public Date getSuggestStart() { return suggestStart; }
    public Date getSuggestEnd() { return suggestEnd; }
    public char getSuggestDelYN() { return suggestDelYN; }
    public int getSuggestGory() { return suggestGory; }
    public int getSuggestLocal() { return suggestLocal; }

    /// SETTERs
    public void setSuggestNo(int suggestNo) { this.suggestNo = suggestNo; }
    public void setSuggestTitle(String suggestTitle) { this.suggestTitle = suggestTitle; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setSuggestContent(String suggestContent) { this.suggestContent = suggestContent; }
    public void setSuggestDate(Date suggestDate) { this.suggestDate = suggestDate; }
    public void setSuggestStart(Date suggestStart) { this.suggestStart = suggestStart; }
    public void setSuggestEnd(Date suggestEnd) { this.suggestEnd = suggestEnd; }
    public void setSuggestDelYN(char suggestDelYN) { this.suggestDelYN = suggestDelYN; }
    public void setSuggestGory(int suggestGory) { this.suggestGory = suggestGory; }
    public void setSuggestLocal(int suggestLocal) { this.suggestLocal = suggestLocal; }

    @Override
    public String toString() {
        return "Suggest{" +
                "suggestNo=" + suggestNo +
                ", suggestTitle='" + suggestTitle + '\'' +
                ", userId='" + userId + '\'' +
                ", suggestContent='" + suggestContent + '\'' +
                ", suggestDate=" + suggestDate +
                ", suggestStart=" + suggestStart +
                ", suggestEnd=" + suggestEnd +
                ", suggestDelYN=" + suggestDelYN +
                ", suggestGory=" + suggestGory +
                ", suggestLocal=" + suggestLocal +
                '}';
    }
}
