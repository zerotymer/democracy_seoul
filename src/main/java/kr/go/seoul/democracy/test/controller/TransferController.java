package kr.go.seoul.democracy.test.controller;

import kr.go.seoul.common.FileTransferTemplate;
import kr.go.seoul.common.transfer.FileTransferInfo;
import kr.go.seoul.democracy.test.model.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TransferController {
    /// FIELDs
    private FileTransferTemplate fileTemplate;

    /// CONSTRUCTORs
    @Autowired
    public TransferController(@Qualifier("fileTransferTemplate") FileTransferTemplate fileTemplate) {
        this.fileTemplate = fileTemplate;
    }

    /// METHODs

    @RequestMapping("/test/upload.do")
    public String testUploadJsp() {
        return "test/upload";
    }
    @RequestMapping("/test/download.do")
    public String testDownloadJsp() {
        return "test/download";
    }


    /**
     * 파일 업로드를 설명하기 위한 예시
     * @param request
     * @return
     * @author 신현진
     */
    @RequestMapping(value = "/test/fileUpload.do", method = RequestMethod.POST)
    public String testUpload(HttpServletRequest request) throws IOException {

//        FileTransferInfo info = fileTemplate.fileTransfer(request, "file", "FOLDER", "test.txt");                         // 파일명을 포함하여 변경(request, 파라미터이름, 이동할 폴더명, 변경할 파일명)
        FileTransferInfo info = fileTemplate.fileTransfer(request, "file", "FOLDER");                                   // 파일명을 자동으로 변경(request, 파라미터이름, 이동할 폴더명)
        // 비즈니스 로직 - 알아서 만드세요.
        
        System.err.println("test transfer");
        System.err.println(info);                                                                                       // 이동한 파일 정보
        return "index";
    }

    /**
     * 파일 다운로드를 설명하기 위한 예시
     * @param response
     * @return
     * @throws IOException
     * @author 신현진
     */
    @RequestMapping(value = "/test/fileDownload.do", method = RequestMethod.GET)
    public String testDownload(HttpServletResponse response) throws IOException {

        // 비즈니스 로직 - 알아서 만드세요.
        
        // 예시
        FileTransferInfo info = new FileTransferInfo(
                "image.jpg",
                "1643865378470",
                "F:\\Workspace\\Github\\democracy_seoul\\src\\main\\webapp\\upload\\FOLDER\\1643865378470",
                299671);
        fileTemplate.fileTransfer(response, info);                                                                      // 전송처리
        return "index";
    }

}
