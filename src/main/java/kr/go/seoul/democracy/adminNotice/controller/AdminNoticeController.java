package kr.go.seoul.democracy.adminNotice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import kr.go.seoul.democracy.adminNotice.model.service.AdminNoticeService;

@Controller
public class AdminNoticeController {
	
	@Autowired
	private AdminNoticeService nService;

}
