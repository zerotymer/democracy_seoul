package kr.go.seoul.democracy.admin.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.05
	 * Description : 관리자 마이페이지에 들어가서 정보변경시 사용하는 메소드
	 */
	@RequestMapping(value="/admin/adminMyPage.do")
	public String myPagePassCheck(HttpServletRequest request,
								@SessionAttribute Admin admin,
								HttpSession session)
	{
		String adminPwd = request.getParameter("adminPwd");
		
		if(adminPwd == null)
		{
			return "admin/adminMyPagePassCheck";
		}else {
			String adminId = admin.getAdminId();
			
			Admin a  = aService.selectLoginAdmin(admin);
			
			if(a != null)
			{
				session.setAttribute("admin", a);
				return "admin/adminMyPage";
			}else {
				return "admin/adminMyPageLoadFail";
			}
			
			}
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.06
	 * Description : 관리자 비밀번호 변경 메소드
	 */
	@RequestMapping(value="/admin/adminPasswordChange.do", method = RequestMethod.POST)
	public void adminPasswordChange(@RequestParam String adminOriginalPass, 
									  @RequestParam String adminNewPass,
									  @SessionAttribute Admin admin,
									  HttpServletResponse response) throws IOException
	{
		String adminId = admin.getAdminId();

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("adminId", adminId);
		map.put("adminOriginalPass", adminOriginalPass);
		map.put("adminNewPass", adminNewPass);
		
		int result = aService.updatePassword(map);
		
		if(result>0)
		{
			response.getWriter().print(true);
		}else {
			response.getWriter().print(false);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
