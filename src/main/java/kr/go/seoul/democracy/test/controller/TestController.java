package kr.go.seoul.democracy.test.controller;

import kr.go.seoul.common.FileTransferTemplate;
import kr.go.seoul.common.transfer.FileTransferInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.go.seoul.democracy.test.model.service.TestService;
import kr.go.seoul.democracy.test.model.service.TestServiceImpl;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("testController")
public class TestController {
    /// FIELDs
    private TestService testService;
    private FileTransferTemplate fileTemplate;

    /// CONSTRUCTORs
    @Autowired
    public TestController(@Qualifier("testServiceImpl") TestServiceImpl testService,
                          @Qualifier("fileTransferTemplate") FileTransferTemplate fileTemplate) {
        this.testService = testService;
        this.fileTemplate = fileTemplate;
    }

    /// METHODs
    @RequestMapping("/test.do")
    public String test() {
        System.err.println(testService.selectSysdate());
        return "index";
    }

    @RequestMapping("/test/content.do")
    public String test2() {
        return "test/content-frame";
    }


    /**
     * 파일 업로드를 설명하기 위한 예시
     * @param request
     * @return
     * @author 신현진
     */
    @RequestMapping(value = "/test/fileUpload.do", method = RequestMethod.POST)
    public String testUpload(HttpServletRequest request) throws IOException {

//        FileTransferInfo info = fileTemplate.fileTransfer(request, "file", "USERID", "test");                         // 파일명을 포함하여 변경(request, 파라미터이름, 이동할 폴더명, 변경할 파일명)
        FileTransferInfo info = fileTemplate.fileTransfer(request, "file", "USERID");                                   // 파일명을 자동으로 변경(request, 파라미터이름, 이동할 폴더명)

        System.out.println("test transfer");
        System.out.println(info);
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


        FileTransferInfo info = new FileTransferInfo("원본파일명", "바뀐파일명", "파일경로", 0);                            // 데이터 연결. 0: 파일크기
        fileTemplate.fileTransfer(response, info);                                                                      // 전송처리
        return "index";
    }

}
