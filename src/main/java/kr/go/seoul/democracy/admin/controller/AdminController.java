package kr.go.seoul.democracy.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.go.seoul.democracy.admin.model.service.AdminService;
import kr.go.seoul.democracy.admin.model.vo.Admin;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService aService;
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.03
	 * Description : 관리자 로그인 시 사용하는 메소드
	 */
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
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.04
	 * Description : 관리자 로그아웃 시 사용하는 메소드
	 */
	@RequestMapping(value="/admin/adminLogout.do", method = RequestMethod.GET)
	public String logout(HttpSession session,
					   @SessionAttribute Admin admin)
	{
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
