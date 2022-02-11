package kr.go.seoul.democracy.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.board.model.service.BoardService;
import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	//공지사항 목록으로 이동기능 
	@RequestMapping(value="/board/goNoticeNews.do")
	public String noticeBoard() {
		
		return "member/noticeNews";
	}
	
	//공지사항 게시물 선택시 하나쪽으로 가는 코드
	@RequestMapping(value="/board/goNoticeNewsContent.do")
	public String noticeNewsContent() {
		
		return "member/noticeNewsContent";
	}
	
	
	
	//공지사항 리스트 
	@RequestMapping(value="/board/noticeNewslist.do")
	public ModelAndView noticeNewsList(ModelAndView mv,@RequestParam(required=false,defaultValue="1")int currentListPage) throws Exception {
		
		int recordCountPage=10;
		int totalCount=bService.noticeNewsTotalCount();
		if(currentListPage==0) currentListPage=1;
		
		List<BoardNotice> list=bService.noticeNewsList(recordCountPage,currentListPage);
		
		mv.addObject("noticeNews",list);
		mv.addObject("currentListPage",currentListPage);
		mv.addObject("recordCountPage",recordCountPage);
		mv.addObject("pageCount",(int)Math.ceil((double)totalCount/recordCountPage));
		mv.setViewName("member/noticeNews");
		System.out.println(list);
		return mv;
	}

	
	//공지사항 게시글 하나 로직
	@RequestMapping(value="board/noticeNewsPost.do", method = RequestMethod.GET)
	public ModelAndView noticeNewsViews(@RequestParam(value="noticeNewsNo",defaultValue="1")int noticeNewsNo,HttpSession session) throws Exception
	{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/noticeNewsContent");
		mav.addObject("noticeNews", bService.noticeNewsViews(noticeNewsNo));
		System.out.println(bService.noticeNewsViews(noticeNewsNo));
		return mav;
	}
	
	//공지사항 목록에서 검색하는 메소드
	@RequestMapping(value="/board/noticeNewsListSearch.do")
	public void noticeNewsListSearch() {
		
		
	}
	
	
	
	
	//행사 페이지쪽 게시물 가는 코드
	@RequestMapping(value="/board/noticeCampaignContent")
	public String noticeCampaignContent() {
		
		return "member/noticeCampaineContent";
	}

	
	//행사 페이지 목록으로 가는 코드
	@RequestMapping(value="/board/noticeCampaign.do")
	public String noticeCampaineContent() {
		
		return "member/noticeCampaign";
	}
	
	

	


	
	
	
	
	

}
