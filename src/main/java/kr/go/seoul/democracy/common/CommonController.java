package kr.go.seoul.democracy.common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kr.go.seoul.common.FileTransferTemplate;
import kr.go.seoul.common.ImageResizeTemplate;
import kr.go.seoul.common.transfer.ImageTransferInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CommonController {
    /// FIELDs
    private FileTransferTemplate fileTemplate;
    private ImageResizeTemplate imgTemplate;

    /// CONSTRUCTORs
    @Autowired
    public CommonController(@Qualifier("fileTransferTemplate") FileTransferTemplate fileTemplate,
                              @Qualifier("basicImageTemplate") ImageResizeTemplate imgTemplate) {
        this.fileTemplate = fileTemplate;
        this.imgTemplate = imgTemplate;
    }

    /**
     * CKEditor 이미지 업로드를 위한 메서드
     * @param request
     * @param response
     * @throws IOException
     * @author 신현진
     */
    @RequestMapping("/ckeditor/imgUpload.do")
    public void imgUpload(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "upload", "ckeditor");           // 자동 이름 생성

        JsonObject json = new JsonObject();
        json.addProperty("url", "/upload/ckeditor/" + info.getFileName());                                              // 이미지 url 경로 반환
        json.addProperty("uploaded", 1);                                                                                // 업로드한 파일 갯수
        json.addProperty("fileName", info.getOriginalFileName());                                                       // 원본파일이름
        new Gson().toJson(json, response.getWriter());
    }
}
