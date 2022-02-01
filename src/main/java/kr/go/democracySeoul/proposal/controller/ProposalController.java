package kr.go.democracySeoul.proposal.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.go.democracySeoul.proposal.service.ProposalService;
import kr.go.democracySeoul.proposal.vo.Proposal;

@Controller
public class ProposalController {
	
	@Autowired
	private ProposalService pService;	
	
	@RequestMapping(value="/proposal/proposalAllList.do", method=RequestMethod.GET)
	public ModelAndView proposalAllList(ModelAndView mav){
		List<Proposal> list = pService.selectAllList();
		mav.addObject("list",list);
		mav.setViewName("proposal/proposalAllList");
		return mav;
	}
	
	
	
}
