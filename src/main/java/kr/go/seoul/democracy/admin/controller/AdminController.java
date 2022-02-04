package kr.go.seoul.democracy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.go.seoul.democracy.admin.model.service.AdminService;
import kr.go.seoul.democracy.admin.model.vo.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	@RequestMapping(value="/admin/adminLogin.do", method = RequestMethod.POST)
	private String login(HttpServletRequest request,
						 Admin admin)
	{
		Admin a = aService.selectLoginAdmin(admin);
		
		if(a != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("admin", a);
			
			return "redirect:/";
		}else {
			return "admin/adminLoginFail";
		}
	}

}