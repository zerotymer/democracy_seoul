package kr.go.seoul.democracy.proposal.controller;


import java.io.IOException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.go.seoul.common.ImageResizeTemplate;
import kr.go.seoul.common.transfer.ImageTransferInfo;
import kr.go.seoul.democracy.admin.model.vo.Admin;
import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.proposal.model.service.ProposalService;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;
import kr.go.seoul.democracy.proposal.model.vo.ProposalComment;
import oracle.jdbc.logging.annotations.Log;

@Controller("proposalController")
public class ProposalController {
	//log4j : sql문이 어떤값을 가져오고 담겨오는지 찍힌다(Log)  
	private static final Logger log = LoggerFactory.getLogger(ProposalController.class);
	
	@Autowired
	@Qualifier("proposalServiceImpl")
	private ProposalService pService;	
	
	@Autowired
	@Qualifier("proposalImageTemplate")
	private ImageResizeTemplate imgTemplate;
	
	//리스트 불러오기
	@RequestMapping(value="/proposal/allList.do", method = RequestMethod.GET)
	public ModelAndView allList(ModelAndView mav,HttpServletRequest request,
			@RequestParam(required=false, defaultValue="1")int currentPage
			) throws Exception{
			
		int recordCountPage = 9;
		int naviCountPerPage = 5;
		int recordTotalCount = pService.listTotalCount();
		
		System.out.println(recordTotalCount);
		
		int pageTotalCount = (int)Math.ceil((double)recordTotalCount/recordCountPage); // 
		int startNavi = currentPage - (currentPage - 1) % naviCountPerPage;
		int endNavi = startNavi + naviCountPerPage - 1;  //5
		endNavi = endNavi > pageTotalCount ? pageTotalCount : endNavi; // 5 > 100 ? 100 : 5
				
		System.out.println("startNavi : " + startNavi);
		System.out.println("endNavi : " + endNavi);
		
		ArrayList<Proposal> list = pService.selectAllList(currentPage, recordCountPage);
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}		
				
