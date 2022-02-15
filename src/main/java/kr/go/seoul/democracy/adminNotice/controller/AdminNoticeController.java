package kr.go.seoul.democracy.adminNotice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.adminNotice.model.service.AdminNoticeService;
import kr.go.seoul.democracy.adminNotice.model.vo.AdminNotice;

@Controller
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService nService;
	private String noticeTitle;
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.11
	 * Description : 모든 공지사항 목록을 가져오는 페이지의 목록의 갯수 + 네비바 메소드
	 */
	@RequestMapping(value="/notice/allMemberList.do")
	public ModelAndView allNoticePage(HttpServletRequest request, 
								  	  HttpServletResponse response,
								  	  @RequestParam(defaultValue="1") int currentPage,
								  	  ModelAndView mav) throws ServletException, IOException
	{
		int recordCountPerPage = 10; //보여지는 게시글의 갯수
		int naviSize = 5; //네비 갯수
		
		
		//페이지 목록 10개씩 끊는 로직
		ArrayList<AdminNotice> list = nService.selectAllNoticeList(currentPage, recordCountPerPage); 
		int pageTotalCount = (int)Math.ceil(nService.noticeTotalCount()/(double)recordCountPerPage); 

		int startNavi = currentPage - (currentPage - 1) % naviSize;
		int endNavi = startNavi + naviSize - 1;
		endNavi = endNavi < pageTotalCount ? endNavi : pageTotalCount;
		
		ArrayList<Integer> navi = new ArrayList<>();
		for (int i = startNavi; i <= endNavi; i++) {
			navi.add(i);
		}
		
		mav.addObject("list", list);
		mav.addObject("preNavi", startNavi > 1 ? startNavi - 1 : 0); //0은 오류 생겼을 때, 
		mav.addObject("nextNavi", pageTotalCount > endNavi ? endNavi + 1 : 0);
		mav.addObject("navi", navi);
		mav.addObject("countResult", (currentPage-1) * recordCountPerPage);
		mav.setViewName("notice/noticeBoardPage");
		
		return mav;
	}
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.12
	 * Description : 공지사항 글 작성 페이지로 이동
	 */
	@RequestMapping(value="/notice/noticeWritePageMove.do")
	public String noticeWritePageMove()
	{
		return "notice/noticeCkeditorWrite";
	}
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.12
	 * Description : 공지사항 글 작성 
	 */
	@RequestMapping(value="/notice/noticeWrite.do")
	public ModelAndView noticeWrite(@RequestParam String noticeTitle,
									@RequestParam String noticeContent,
							  		ModelAndView mav)
	{
		AdminNotice an = new AdminNotice();
		an.setNoticeTitle(noticeTitle);
		an.setNoticeContent(noticeContent);
		
		int result = nService.insertNoticeWrite(an);
		
		if(result>0)
		{
			mav.addObject("noticeMsg", "작성이 완료되었습니다");
			mav.addObject("location", "/notice/allMemberList.do");
			
		}else {
			
			mav.addObject("noticeMsg", "작성에 실패하였습니다");
			mav.addObject("location", "/notice/allMemberList.do");
		}
		
		mav.setViewName("notice/noticeMsg"); //return 대신
		
		return mav;
	}
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.12
	 * Description : 공지사항을 볼 수 있는 페이지로 이동
	 */
	@RequestMapping(value="/notice/noticeViewPageMove.do")
	public String noticeViewPageMove()
	{
		return "notice/noticeCkeditorView";
	}
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.12
	 * Description : 공지사항 view 페이지
	 */
	@RequestMapping(value="/notice/noticeViewPage.do")
	public ModelAndView noticeViewPage(@RequestParam int noticeNo,
									   ModelAndView mav)
	{
		AdminNotice notice = nService.selectOneNotice(noticeNo);
		mav.addObject("adminNotice", notice);
		mav.setViewName("notice/noticeCkeditorView");
		return mav;
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.14
	 * Description : 공지사항 수정 페이지
	 * @throws IOException 
	 */
	@RequestMapping(value="/notice/noticeUpdate.do", method = RequestMethod.POST)
	public void noticeUpdate(HttpServletResponse response,
							   @RequestParam int noticeNo,
							   @RequestParam String noticeTitle,
							   @RequestParam String noticeContent,
							   Model model) throws IOException
	{
		AdminNotice an = new AdminNotice();
		an.setNoticeNo(noticeNo);
		an.setNoticeTitle(noticeTitle);
		an.setNoticeContent(noticeContent);
		
		int result = nService.noticeUpdate(an);
		
		response.setContentType("text/html;charset=UTF-8"); //인코딩
		PrintWriter out = response.getWriter();
		
		if(result>0)
		{
			out.println("<script>alert('"+noticeTitle+" 게시글 수정 완료');location.replace('/notice/allMemberList.do');</script>");
		}else {
			out.println("<script>alert('"+noticeTitle+" 게시글 수정 실패');location.replace('/notice/allMemberList.do');</script>");
		}
		
		
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.14
	 * Description : 공지사항 삭제 페이지
	 * @throws IOException 
	 */
	@RequestMapping(value="/notice/noticeDelete.do", method = RequestMethod.GET)
	public void noticeDelete(HttpServletResponse response,
							  @RequestParam int noticeNo) throws IOException
	{
		
		AdminNotice an = new AdminNotice();
		an.setNoticeNo(noticeNo);
		
		int result = nService.noticeDelete(an);
		response.setContentType("text/html;charset=UTF-8"); //인코딩
		PrintWriter out = response.getWriter();
		
		if(result>0)
		{
			out.println("<script>alert('공지사항 삭제 완료');location.replace('/notice/allMemberList.do');</script>");
		}else {
			out.println("<script>alert('공지사항 삭제 실패');location.replace('/notice/allMemberList.do');</script>");
		}
	}
	

}
