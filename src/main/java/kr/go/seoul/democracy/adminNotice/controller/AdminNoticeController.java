package kr.go.seoul.democracy.adminNotice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.adminNotice.model.service.AdminNoticeService;
import kr.go.seoul.democracy.adminNotice.model.vo.AdminNotice;

@Controller
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService nService;
	
	//공지사항 작성한 목록들 보이게 = noticeList(boardList똑같)
	//공지사항 작성 = boardWrite
	//공지사항 수정 = boardUpdate
	//(1차)공지사항 삭제 = boardDelete
	//(2차)공지사항 체크해서 없애기(여러개 선택해서 삭제할 수 있도록)
	//(3차)공지사항 검색
	
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
		ArrayList<AdminNotice> list = nService.selectAllNoticeList(currentPage, recordCountPerPage); //notice에서 변경해야 할 부분
		
		int pageTotalCount = (int)Math.ceil(nService.noticeTotalCount()/(double)recordCountPerPage); //notice에서 변경해야 할 부분

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

}
