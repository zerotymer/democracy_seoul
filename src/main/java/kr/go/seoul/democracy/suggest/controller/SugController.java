package kr.go.seoul.democracy.suggest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.go.seoul.common.FileTransferTemplate;
import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.service.MemberService;

import kr.go.seoul.democracy.suggest.service.SugService;


@Controller("sugController")
public class SugController {
    /// FIELDs
    private SugService sugService;
    private FileTransferTemplate fileTemplate;
    private MemberService mService;

    /// CONSTRUCTORs
    @Autowired
    public SugController(@Qualifier("SugServiceImpl") SugService sugService,
                          @Qualifier("fileTransferTemplate") FileTransferTemplate fileTemplate,
                         @Qualifier("memberServiceImpl") MemberService mService) 
    {
        this.sugService = sugService;
        this.fileTemplate = fileTemplate;
        this.mService = mService;
    }
	 /// METHODs
    @RequestMapping("/test.do")
    public String test() {
    	System.out.println("TestController - test() start");
        System.out.println(sugService.selectSysdate());
        System.out.println("TestController - test() end");
        return "index";
    }

    @RequestMapping("/suggest.do")
    public String sug() {
        return "suggest/sugBoard";
    }

    @RequestMapping("/test/member.do")
    public String test7() {
    	Member m = new Member();
    	m.setUserId("1234");
    	m.setUserPwd("1234");
    	mService.selectLoginMember(m);
    	return "index";
    }


}

