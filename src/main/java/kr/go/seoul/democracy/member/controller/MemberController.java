package kr.go.seoul.democracy.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService mService;
	
	@RequestMapping(value="/member/login.do", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			Member member
			){
				
				System.out.println("Login 로직 정상 호출");
				
				Member m = mService.selectLoginMember(member);
				
				if(m!=null)
				{
					System.out.println("로그인 성공");
					HttpSession session = request.getSession();
					session.setAttribute("member",m);
					
					return "redirect:/";
				}else {
					return "member/loginFail";
				}
				
			}
	

}