		mav.addObject("recordTotalCount", recordTotalCount);
		mav.addObject("list",list);
		mav.addObject("currentPage", currentPage);
		mav.addObject("navi", navi);
		mav.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0 );
		mav.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0 );
		System.out.println(mav);
		mav.setViewName("proposal/allList");

		return mav;			
	}
	
	
	
	
	//댓글 리스트더보기
		@RequestMapping(value="/proposal/getList.ajax", method = RequestMethod.GET)
		@ResponseBody
		public ArrayList<HashMap<String,Object>> getList(@RequestParam int proposalNo,
		@RequestParam(defaultValue="1")int currentPage){
			
			int listPageSize=5;
			ArrayList<HashMap<String, Object>> comment = pService.getComment(proposalNo,currentPage,listPageSize);
			
			return comment;
		}
		
		
	
	
	// 게시글 불러오기  
	@RequestMapping(value="/proposal/post.do", method = RequestMethod.GET)
	public ModelAndView proposalview(		
		@RequestParam(value="proposalNo",defaultValue="1")int proposalNo,
		HttpSession session) throws Exception {
		//게시글번호 가져오기
		
		Proposal proposal = pService.proposalView(proposalNo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("proposal/post");
		mav.addObject("proposal", pService.proposalView(proposalNo));
		
		//댓글가져오는갯수
		int commentCount=5;
		ArrayList<HashMap<String, Object>> comment = pService.getComment(proposalNo,1,commentCount);
		mav.addObject("commentCount",pService.commentTotalCount(proposalNo));
		mav.addObject("commentList",comment);
		return mav;
	}
	
	// 댓글전송                              
	@RequestMapping(value="/proposal/writeComment.do", method=RequestMethod.POST)
	public void comment(@RequestParam int proposalNo,
						@RequestParam String comment,
						@SessionAttribute("user") Member member,
			HttpServletResponse response) throws Exception{ 

		System.err.println(proposalNo);
		System.err.println(comment);

		ProposalComment pcomment = new ProposalComment();
		pcomment.setProposalNo(proposalNo);
		pcomment.setUserId(member.getUserId());
		pcomment.setCommentContent(comment);
		response.getWriter().println(true);
		pService.comWrite(pcomment);
	}
	
	//댓글더보기
	@RequestMapping(value="/proposal/getComment.ajax", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<HashMap<String,Object>> getComment(@RequestParam int proposalNo,
	@RequestParam(defaultValue="1")int currentCommentPage){
		int pageSize=3;
		ArrayList<HashMap<String, Object>> comment = pService.getComment(proposalNo,currentCommentPage,pageSize);
		
		return comment;
	}
	
	
	
	//게시글 작성화면 
	@RequestMapping(value="/proposal/proposalWrite.do")
	public String proposalEnroll(HttpSession session, HttpServletResponse write)throws Exception {
		
		Admin admin = (Admin)session.getAttribute("admin");

		if (admin==null) {
			write.setContentType("text/html; charset=UTF-8");
			PrintWriter out_write = write.getWriter();
			out_write.println("<script>alert('로그인이 되어있지 않습니다. 로그인을 먼저 해주세요.');</script>");
			out_write.flush();
			return "";
		}
		 
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
	
	//썸네일이미지 업로드 
    @RequestMapping(value = "/proposalThumbnail/imageUpload.do", method = RequestMethod.POST)
    public void thumbnailUpload(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "img", "proposal");
        JsonObject json = new JsonObject();
        json.addProperty("fileName", info.getFileName());
        json.addProperty("imgUrl", "/upload/proposal/"+info.getFileName("thumbnail"));
        new Gson().toJson(json,response.getWriter());
    }


	//페이지 수정뷰
	@RequestMapping(value="/proposal/modify.do", method=RequestMethod.GET)
	public String modify(@RequestParam(defaultValue="1") int proposalNo,Model model,HttpSession session) throws Exception{

		Admin admin = (Admin)session.getAttribute("admin");
		if (admin== null) return "redirect:/proposal/allList.do";
		if (admin.getAdminGrade() != '0' && admin.getAdminGrade() != '1') return "proposal/allList"; //비지니스로직
		Proposal proposal = pService.proposalView(proposalNo);
		model.addAttribute("proposal",proposal);
		return "proposal/modify";
	}
	
	//페이지 수정
	@RequestMapping(value="/proposal/update.do", method=RequestMethod.POST)
	public String postModify(Proposal proposal,
							 RedirectAttributes rttr,
							 HttpSession session) throws Exception {
		
		Admin admin = (Admin)session.getAttribute("admin");
		if (admin== null) return "redirect:/proposal/allList.do";
		if (admin.getAdminGrade() != '0' &&	admin.getAdminGrade() != '1') return "proposal/allList";

		pService.modify(proposal);
		rttr.addFlashAttribute("result","modify success");
		return "redirect:/proposal/post.do?proposalNo="+proposal.getProposalNo();	
	}
	
	//게시글삭제하기 
	@RequestMapping(value="/proposal/delete.do", method=RequestMethod.GET)
	public String delete(@RequestParam(defaultValue="1") int proposalNo,HttpSession session) throws Exception {

		Admin admin = (Admin)session.getAttribute("admin");
		if(admin== null) return "redirect:/proposal/allList.do";
		if (admin.getAdminGrade() != '0' && admin.getAdminGrade() != '1') return "proposal/allList";

		pService.delete(proposalNo);
		return "redirect:/proposal/allList.do";
	}
	
	//리스트 불러오기
	@RequestMapping(value="/proposal/resultList.do", method = RequestMethod.GET)
	public ModelAndView resultList(ModelAndView mav,HttpServletRequest request,
			@RequestParam(required=false, defaultValue="1")int currentPage
			) throws Exception{
			
		int recordCountPage = 9;
		int naviCountPerPage = 5;
		int recordTotalCount = pService.resultTotalCount();
		
		int pageTotalCount = (int)Math.ceil((double)recordTotalCount/recordCountPage); // 
		int startNavi = currentPage - (currentPage - 1) % naviCountPerPage;
		int endNavi = startNavi + naviCountPerPage - 1;  //5
		endNavi = endNavi > pageTotalCount ? pageTotalCount : endNavi; // 5 > 100 ? 100 : 5
				
		ArrayList<HashMap<String,Object>> list = pService.resultList(currentPage, recordCountPage);
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}		
				
		mav.addObject("recordTotalCount", recordTotalCount);
		mav.addObject("list",list);
		mav.addObject("currentPage", currentPage);
		mav.addObject("navi", navi);
		mav.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0 );
		mav.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0 );
		mav.setViewName("proposal/result");

		return mav;			
	}
	
	
	
	
}
