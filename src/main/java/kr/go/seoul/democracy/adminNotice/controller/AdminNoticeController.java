package kr.go.seoul.democracy.adminNotice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.go.seoul.democracy.adminNotice.model.service.AdminNoticeService;

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
	
	

}
