package kr.go.seoul.common.transfer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;

/**
 * 파일 전송을 지원하는 파일 클래스
 * @author 신현진
 */
public class FileTransferInfo {
    /// FIELDs
    protected final String originalFileName;                                                                            // 원본 파일명
    protected String fileName;                                                                                          // 파일명
    protected String absolutePath;                                                                                      // 파일 전체경로
    protected long fileSize;                                                                                            // 파일 크기

    /// CONSTRUCTORs
    /**
     * FileTransferInfo를 생성하기 위한 생성자
     * @param filePath 파일 전체 경로
     */
    public FileTransferInfo(String path, String fileName) {
        this.fileName = fileName;
        this.originalFileName = fileName;
        this.absolutePath = path + '\\' + fileName;
        this.fileSize = FileTransferInfo.getFileSize(absolutePath);
    }

    /**
     * FileTransferInof를 생성하기 위한 생성자
     * @param originalFileName 원본 파일 명
     * @param fileName 파일명
     * @param absolutePath 파일 전체경로
     * @param fileSize 파일 크기
     */
    public FileTransferInfo(String originalFileName, String fileName, String absolutePath, long fileSize) {
        this.originalFileName = originalFileName;
        this.fileName = fileName;
        this.absolutePath = absolutePath;
        this.fileSize = fileSize;
    }

    /// GETTERs
    public String getOriginalFileName() { return originalFileName; }
    public String getFileName() { return fileName; }
    public String getAbsolutePath() { return absolutePath; }
    public long getFileSize() { return fileSize; }

    public String getOriginalFileName(Charset charset) throws UnsupportedEncodingException {
        return new String(originalFileName.getBytes(), charset);
    }
    public String getOriginalFileName(String charset) throws UnsupportedEncodingException {
        return new String(originalFileName.getBytes(), charset);
    }

    /// SETTERs
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setAbsolutePath(String absolutePath) { this.absolutePath = absolutePath; }
    public void setFileSize(long fileSize) { this.fileSize = fileSize; }

    /// METHODs
    /**
     * 파일의 크기를 구하기는 메서드
     * @param filePath 파일 경로
     * @return 파일크기
     * @author 신현진
     */
    public static long getFileSize(String filePath) {
        File file = new File(filePath);
        return file.exists() ? file.length() : 0;
    }

    /**
     * 파일 존재를 확인하는 메서드
     * @return 파일 존재 여부
     * @author 신현진
     */
    public boolean isExist() {
        if (absolutePath.equals("")) return false;

        File file = new File(this.absolutePath);
        return file.exists();
    }

    /**
     * 파일을 이동하는 메서드
     * @param targetDir 이동할 디렉토리
     * @param filename 변경할 파일명 - 확장자 포함
     * @return 이동된 현재 파일(Channing)
     * @throws IOException
     * @author 신현진
     */
    public FileTransferInfo moveTo(String targetDir, String filename) throws IOException {
        File originFile = new File(absolutePath);
        if (!originFile.exists()) throw new FileNotFoundException(absolutePath);                                        // 기존 파일이 없을 경우 예외

        File newFile = new File(targetDir + '\\' + filename);
        if (newFile.exists()) throw new FileAlreadyExistsException(targetDir + '\\' + filename);                        // 중복 파일이 존재할 경우 예외

        File dir = new File(targetDir);
        if (!dir.exists()) dir.mkdirs();                                                                                // 디렉토리가 없을 경우 디렉토리 생성

        originFile.renameTo(newFile);
        this.fileName = filename;
        this.absolutePath = targetDir + '\\' + filename;
        return this;
    }


    ///

    @Override
    public String toString() {
        return "FileTransferInfo{" +
                "원본 파일명='" + originalFileName + '\'' +
                ", 파일이름='" + fileName + '\'' +
                ", 파일전체경로='" + absolutePath + '\'' +
                ", 파일크기=" + fileSize +
                '}';
    }
}
