package kr.go.seoul.democracy.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.board.model.service.BoardService;
import kr.go.seoul.democracy.board.model.service.EventService;
import kr.go.seoul.democracy.board.model.service.ReferService;
import kr.go.seoul.democracy.board.model.service.SeoulNewsService;
import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.board.model.vo.Event;
import kr.go.seoul.democracy.board.model.vo.Referenceroom;
import kr.go.seoul.democracy.board.model.vo.SeoulNews;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@Autowired
	private EventService eService;
	
	
	@Autowired
	private SeoulNewsService sService;
	
	@Autowired
	private ReferService rService;
	
	//공지사항 목록으로 이동기능 (남진구)
	@RequestMapping(value="/board/goNoticeNews.do")
	public ModelAndView noticeBoard(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage) throws Exception {
		System.out.println("목록 불러오기 정상구동");
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		List<BoardNotice> list=bService.noticeNewsList(recordCountPerPage, currentPage);//
		int pageTotalCount = (int)Math.ceil(bService.totalCount()/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		System.out.println(pageTotalCount);
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/noticeNews");
	
		return mv;
	}
	
	//공지사항 게시물 선택시 하나쪽으로 가는 코드
	@RequestMapping(value="/board/goNoticeNewsDetail.do")
	public ModelAndView noticeNewsContent(ModelAndView mv,HttpServletRequest request) throws Exception {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int curretnPageNo =  Integer.parseInt(request.getParameter("currentNo"));
		BoardNotice boardNotice = bService.noticeNewsViews(noticeNo);
		mv.addObject("board",boardNotice);
		mv.addObject("currentNo",curretnPageNo);
		mv.setViewName("board/noticeNewsContent");
		return mv;
	}
	
	
	//공지사항 게시글 하나 로직
	@RequestMapping(value="board/noticeNewsPost.do", method = RequestMethod.GET)
	public ModelAndView noticeNewsViews(@RequestParam(value="noticeNewsNo",defaultValue="1")int noticeNewsNo,HttpSession session) throws Exception
	{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/noticeNewsContent");
		mv.addObject("noticeNews", bService.noticeNewsViews(noticeNewsNo));
		System.out.println(bService.noticeNewsViews(noticeNewsNo));
		return mv;
	}
	
	//공지사항 목록에서 검색하는 메소드
	@RequestMapping(value="/board/noticeNewsListSearch.do")
	public ModelAndView noticeNewsListSearch(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage,HttpServletRequest request)
			throws Exception{
		//1. type title titleNContent Content
		//2. query문작성 
		System.out.println("공지사항 검색 로직 정상 호출");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		BoardNotice boardNotice = new BoardNotice();
		boardNotice.setNoticeNewsTitle(keyword);
		boardNotice.setNoticeNewsContent(keyword);
		
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		int pageTotalCount =0;
		List<BoardNotice> list = new ArrayList<BoardNotice>();
		if(type.equals("subject")) {
			list=bService.noticeNewsListSearchTitle(recordCountPerPage, currentPage,boardNotice);//
			pageTotalCount = (int)Math.ceil(bService.totalSearchTitleCount(boardNotice)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		}
		else if(type.equals("all")) {
			list=bService.noticeNewsListSearch(recordCountPerPage, currentPage,boardNotice);//
			pageTotalCount = (int)Math.ceil(bService.totalSerchCount(boardNotice)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		}
		else {
			list=bService.noticeNewsListSearch(recordCountPerPage, currentPage,boardNotice);//
			pageTotalCount = (int)Math.ceil(bService.totalSearchContentCount(boardNotice)/(double)recordCountPerPage);
			
		}
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("keyword",keyword);
		mv.addObject("type",type);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/noticeSerchNews");
	
		return mv;
		
	}
	
	
	
	//행사 페이지 목록으로 가는 코드
	@RequestMapping(value="/board/noticeCampaign.do")
	public ModelAndView noticeCampaineContent(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage) throws Exception {
		System.out.println("목록 불러오기 정상구동");
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		List<Event> list= eService.eventList(recordCountPerPage, currentPage);//
		int pageTotalCount = (int)Math.ceil(eService.totalCount()/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/noticeCampaign");
		return mv;
	}
	
	
	
	//행사 페이지쪽 게시물 가는 코드
	@RequestMapping(value="/board/noticeCampaignContent")
	public ModelAndView noticeCampaignContent(ModelAndView mv,HttpServletRequest request) throws Exception {
		int curretnPageNo =  Integer.parseInt(request.getParameter("currentNo"));//
		int eventNo = Integer.parseInt(request.getParameter("eventNo"));
		Event event = eService.eventNewsViews(eventNo);
		mv.addObject("currentNo",curretnPageNo);//
		mv.addObject("board",event);
		mv.setViewName("board/noticeCampaineContent");
		return mv;
	}
	
	
	    //행사 목록에서 검색하는 메소드
		@RequestMapping(value="/board/noticeCampaignListSearch.do")
		public ModelAndView noticeCampaignSearch(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage,HttpServletRequest request)
				throws Exception{
			//1. type title titleNContent Content
			//2. query문작성 
			System.out.println("공지사항 검색 로직 정상 호출");
			
			String keyword = request.getParameter("keyword");
			String type = request.getParameter("type");
			Event event = new Event();
			event.setEventTitle(keyword);
			event.setEventContent(keyword);
			
			int recordCountPerPage = 10; //보여지는 게시글의 갯수
			int naviSize = 5; //네비 갯수
			int pageTotalCount =0;
			List<Event> list = new ArrayList<Event>();
			if(type.equals("subject")) {
				list=eService.eventListSearchTitle(recordCountPerPage, currentPage,event);//
				pageTotalCount = (int)Math.ceil(eService.totalSearchTitleCount(event)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
			}
			else if(type.equals("all")) {
				list=eService.eventListSearchAll(recordCountPerPage, currentPage,event);//
				pageTotalCount = (int)Math.ceil(eService.totalSearchCount(event)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
			}
			else {
				list=eService.eventListSearchContent(recordCountPerPage, currentPage,event);//
				pageTotalCount = (int)Math.ceil(eService.totalSearchContentCount(event)/(double)recordCountPerPage);
				
			}
			int startNavi = currentPage - (currentPage - 1) % naviSize;
			int endNavi = startNavi + naviSize - 1;
			endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
			ArrayList<Integer> navi = new ArrayList<>();
			for (int i = startNavi; i <= endNavi; i++) {
				navi.add(i);
			}
			mv.addObject("list",list);
			mv.addObject("keyword",keyword);
			mv.addObject("type",type);
			mv.addObject("currentNo",currentPage);//
			mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
			mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
			mv.addObject("navi", navi);
			mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
			mv.setViewName("board/noticeSearchCampaign");//
		
			return mv;
			
		}
	
	
	
	
	//서울시민뉴스 페이지 목록으로 가는 코드
	@RequestMapping(value="/board/seoulNews.do")
	public ModelAndView seoulNewsList(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage) throws Exception {
		System.out.println("목록 불러오기 정상구동");
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		List<SeoulNews> list= sService.seoulNewsList(recordCountPerPage, currentPage);//
		int pageTotalCount = (int)Math.ceil(sService.totalCount()/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/seoulNews");
		return mv;
	}
	
	
	//서울시민뉴스 페이지 목록으로 가는 코드
	@RequestMapping(value="/board/seoulNewsDetail.do")
	public ModelAndView seoulNewsContent(ModelAndView mv,HttpServletRequest request) throws Exception {
		int curretnPageNo =  Integer.parseInt(request.getParameter("currentNo"));//
		int seoulNewsNo = Integer.parseInt(request.getParameter("seoulNewsNo"));
		SeoulNews seoulNews = sService.seoulNewsNewsViews(seoulNewsNo);
		mv.addObject("seoulNews",seoulNews);
		mv.addObject("currentNo",curretnPageNo);//
		mv.setViewName("board/seoulNewsContent");
		return mv;
	}
	
	
	
    //서울시민뉴스 페이지에서 검색하는 메소드
	@RequestMapping(value="/board/seoulNewsSearch.do")
	public ModelAndView seoulNewsSearch(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage,HttpServletRequest request)
			throws Exception{
		//1. type title titleNContent Content
		//2. query문작성 
		System.out.println("공지사항 검색 로직 정상 호출");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		SeoulNews seoulNews = new SeoulNews();
		seoulNews.setSeoulTitle(keyword);
		seoulNews.setSeoulContent(keyword);
		System.out.println("keyword");

		
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		int pageTotalCount =0;
		List<SeoulNews> list = new ArrayList<SeoulNews>();
		System.out.println("list");
		if(type.equals("subject")) {
			list=sService.seoulNewsListSearchTitle(recordCountPerPage, currentPage,seoulNews);//
			pageTotalCount = (int)Math.ceil(sService.totalSearchTitleCount(seoulNews)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		}
		else if(type.equals("all")) {
			list=sService.seoulNewsListSearchAll(recordCountPerPage, currentPage,seoulNews);//
			pageTotalCount = (int)Math.ceil(sService.totalSearchCount(seoulNews)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		}
		else {
			list=sService.seoulNewsListSearchContent(recordCountPerPage, currentPage,seoulNews);//
			pageTotalCount = (int)Math.ceil(sService.totalSearchContentCount(seoulNews)/(double)recordCountPerPage);
			
		}
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("keyword",keyword);
		mv.addObject("type",type);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/seoulSearchNews");
	
		return mv;
		
	}
	
	
	
	
	
	//자료실 페이지 목록으로 가는 코드
	@RequestMapping(value="/board/referenceList.do")
	public ModelAndView referList(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage) throws Exception {
		System.out.println("목록 불러오기 정상구동");
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		List<Referenceroom> list= rService.referList(recordCountPerPage, currentPage);//
		int pageTotalCount = (int)Math.ceil(rService.totalCount()/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/referenceroom");
		return mv;
	}
	
	
	//자료실 페이지 게시물로 가는 코드
	@RequestMapping(value="/board/referenceDetail.do")
	public ModelAndView referContent(ModelAndView mv,HttpServletRequest request) throws Exception {
		int referNo = Integer.parseInt(request.getParameter("referNo"));
		int curretnPageNo =  Integer.parseInt(request.getParameter("currentNo"));//
		Referenceroom referenceroom = rService.referViews(referNo);
		mv.addObject("referenceroom",referenceroom);
		mv.addObject("currentNo",curretnPageNo);//
		mv.setViewName("board/referenceroomContent");
		return mv;
	}
	

	
    //자료실 페이지에서 검색하는 메소드
	@RequestMapping(value="/board/referenceSearch.do")
	public ModelAndView referenceSearch(ModelAndView mv,@RequestParam(defaultValue="1") int currentPage,HttpServletRequest request)
			throws Exception{
		//1. type title titleNContent Content
		//2. query문작성 
		System.out.println("공지사항 검색 로직 정상 호출");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		Referenceroom referenceroom = new Referenceroom();
		referenceroom.setReferTitle(keyword);
		referenceroom.setReferContent(keyword);
		System.out.println("keyword");

		
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		int pageTotalCount =0;
		List<Referenceroom> list = new ArrayList<Referenceroom>();
		System.out.println("list");
		if(type.equals("subject")) {
			list=rService.referenceroomSearchTitle(recordCountPerPage, currentPage,referenceroom);//
			pageTotalCount = (int)Math.ceil(rService.totalSearchTitleCount(referenceroom)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		}
		else if(type.equals("all")) {
			list=rService.referenceroomSearchAll(recordCountPerPage, currentPage,referenceroom);//
			pageTotalCount = (int)Math.ceil(rService.totalSearchCount(referenceroom)/(double)recordCountPerPage); //notice에서 변경해야 할 부분
		}
		else {
			list=rService.referenceroomSearchContent(recordCountPerPage, currentPage,referenceroom);//
			pageTotalCount = (int)Math.ceil(rService.totalSearchContentCount(referenceroom)/(double)recordCountPerPage);
			
		}
		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		mv.addObject("list",list);
		mv.addObject("keyword",keyword);
		mv.addObject("type",type);
		mv.addObject("currentNo",currentPage);//
		mv.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mv.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mv.addObject("navi", navi);
		mv.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mv.setViewName("board/referenceroomSearch");
	
		return mv;
		
	}
	
	
	

	

	

	/**
	 * 작성자 : 
	 * 작성일 : 2022.02.10
	 * Description : 모든 회원 정보 가져오는 페이지의 목록의 갯수 + 네비바 메소드
	 */
//	@RequestMapping(value="/admin/allMemberList.do")
//	public ModelAndView allMemberPage(HttpServletRequest request, 
//								  HttpServletResponse response,
//								  @RequestParam(defaultValue="1") int currentPage,
//								  ModelAndView mav) throws ServletException, IOException
//	{
//		int recordCountPerPage = 10; //보여지는 게시글의 갯수
//		int naviSize = 5; //네비 갯수
//		
//		
//		//페이지 목록 10개씩 끊는 로직
//		ArrayList<Member> list = aService.selectAllPostList(currentPage, recordCountPerPage); //notice에서 변경해야 할 부분
//		
//		int pageTotalCount = (int)Math.ceil(aService.totalCount()/(double)recordCountPerPage); //notice에서 변경해야 할 부분
//
//		int startNavi = currentPage - (currentPage - 1) % naviSize;
//		int endNavi = startNavi + naviSize - 1;
//		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
//		
//		ArrayList<Integer> navi = new ArrayList<>();
//		for (int i = startNavi; i <= endNavi; i++) {
//			navi.add(i);
//		}
//		//((currentPage-1) * recordCountPerPage);
//		mav.addObject("list", list);
//		mav.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
//		mav.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
//		mav.addObject("navi", navi);
//		mav.addObject("countResult", (currentPage-1) * recordCountPerPage);
//		mav.setViewName("admin/adminBoardPage");
//		
//		return mav;
//	}
//	
	


	
	
	
	
	

}
