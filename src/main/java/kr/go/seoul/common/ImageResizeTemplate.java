package kr.go.seoul.common;

import javax.servlet.ServletContext;

import kr.go.seoul.common.model.vo.ImageSize;

import java.util.HashMap;

/**
 * 이미지를 자동으로 사이즈를 조정하는 템플릿
 */
public class ImageResizeTemplate extends FileTransferTemplate {
    /// FIELDs
    private final HashMap<String, ImageSize> imageSizes;

    /// CONSTRUCTORs

    /**
     * ImageResizeTemplate 인스턴스를 생성합니다.
     * @param servletContext 서블릿 컨텍스트(매핑)
     * @param uploadFileSizeLimit 업로드 파일 사이즈 제한
     * @param encoding 인코딩
     * @param uploadTemporaryDir 업로드 임시 폴더
     * @param imageSizes 이미지 사이즈 목록
     */
    public ImageResizeTemplate(ServletContext servletContext,
                               int uploadFileSizeLimit,
                               String encoding,
                               String uploadTemporaryDir,
                               HashMap<String, ImageSize> imageSizes) {
        super(servletContext, uploadFileSizeLimit, encoding, uploadTemporaryDir);
        this.imageSizes = imageSizes;
    }

    /// METHODs


}
