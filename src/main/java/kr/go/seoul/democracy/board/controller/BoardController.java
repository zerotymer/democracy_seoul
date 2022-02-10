package kr.go.seoul.democracy.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	//공지사항 페이지로 이동기능 
	@RequestMapping(value="/board/goNoticeNews.do")
	public String noticeBoard() {
		
		return "member/noticeNews";
	}
	
	//공지사항시 클릭시 하나쪽으로 가는 코드
	@RequestMapping(value="/board/goNoticeNewsContent.do")
	public String noticeNewsContent() {
		
		return "member/noticeNewsContent";
	}
	
	
	
	//행사 페이지쪽으로 가는 코드
	@RequestMapping(value="/board/noticeCampaineContent.do")
	public String noticeCampaineContent() {
		
		return "member/noticeCampaineContent";
	}
	
	
	//공지사항 리스트 +페이징처리
	@RequestMapping(value="/board/noticeNewslist.do")
	public ModelAndView noticeNewsSearch(ModelAndView mv,@RequestParam(defaultValue="1")int currentListPage) {
		
		int pageSize=12;
		int totalCount=bService.noticeNewsTotalCount();
		if(currentListPage==0) currentListPage=1;
		
		ArrayList<BoardNotice> list=bService.noticeNewsList(pageSize,currentListPage);
	
		mv.addObject("list",list);
		mv.addObject("currentListPage",currentListPage);
		mv.addObject("pageSize",pageSize);
		mv.addObject("pageCount",(int)Math.ceil((double)totalCount/pageSize));
		mv.setViewName("member/noticeNews");
	
		return mv;
	}
	
	//공지사항 게시글 하나 체크 했을때 이동로직
	@RequestMapping(value="/board/noticeNewsSelectOne.do", method = RequestMethod.GET)
	public ModelAndView noticeNewsSelectOne(ModelAndView mv,@RequestParam int noticeNewsNo) {
		//페이징 처리

		
		
		//데이터 가져오기
		 //게시글 번호로 해당 게시글 찾기
		
		
		return mv;
	}
	
	
	

	


	
	
	
	
	

}
