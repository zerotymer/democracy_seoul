package kr.go.seoul.democracy.suggest.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.suggest.service.SugService;
import kr.go.seoul.democracy.suggest.vo.Sug;


@Controller
public class SugController {

	//log
	private static final Logger log = LoggerFactory.getLogger(SugController.class);
	
	@Autowired
	@Qualifier("sugServiceImpl")
	private SugService sService;
	

   
	
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
    	System.out.println("/////////////////////////////////");
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
    
    
    
    
    
    
    
  //List Call
  	@RequestMapping(value="/suggest/suggest.do", method = RequestMethod.GET)
  	public ModelAndView sugBoard(ModelAndView mav,
  			@RequestParam(required=false, defaultValue="1")int curPage) throws Exception{
  			
  		int recordCountPage = 9;
  		List<Sug> list = sService.selectAllList(curPage,recordCountPage);
  		mav.setViewName("suggest/sugBoard");
  		mav.addObject("list",list);
  		return mav;
  	}
    
    
    
 // Board Call , reply 
 	@RequestMapping(value="/suggest/sugView.do", method = RequestMethod.GET)
 	public ModelAndView sugview(		
 		@RequestParam(value="suggestNo",defaultValue="1")int suggestNo,
 		HttpSession session) throws Exception {
 	
 		
 //BoardNum Call
 		
 		Sug sug = sService.sugView(suggestNo);
 			
 		ModelAndView mav = new ModelAndView();
 		mav.setViewName("suggest/sugView");
 		mav.addObject("sug", sService.sugView(suggestNo));

 		return mav; 
 	}
 	
 	@RequestMapping(value="/suggest/suggestview.do", method=RequestMethod.POST)
	public String comment(@RequestParam int suggestNo,@RequestParam String userId,Sug sugComment, @SessionAttribute("user") Member member) throws Exception{ 
 		sService.comWrite(sugComment);
		return "redirect:/suggest/sugView?userId="+member.getUserId();
	}
	
	
    
    
    
	/*
	 * @RequestMapping("/member.do") public String member() { Member m = new
	 * Member(); m.setUserId("1234"); m.setUserPwd("1234");
	 * mService.selectLoginMember(m); return "index"; }
	 */

}

