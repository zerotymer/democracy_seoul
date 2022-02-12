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
    //글의 리스트를 보는 게시판
    @RequestMapping("/suggest/suggest.do")
    public String sug() {
        return "suggest/sugBoard";
    }
    //글을 작성하는곳
    @RequestMapping("/suggest/suggestwrite.do")
    public String sug1() {
        return "suggest/sugWrite";
    }
    // 작성한 글을 볼수있는곳
    @RequestMapping("/suggest/suggestview.do")
    public String sug2() {
        return "suggest/sugView";
    } 
    // 테스트
    @RequestMapping("/suggest/suggestest.do")
    public String sug3() {
        return "suggest/sugTest";
    }
    
	/*
	 * @RequestMapping("/member.do") public String member() { Member m = new
	 * Member(); m.setUserId("1234"); m.setUserPwd("1234");
	 * mService.selectLoginMember(m); return "index"; }
	 */

}

