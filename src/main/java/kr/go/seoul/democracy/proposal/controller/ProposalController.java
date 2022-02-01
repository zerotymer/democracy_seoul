package kr.go.seoul.democracy.proposal.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.proposal.service.ProposalService;
import kr.go.seoul.democracy.proposal.vo.Proposal;

@Controller("proposalController")
public class ProposalController {
	
	@Autowired
	@Qualifier("proposalServiceImpl")
	private ProposalService pService;	
	
	@RequestMapping("/test/dwdw.do")
	public String test() {
		return "index";
	}
	
	
	@RequestMapping("/proposal/proposalAllList.do")
	public ModelAndView proposalAllList(ModelAndView mav){
		List<Proposal> list = pService.selectAllList();
		mav.addObject("list",list);
		mav.setViewName("proposal/proposalAllList");
		return mav;
	}
	
	
	
}
