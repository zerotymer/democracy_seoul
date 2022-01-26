package kr.go.seoul.democracy.admin.model.vo;

import java.sql.Date;

public class Admin {
    /// FIELDs
    private int adminNo;                                                    // ADMIN_NO
    private String adminId;                                                 // ADMIN_ID
    private String adminPwd;                                                // ADMIN_PWD
    private String adminName;                                               // ADMIN_NAME
    private char adminGrade;                                                // ADMIN_GRADE
    private Date adminDate;                                                 // ADMIN_DATE
    private String adminEmail;                                              // ADMIN_EMAIL
    private String adminDepart;                                             // ADMIN_DEPART

    /// CONSTRUCTORs
    public Admin() {}
    public Admin(int adminNo, String adminId, String adminPwd, String adminName, char adminGrade, Date adminDate, String adminEmail, String adminDepart) {
        this.adminNo = adminNo;
        this.adminId = adminId;
        this.adminPwd = adminPwd;
        this.adminName = adminName;
        this.adminGrade = adminGrade;
        this.adminDate = adminDate;
        this.adminEmail = adminEmail;
        this.adminDepart = adminDepart;
    }

    /// GETTERs
    public int getAdminNo() { return adminNo; }
    public String getAdminId() { return adminId; }
    public String getAdminPwd() { return adminPwd; }
    public String getAdminName() { return adminName; }
    public char getAdminGrade() { return adminGrade; }
    public Date getAdminDate() { return adminDate; }
    public String getAdminEmail() { return adminEmail; }
    public String getAdminDepart() { return adminDepart; }

    /// SETTERs
    public void setAdminNo(int adminNo) { this.adminNo = adminNo; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public void setAdminPwd(String adminPwd) { this.adminPwd = adminPwd; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
    public void setAdminGrade(char adminGrade) { this.adminGrade = adminGrade; }
    public void setAdminDate(Date adminDate) { this.adminDate = adminDate; }
    public void setAdminEmail(String adminEmail) { this.adminEmail = adminEmail; }
    public void setAdminDepart(String adminDepart) { this.adminDepart = adminDepart; }

    /// METHODs
    @Override
    public String toString() {
        return "Admin{" +
                "adminNo=" + adminNo +
                ", adminId='" + adminId + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminGrade=" + adminGrade +
                ", adminDate=" + adminDate +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminDepart='" + adminDepart + '\'' +
                '}';
    }
}
