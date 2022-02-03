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
	
	//메인 화면에서 로그인 페이지로 이동하는 로직
	@RequestMapping(value="/member/goLogin.do")
	public String goLoginPage() {
		
		return "member/memberLogin";
	}
	
	
	//로그인 페이지에서 아이디 찾기 페이지로  가는 로직
	@RequestMapping(value="/member/goMemberSearchId.do")
	public String goMemberSearchId() {
		
		return "member/memberSearchId";//대소문자 주의
		
	}
	
	
    //로그인 페이지에서 '비밀번호 변경 페이지'로 가는 로직
	@RequestMapping(value="/member/goMemberSearchPwd.do")
	public String goMemberSearchPwd() {
		return "member/memberSearchPwd";
	}
	
	
	//회원가입 페이지로 이동하는 로직
	@RequestMapping(value="/member/goMemberJoinus.do",method=RequestMethod.GET)
	public String goMemberJoinus() 
	{//기본페이지에서 회원가입 누른 사람들 회원가입 페이지로 보내는 메소드
		return "member/memberJoinus";
	}
	
	
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
