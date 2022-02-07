package kr.go.seoul.democracy.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.common.ImageResizeTemplate;
import kr.go.seoul.common.transfer.ImageTransferInfo;
import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.member.model.service.MailSendService;
import kr.go.seoul.democracy.member.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	@Qualifier("profileImageTemplate")
    private ImageResizeTemplate imgTemplate;
    

	@Autowired
	private MemberService mService;
	
	@Autowired
	private MailSendService mss;
	
	//메인 화면에서 로그인 페이지로 이동하는 로직
	@RequestMapping(value="/member/goLogin.do",method=RequestMethod.GET)
	public String goLoginPage() {
		
		return "member/memberLogin";
	}
	
	
	//메인 화면에서 마이 페이지로 이동하는 로직
	@RequestMapping(value="/member/goMypage.do",method=RequestMethod.GET)
	public String goMypage() {
		
		return "member/myPage";
	}
	
	//로그인 페이지에서 아이디 찾기 페이지로  가는 로직
	@RequestMapping(value="/member/goMemberSearchId.do",method=RequestMethod.GET)
	public String goMemberSearchId() {
		
		return "member/memberSearchId";//대소문자 주의
		
	}
	
	
    //로그인 페이지에서 '비밀번호 변경 페이지'로 가는 로직
	@RequestMapping(value="/member/goMemberSearchPwd.do",method=RequestMethod.GET)
	public String goMemberSearchPwd() {
		return "member/memberSearchPwd";
	}
	
	
	//회원가입 페이지로 이동하는 로직
	@RequestMapping(value="/member/goMemberJoinus.do",method=RequestMethod.GET)
	public String goMemberJoinus() 
	{//기본페이지에서 회원가입 누른 사람들 회원가입 페이지로 보내는 메소드
		return "member/memberJoinus";
	}
	
	
	
	
	//로그인
	
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String login(HttpServletRequest request,Model model,Member member){
				
	System.out.println("Login 로직 정상 호출");
	System.out.println(member.toString());
	Member m = mService.selectLoginMember(member);
	
	if(m!=null)
	{
		System.out.println("로그인 성공");
		HttpSession session = request.getSession();
		session.setAttribute("member",m);
		
		return "redirect:/";
	}else {
		model.addAttribute("msg","로그인의 실패하였습니다.아이디와 비밀번호 확인해주세요.");
		model.addAttribute("location","/");
		return "member/msg";
	}
	
	}

	
	//회원가입
	
	@RequestMapping(value="/member/memberJoin.do", method=RequestMethod.POST)
	public ModelAndView memberJoinus(Member member,ModelAndView mav) {
		
		//2가지 
		//1. request 객체 사용 - request.getParameter();
		//2. @requestParam(데이터 받을때 사용)
		//3. VO를 이용해서 받는법 활용해보자
		
		//사용자가 입력한 자동으로 데이터를 m에 담아서 보내준다.
		int result=mService.insertMember(member);
		
		
		if(result>0) {
			mav.addObject("msg","회원 가입 성공!");
			mav.addObject("location","/");
		}else
		{
			mav.addObject("msg","회원 가입 실패-지속적인 문제 발생시 관리자에게 문의-");
			mav.addObject("location","/member/joinPage.do");			
	}
		mav.setViewName("member/msg");
		
	return mav;
	
}
	//이메일인증 메일 보내는 로직
	@RequestMapping(value="/member/memberSendEmail.do")
	public void memberSendEmail(HttpServletRequest request) {
		//인증번호 생성
		Random random = new Random();
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		
		while(count<6) {
			int num = random.nextInt(10);
			buffer.append(num);
			count++;
		}
		String checkNum = buffer.toString();
		HttpSession session = request.getSession();
		if(session.getAttribute("checkNum")!=null)
			session.removeAttribute("checkNum");
		
		session.setAttribute("checkNum",checkNum);
		String c =(String)session.getAttribute("checkNum");
		System.out.println(c);
		//메일 전송
		String email = request.getParameter("email");
		boolean check = mss.sendEmail(checkNum, email);
		if(check) {
			System.out.println("이메일 송신 완료");
		}
		else {
			System.out.println("이메일 송신  실패");
		}
		
	}
	
	//이메일 인증 로직
	@RequestMapping(value = "/member/get.do")
	@ResponseBody
	public String ajax(HttpServletRequest request) {

	    HttpSession session = request.getSession();
	    String c =(String)session.getAttribute("checkNum");
		return c;
	}
	
	
	//아이디 중복 확인
	@RequestMapping(value="/member/memberIdCheck.do")
	public void memberIdCheckAjax(@RequestParam String userId ,HttpServletResponse response) throws IOException 
	
	{

		System.out.println("중복 체크할 ID: "+userId);
		int result=mService.selectIdCheck(userId);
		
		//데이터를 보내준다.
		
		if(result>0) {
			response.getWriter().print(true); //true 면 사용 중이라는 의미
			//호출에 응해서, 구문을 써준다(getWriter) 무엇을(true)를
		}else {
			response.getWriter().print(false); //false면 미사용이라는 의미
			
		
	}
	
	}
	
	
	//닉네임 중복 확인
	@RequestMapping(value="/member/memberNickCheck.do")
	public void memberNickCheckAjax(@RequestParam String nick,HttpServletResponse response ) throws IOException 
	{
		
		System.out.println("중복 체크하 nick: "+nick);
		int result=mService.selectNickCheck(nick);
		
		if(result>0) {
			response.getWriter().print(true);// 닉네임이 중복된다.
		}else {
			response.getWriter().print(false);// 닉네임이 중복되지 않는다.
		}
		
		
		
	}
	
	//이메일 중복 확인 
	@RequestMapping(value="/member/memberEmailCheck.do")
	public void memberEmailCheckAjax(@RequestParam String email,HttpServletResponse response) throws IOException {
		
		System.out.println("중복 체크할 email: "+email);
		int result=mService.selectEmailCheck(email);
		
		if(result>0) {
			response.getWriter().print(true);// 닉네임이 중복된다.
		}else {
			response.getWriter().print(false);// 닉네임이 중복되지 않는다.
		}
		
		
		
	}
	
	
	//로그아웃
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session, @SessionAttribute Member member)
	{	
		System.out.println("["+member.getUserId()+"] 로그아웃 ");
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	

	
	
	
	
	
	
	
	
    /**
     * 이미지 리사이징 업로드를 설명하기 위한 예시
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/member/imageUpload.do", method = RequestMethod.POST)
    public String imageUpload(HttpServletRequest request) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "img", "profile");
        info.getFileName();
        System.err.println("img transfer");
        System.err.println(info);                                                                                       // 이동한 파일 정보
        return "index";
    }
	

}
