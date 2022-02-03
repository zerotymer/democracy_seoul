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



}
