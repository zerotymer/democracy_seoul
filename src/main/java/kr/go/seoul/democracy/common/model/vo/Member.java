package kr.go.seoul.democracy.common.model.vo;

import java.sql.Date;

public class Member {
    /// FILEDs
    private String userId;                                  // USERID
    private String userPwd;                                 // USERPWD
    private String userName;                                // USERNAME
    private String nick;                                    // NICK
    private String email;                                   // EMAIL
    private Date enrollDate;                                // ENROLLDATE
    private char endYN;                                     // END_YN
    private char userGrade;                                 // USERGRADE

    /// CONSTRUCTORs
    public Member() {}
    public Member(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }
    public Member(String userId, String userPwd, String userName, String nick, String email) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.nick = nick;
        this.email = email;
    }
    public Member(String userId, String userPwd, String userName, String nick, String email, Date enrollDate, char endYN, char userGrade) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.nick = nick;
        this.email = email;
        this.enrollDate = enrollDate;
        this.endYN = endYN;
        this.userGrade = userGrade;
    }

    /// GETTERs
    public String getUserId() { return userId; }
    public String getUserPwd() { return userPwd; }
    public String getUserName() { return userName; }
    public String getNick() { return nick; }
    public String getEmail() { return email; }
    public Date getEnrollDate() { return enrollDate; }
    public char getEndYN() { return endYN; }
    public char getUserGrade() { return userGrade; }

    /// SETTERs
    public void setUserId(String userId) { this.userId = userId; }
    public void setUserPwd(String userPwd) { this.userPwd = userPwd; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setNick(String nick) { this.nick = nick; }
    public void setEmail(String email) { this.email = email; }
    public void setEnrollDate(Date enrollDate) { this.enrollDate = enrollDate; }
    public void setEndYN(char endYN) { this.endYN = endYN; }
    public void setUserGrade(char userGrade) { this.userGrade = userGrade; }

    /// METHODs

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", enrollDate=" + enrollDate +
                ", endYN=" + endYN +
                ", userGrade=" + userGrade +
                '}';
    }
}
