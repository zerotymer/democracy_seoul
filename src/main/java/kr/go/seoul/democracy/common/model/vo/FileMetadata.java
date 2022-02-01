package kr.go.seoul.democracy.common.model.vo;

public class FileMetadata {
    /// FIELDs
    private String originalFileName;
    private String fileName;
    private String fileAbsolutePath;
    private long fileSize;

    /// CONSTRUCOTRs
    public FileMetadata() {}
    public FileMetadata(String originalFileName, String fileName, String fileAbsolutePath, long fileSize) {
        this.originalFileName = originalFileName;
        this.fileName = fileName;
        this.fileAbsolutePath = fileAbsolutePath;
        this.fileSize = fileSize;
    }

    /// GETTERs
    public String getOriginalFileName() { return originalFileName; }
    public String getFileName() { return fileName; }
    public String getFileAbsolutePath() { return fileAbsolutePath; }
    public long getFileSize() { return fileSize; }

    /// SETTERs
    public void setOriginalFileName(String originalFileName) { this.originalFileName = originalFileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setFileAbsolutePath(String fileAbsolutePath) { this.fileAbsolutePath = fileAbsolutePath; }
    public void setFileSize(long fileSize) { this.fileSize = fileSize; }
}
