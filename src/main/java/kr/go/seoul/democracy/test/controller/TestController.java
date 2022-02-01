package kr.go.seoul.democracy.test.controller;

import kr.go.seoul.democracy.test.model.service.TestService;
import kr.go.seoul.democracy.test.model.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("testController")
public class TestController {
    /// FIELDs
    private TestService testService;

    /// CONSTRUCTORs
    @Autowired
    public TestController(@Qualifier("testServiceImpl") TestServiceImpl testService) {
        this.testService = testService;
    }

    /// METHODs
    @RequestMapping("/test.do")
    public String test() {
    	System.err.println("test");
        System.err.println(testService.selectSysdate());
        System.err.println("test");
        return "index";
    }
    
    @RequestMapping("/test1.do")
    public String test1() {
        return "test/test1";
    }

    @RequestMapping("/test/content.do")
    public String test2() {
        return "test/content-frame";
    }
}
