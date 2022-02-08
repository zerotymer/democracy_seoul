package kr.go.seoul.democracy.proposal.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.go.seoul.democracy.proposal.model.service.ProposalService;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;

@Controller("proposalController")
public class ProposalController {
	//log4j : sql문이 어떤값을 가져오고 담겨오는지 찍힌다(Log)  
	private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);

	@Autowired
	@Qualifier("proposalServiceImpl")
	private ProposalService pService;	
	
	@RequestMapping(value="/proposal/dw.do", method = RequestMethod.POST)
	public String test() {
		return "index";
	}

	
	@RequestMapping(value="/proposal/allList.do", method = RequestMethod.GET)
	public ModelAndView allList(ModelAndView mav,
			@RequestParam(required=false, defaultValue="1")int curPage) throws Exception{
			
		int recordCountPage = 9;
		List<Proposal> list = pService.selectAllList(curPage,recordCountPage);
		mav.setViewName("proposal/allList");
		mav.addObject("list",list);
		System.out.println(list);
		return mav;
	}
	
	@RequestMapping(value="/proposal/post.do", method = RequestMethod.GET)
	public ModelAndView proposalview(
		@RequestParam(value="proposalNo",defaultValue="1")int proposalNo,
		HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("proposal/post");
		mav.addObject("proposal", pService.proposalView(proposalNo));
		return mav;
	}
	
	
	@RequestMapping(value="/proposal/proposalWrite.do", method=RequestMethod.GET)
	public String write() {
		return "proposal/proposalWrite";
	}
	
	
}
