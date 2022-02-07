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

//관리자 테스트용 페이지

@Controller
public class TestController3 {
    /// FIELDs
    private TestService testService;
    private FileTransferTemplate fileTemplate;

    /// CONSTRUCTORs
    @Autowired
    public TestController3(@Qualifier("testServiceImpl") TestService testService,
                          @Qualifier("fileTransferTemplate") FileTransferTemplate fileTemplate) {
        this.testService = testService;
        this.fileTemplate = fileTemplate;
    }

    /// METHODs
    @RequestMapping("/test/admintest.do")
    public String test() {
        return "admin/adminIndex";
    }




}
