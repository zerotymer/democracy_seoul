package kr.go.seoul.common;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import kr.go.seoul.common.model.vo.ImageSize;
import kr.go.seoul.common.transfer.FileTransferInfo;
import kr.go.seoul.common.transfer.ImageTransferInfo;

import java.io.IOException;
import java.util.HashMap;

/**
 * 이미지를 자동으로 사이즈를 조정하는 템플릿
 */
public class ImageResizeTemplate extends FileTransferTemplate {
    /// FIELDs
    private final HashMap<String, ImageSize> imageSizes;
    private final ImageSize max;

    /// CONSTRUCTORs

    /**
     * ImageResizeTemplate 인스턴스를 생성합니다.
     *
     * @param servletContext      서블릿 컨텍스트(매핑)
     * @param uploadFileSizeLimit 업로드 파일 사이즈 제한
     * @param encoding            인코딩
     * @param uploadTemporaryDir  업로드 임시 폴더
     * @param max                 이미지 최대 크기. (0: 제한없음)
     * @param imageSizes          이미지 사이즈 목록
     */
    public ImageResizeTemplate(ServletContext servletContext,
                               int uploadFileSizeLimit,
                               String encoding,
                               String uploadTemporaryDir,
                               ImageSize max,
                               HashMap<String, ImageSize> imageSizes) {
        super(servletContext, uploadFileSizeLimit, encoding, uploadTemporaryDir);
        this.max = max;
        this.imageSizes = imageSizes;
    }

    /// METHODs

    /**
     * 이미지를 전송받아 이동합니다.
     *
     * @param request           웹요청
     * @param fileParameterName 파라미터명('file')
     * @param targetDir         이동할 디렉토리
     * @param targetFilename    이동할 파일명(확장자 제외)
     * @return
     * @throws IOException
     */
    @Override
    public FileTransferInfo fileTransfer(HttpServletRequest request,
                                         String fileParameterName,
                                         String targetDir,
                                         String targetFilename) throws IOException {
        MultipartRequest multiRequest = new MultipartRequest(
                request, UPLOAD_TEMP_DIR, FILE_SIZE_LIMIT, ENCODING, new DefaultFileRenamePolicy());
        String originalFileName = multiRequest.getFilesystemName(fileParameterName);

        ImageTransferInfo info = new ImageTransferInfo(this.UPLOAD_TEMP_DIR, originalFileName, max);
        info.setImageSizes(imageSizes);
        info.resizeMoveToAll(UPLOAD_ROOT_DIR + '\\' + targetDir, targetFilename);
        return info;
    }

    /**
     * 이미지를 전송받아 이동합니다. 파일명은 임의(time)로 생성됩니다.
     *
     * @param request           웹요청
     * @param fileParameterName 파라미터명('file')
     * @param targetDir         이동할 디렉토리
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
        String originalFileName = multiRequest.getFilesystemName(fileParameterName);

        ImageTransferInfo info = new ImageTransferInfo(this.UPLOAD_TEMP_DIR, originalFileName, max);
        info.setImageSizes(imageSizes);
        info.resizeMoveToAll(UPLOAD_ROOT_DIR + '\\' + targetDir, String.valueOf(currentTime));
        return info;
    }
}

