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
import org.springframework.web.servlet.ModelAndView;

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
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.06
	 * Description : 관리자 탈퇴 메소드
	 * @return 
	 */
	@RequestMapping(value="/admin/adminWithDraw.do")
	public String adminWithDraw(HttpServletRequest request, 
						   		Model model, 
						   		@SessionAttribute Admin admin,
						   		HttpSession session) //throws IOException
	{
		String adminPwd = request.getParameter("adminPwd");
		
		if(adminPwd == null)
		{
			return "admin/adminWithDrawCheck";
		}
		
		String agree = request.getParameter("agree");
		
		if(agree == null || !agree.equals("Y"))
		{
			model.addAttribute("adminMsg", "동의를 하지 않으면 탈퇴를 할 수 없습니다.");
			model.addAttribute("location", "/admin/adminWithDraw.do");
			return "admin/adminMsg";
		}
		
		String adminId = admin.getAdminId();
		
		int result = aService.updateWithdraw(adminId, adminPwd);
		
		if(result>0)
		{
			session.invalidate();
			model.addAttribute("adminMsg", "정상 탈퇴처리 되었습니다.");
			model.addAttribute("location", "/");
		}else {
			model.addAttribute("adminMsg", "비밀번호가 일치하지 않습니다. 재확인해주세요.");
			model.addAttribute("location", "/admin/adminWithDraw.do");
		}
		
		return "admin/adminMsg";
	}

	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.07
	 * Description : 관리자 가입 페이지로 이동하는 메소드
	 */
	@RequestMapping(value="/admin/adminJoinPage.do", method = RequestMethod.GET)
	public String joinPage() 
	{
		return "admin/adminJoinPage";
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.07
	 * Description : 관리자 가입 메소드
	 */
	@RequestMapping(value="/admin/adminJoin.do", method = RequestMethod.POST)
	public ModelAndView memberJoinus(Admin a, 
									 ModelAndView mav)
	{
		int result = aService.insertAdminMember(a);
		
		if(result>0)
		{
			mav.addObject("msg", "관리자 가입 성공");
			mav.addObject("location", "/");
			
		}else {
			
			mav.addObject("msg", "관리자 가입 실패");
			mav.addObject("location", "/admin/adminJoinPage.do");
		}
		
		mav.setViewName("admin/adminMsg"); //return 대신
		
		return mav;
		
	}
	
	
	/**
	 * 작성자 : 김영주
	 * 작성일 : 2022.02.07
	 * Description : 관리자 ID 중복체크 메소드
	 */
	@RequestMapping(value="/admin/adminIdCheck.do", method = RequestMethod.GET)
	public void memberIdCheck(@RequestParam String adminId, 
							  HttpServletResponse response) throws IOException
	{ 
		int result = aService.selectAdminIdCheck(adminId);
		
		if(result>0)
		{
			response.getWriter().print(true);
			
		}else {
			response.getWriter().print(false);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
