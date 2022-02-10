package kr.go.seoul.democracy.proposal.controller;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.go.seoul.democracy.admin.model.vo.Admin;
import kr.go.seoul.democracy.proposal.model.service.ProposalService;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;
import oracle.jdbc.logging.annotations.Log;

@Controller("proposalController")
public class ProposalController {
	//log4j : sql문이 어떤값을 가져오고 담겨오는지 찍힌다(Log)  
	private static final Logger log = LoggerFactory.getLogger(ProposalController.class);
	
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
	
	//게시글 작성화면 
	@RequestMapping(value="/proposal/proposalWrite.do")
	public String proposalEnroll(HttpSession session, HttpServletResponse write)throws Exception {
		
		/*
		 * String adminId = (String)session.getAttribute("adminId");
		 * 
		 * if(adminId==null) { write.setContentType("text/html; charset=UTF-8");
		 * PrintWriter out_write = write.getWriter();
		 * out_write.println("<script>alert('로그인이 되어있지 않습니다. 로그인을 먼저 해주세요.');</script>"
		 * ); out_write.flush();
		 * 
		 * return ""; }else {
		 */
		 
		return "proposal/proposalWrite";
//	}
}

	//글 저장 
	@RequestMapping(value="/proposal/enroll.do", method=RequestMethod.POST)
	public String write(Proposal proposal,HttpSession session,HttpServletResponse insert,RedirectAttributes rttr) throws Exception {
		log.info("register:"+proposal);		
	        //레코드저장
		pService.insert(proposal);
		rttr.addFlashAttribute("result",proposal.getProposalNo());
		return "redirect:/proposal/allList.do";
	}
	


	//페이지 수정뷰
	@RequestMapping(value="/proposal/modify.do", method=RequestMethod.GET)
	public String modify(@RequestParam(defaultValue="1") int proposalNo,Model model,HttpSession session) throws Exception{
		//세션확인 
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin== null) return "proposal/allList"; 
		if (admin.getAdminGrade() != '0' && admin.getAdminGrade() != '1') return "proposal/allList";
		//비지니스로직 
		Proposal proposal = pService.proposalView(proposalNo);
		model.addAttribute("proposal",proposal);
		return "proposal/modify";
	}
	
	//페이지 수정
	@RequestMapping(value="/proposal/update.do", method=RequestMethod.POST)
	public String postModify(Proposal proposal,RedirectAttributes rttr,HttpSession session) throws Exception {
		
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin== null) return "proposal/allList"; 
		if (admin.getAdminGrade() != '0' && admin.getAdminGrade() != '1') return "proposal/allList";
		
		pService.modify(proposal);
		//rttr.addFlashAttribute("result","modify success");
		return "redirect:/proposal/post?proposalNo="+proposal.getProposalNo();	
	}
	
	//게시글삭제하기 
	@RequestMapping(value="/proposal/delete.do", method=RequestMethod.POST)
	public String delete(@RequestParam(defaultValue="1") int proposalNo,HttpSession session) {
		Admin admin = (Admin)session.getAttribute("admin");
		if(admin== null) return "proposal/allList"; 
		if (admin.getAdminGrade() != '0' && admin.getAdminGrade() != '1') return "proposal/allList";
		
		pService.delete(proposal.getProposalNo());
		return "redirect:/proposal/allList";
	}
	
}
