package kr.go.seoul.democracy.test.controller;

import kr.go.seoul.democracy.test.model.service.TestService;
import kr.go.seoul.democracy.test.model.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("testController2")
public class TestController2 {
    /// FIELDs
    private TestService testService;

    /// CONSTRUCTORs
    @Autowired
    public TestController2(@Qualifier("testServiceImpl") TestServiceImpl testService) {
        this.testService = testService;
    }

    /// METHODs
    @RequestMapping("/dw.do")
    public String test() {
        return "proposal/proposalWrite";
    }
    
    @RequestMapping("/dw1.do")
    public String test1() {
    	System.err.println("test");
        System.err.println(testService.selectSysdate());
        System.err.println("test");
        return "test/test1";
    }
    
    @RequestMapping("/dw2.do")
    public String test2() {
    	
        return "proposal/proposalAllList";
    }
}
