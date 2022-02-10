package kr.go.seoul.democracy.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.test.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	//공지사항 페이지로 이동기능 
	@RequestMapping(value="/member/goNoticeNews.do")
	public String NoticeBoard() {
		
		return "member/noticeNews";
	}
	
	//공지사항 리스트 
	@RequestMapping(value="/notice/noticeNewslist.do")
	public ModelAndView noticeNewsSearch(ModelAndView mv,@RequestParam int currentListPage) {
		
		int pageSize=12;
		int totalCount=bService.noticeNewsTotalCount();
		if(currentListPage==0) currentListPage=1;
		
		ArrayList<Discuss> list=bService.noticeNewsList(pageSize,currentListPage);
	
		mv.addObject("list",list);
		mv.addObject("currentListPage",currentListPage);
		mv.addObject("pageSize",pageSize);
		mv.addObject("pageCount",(int)Math.ceil((double)totalCount/pageSize));
		mv.setViewName("adminNotice/list");
	
		return mv;
	}
	
	
	

	


	
	
	
	
	

}
