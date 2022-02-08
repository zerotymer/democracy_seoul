package kr.go.seoul.democracy.suggest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.go.seoul.democracy.suggest.service.SugService;


@Controller
public class SugController {
    /// FIELDs
    private SugService sugService;

    /// CONSTRUCTORs
    @Autowired
    public SugController(@Qualifier("sugServiceImpl") SugService sugService) {
        this.sugService = sugService;
    }
	
	/*
	 * /// METHODs
	 * 
	 * @RequestMapping("/sug.do") public String test() {
	 * System.out.println("SugController - sug() start");
	 * System.out.println(sugService.selectSysdate());
	 * System.out.println("SugController - sug() end"); return "index"; }
	 */

    @RequestMapping("/suggest.do")
    public String sug() {
        return "suggest/sugBoard";
    }
	/*
	 * @RequestMapping("/member.do") public String member() { Member m = new
	 * Member(); m.setUserId("1234"); m.setUserPwd("1234");
	 * mService.selectLoginMember(m); return "index"; }
	 */

}

