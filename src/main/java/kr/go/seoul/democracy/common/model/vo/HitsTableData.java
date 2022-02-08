package kr.go.seoul.democracy.common.model.vo;

public class HitsTableData {
    /// FIELDs
    private String tableName;
    private int boardNo;

    /// CONSTRUCTORs
    public HitsTableData(String tableName, int boardNo) {
        this.tableName = tableName;
        this.boardNo = boardNo;
    }

    /// GETTERs
    public String getTableName() { return tableName; }
    public int getBoardNo() { return boardNo; }

    /// SETTERs
    public void setTableName(String tableName) { this.tableName = tableName; }
    public void setBoardNo(int boardNo) { this.boardNo = boardNo; }
}
