package kr.go.seoul.democracy.common;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import kr.go.seoul.democracy.common.transfer.FileTransferInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.OctetStreamData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 파일 전송을 지원하기 위한 클래스
 */
public class FileTransferTemplate {
    /// FIELDs
    private final String ENCODING;
    private final int FILE_SIZE_LIMIT;
    private final String UPLOAD_ROOT_DIR;
    private final String UPLOAD_TEMP_DIR;

    /// CONSTRUCTORs
    public FileTransferTemplate(ServletContext servletContext,
                                int uploadFileSizeLimit,
                                String encoding,
                                String uploadTemporaryDir) {
        this.FILE_SIZE_LIMIT = uploadFileSizeLimit;
        this.ENCODING = encoding;
        this.UPLOAD_ROOT_DIR = servletContext.getRealPath("/upload");
        this.UPLOAD_TEMP_DIR = servletContext.getRealPath("/upload") + '\\' + uploadTemporaryDir + '\\';

        System.err.println(String.format("Info: FileTransferTemplate have set temporary path for upload(%s)", UPLOAD_TEMP_DIR));
    }

    /// METHODs

    /**
     * 파일을 이동합니다.
     * @param request 웹요청
     * @param fileParameterName 파라미터명('file')
     * @param targetDir 이동할 디렉토리
     * @param targetFilename 이동할 파일명
     * @return 이동된 파일 정보
     * @throws IOException
     * @author 신현진
     */
    public FileTransferInfo fileTransfer(HttpServletRequest request,
                                         String fileParameterName,
                                         String targetDir,
                                         String targetFilename) throws IOException {
        MultipartRequest multiRequest = new MultipartRequest(
                request, UPLOAD_TEMP_DIR, FILE_SIZE_LIMIT, ENCODING, new DefaultFileRenamePolicy());
        FileTransferInfo file = new FileTransferInfo(fileParameterName);                                                // TODO: CHECK 동시저장 이슈
        file.moveTo(UPLOAD_ROOT_DIR + '\\' + targetDir, targetFilename);
        return file;
    }

    /**
     * 파일을 이동합니다. (파일명은 miliseconds 로 생성)
     * @param request 웹요청
     * @param fileParameterName 파라미터명('file')
     * @param targetDir 이동할 디렉토리
     * @return 이동된 파일 정보
     * @throws IOException
     * @author 신현진
     */
    public FileTransferInfo fileTransfer(HttpServletRequest request,
                                         String fileParameterName,
                                         String targetDir) throws IOException {
        long currentTime = System.currentTimeMillis();
        MultipartRequest multiRequest = new MultipartRequest(
                request, UPLOAD_TEMP_DIR, FILE_SIZE_LIMIT, ENCODING, new DefaultFileRenamePolicy());
        FileTransferInfo file = new FileTransferInfo(fileParameterName);                                                // TODO: CHECK 동시저장 이슈
        file.moveTo(UPLOAD_ROOT_DIR + '\\' + targetDir, String.valueOf(currentTime));
        return file;
    }


    /**
     * 파일을 전송합니다.(다운로드)
     * @param response 웹응답
     * @param fileInfo 파일정보
     * @throws IOException
     * @author 신현진
     */
    public void fileTransfer(HttpServletResponse response,
                             FileTransferInfo fileInfo) throws IOException {
        File file = new File(fileInfo.getAbsolutePath());
//        String encodingName = fileInfo.getOriginalFileName(StandardCharsets.ISO_8859_1);
        String encodingName = fileInfo.getOriginalFileName("ISO_8859_1");

        // Response 설정
//        response.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        response.setContentType("application/octet-stream");                                                            // 문서 설정
        response.setHeader("Content-Disposition", "attachment;filename=" + encodingName);                               // 첨부파일 설정
        response.setContentLength((int)file.length());

        // 파일 스트림 생성
        FileInputStream fin = new FileInputStream(file);
        ServletOutputStream sout = response.getOutputStream();

        FileCopyUtils.copy(fin, sout);
        fin.close();
        sout.flush();
        sout.close();
    }

}
