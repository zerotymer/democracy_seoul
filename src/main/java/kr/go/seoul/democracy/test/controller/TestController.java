package kr.go.seoul.democracy.test.controller;

import kr.go.seoul.common.FileTransferTemplate;
import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.service.MemberService;
import kr.go.seoul.democracy.test.model.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller("testController")
public class TestController {
    /// FIELDs
    private TestService testService;
    private FileTransferTemplate fileTemplate;
    private MemberService mService;

    /// CONSTRUCTORs
    @Autowired
    public TestController(@Qualifier("testServiceImpl") TestService testService,
                          @Qualifier("fileTransferTemplate") FileTransferTemplate fileTemplate,
                          @Qualifier("memberServiceImpl") MemberService mService) {
        this.testService = testService;
        this.fileTemplate = fileTemplate;
        this.mService = mService;
    }

    /// METHODs
    @RequestMapping("/test.do")
    public String test() {
    	System.out.println("TestController - test() start");
        System.out.println(testService.selectSysdate());
        System.out.println("TestController - test() end");
        return "index";
    }
    @RequestMapping("/test/content.do")
    public String test2() {
        return "test/content-frame";
    }
    @RequestMapping("/test/content-list.do")
    public String test3() {
        return "test/content-list";
    }
    @RequestMapping("/test/suggest.do")
    public String test4() {
        return "test/list-suggest";
    }
    @RequestMapping("/test/discuss.do")
    public String test5() {
        return "test/list-discuss";
    }
    @RequestMapping("/test/survey.do")
    public String test6() {
        return "test/list-survey";
    }
    @RequestMapping("/test/member.do")
    public String test7() {
    	Member m = new Member();
    	m.setUserId("1234");
    	m.setUserPwd("1234");
    	mService.selectLoginMember(m);
    	return "index";
    }
    @RequestMapping("/test/hashmap.do")
    public String hashMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", "1111");
        map.put("userid", "1111");
        map.put("userPwd", "1111");
        testService.hashmapTest(map);
        return "index";
    }
    @RequestMapping("/ckeditor.do")
    public String ckeditor() {
    	return "test/ckeditor";
    }
}
