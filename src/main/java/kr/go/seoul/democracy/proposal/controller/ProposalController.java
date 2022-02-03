package kr.go.seoul.democracy.proposal.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.proposal.service.ProposalService;
import kr.go.seoul.democracy.proposal.vo.Proposal;

@Controller("proposalController")
public class ProposalController {
	//log4j : sql문이 어떤값을 가져오고 담겨오는지 찍힌다(Log)  
	private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);

	@Autowired
	@Qualifier("proposalServiceImpl")
	private ProposalService pService;	
	
	@RequestMapping("/test/dwdw.do")
	public String test() {
		return "index";
	}
		
	public static void main(String[] args) {
		logger.debug("ProposalController 디버그");
		logger.error("error발생");
	}
	
	
	
	@RequestMapping(value="/proposal/proposalAllList.do")
	public ModelAndView allList(@RequestParam(defaultValue="proposalTilte")String searchOption,
			@RequestParam(defaultValue="")String keyword,
			@RequestParam(defaultValue="1")int curPage) throws Exception{

		List<Proposal> list = pService.selectAllList();
		ModelAndView mav = new ModelAndView(); //모델(데이터)+뷰(화면) 함께 전달하는 객체
		mav.setViewName("proposal/proposalAllList");
		mav.addObject("list",list);
		return mav;
	}
	
	@RequestMapping(value="/proposal/post.do")
	public ModelAndView proposalview(
		@RequestParam(value="proposalNo",defaultValue="1")int proposalNo,HttpSession session) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("proposal/post");
		mav.addObject("Proposal",pService.proposalView(proposalNo));
		logger.info("mav",mav);
		return mav;
	}
	
	

}
