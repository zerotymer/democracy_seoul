package kr.go.seoul.democracy.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.go.seoul.democracy.admin.model.service.AdminService;
import kr.go.seoul.democracy.admin.model.vo.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService AdminService;
	
	@RequestMapping(value="/admin/AdminLogin.do", method = RequestMethod.POST)
	private void login(HttpServletRequest request,
						 Admin admin)
	{
		System.out.println("Login 로직 정상 호출");
	}

}
