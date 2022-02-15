package kr.go.seoul.democracy.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.member.model.service.MailSendService;
import kr.go.seoul.democracy.member.model.service.MemberService;
import kr.go.seoul.democracy.member.model.vo.MemberProfile;

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
	
	
    //로그인 페이지에서 '비밀번호 찾기 페이지'로 가는 로직
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
	
	
	 //아이디 찾기 페이지로 이동하는 메소드
	  @RequestMapping(value="/member/goSearchIdResult.do",method=RequestMethod.GET)
	  public String goMemberSearchIdResult() {
			
			return "member/memberSearchId";
		}
	  
	  
	  //비밀번호 찾기시 이메일 인증 페이지로 가는 로직
	  @RequestMapping(value="/member/goMemberSearchPwdEmailCheck.do")
	  public String goMemberSearchPwdEmailCheck() {
		
		  return "member/memberSearchPwdEmailCheck";

	  }
	   //이메일 변경 페이지 이동
	  @RequestMapping(value="/member/goMemberUpdateEmail.do")
	  public String goResetEmailCheck() {
		  
		  return "member/memberUpdateEmail";
	  }
	  
	
	
	 
	
		//메인 화면에서 마이 페이지로 이동하는 로직
		@RequestMapping(value="/member/goMyPage.do",method=RequestMethod.GET)
		public String goMyPage(HttpServletRequest request,Model model) {
			HttpSession session = request.getSession();
			Member m = (Member)session.getAttribute("user");//
			System.out.println("마이페이지 이동시 담겨있는것"+m.toString());
			MemberProfile mf = mService.selcetMemberProfile(m);
			//System.out.println(mf.toString());
			model.addAttribute("user",m);//
			model.addAttribute("mf", mf);
			return "member/myPage";
		}
		
		
		//마이페이지에서 정보 수정으로 이동하는 로직
		@RequestMapping(value="/member/goMyPageUpdate.do",method=RequestMethod.GET)
		public String goMyPageUpdate(HttpServletRequest request,Model model) {
			HttpSession session = request.getSession();
			Member m = (Member)session.getAttribute("user");//
			//System.out.println(m.toString());
			MemberProfile mf = mService.selcetMemberProfile(m);
			model.addAttribute("user",m);//
			model.addAttribute("mf", mf);
			return "member/myPageModify";
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
		session.setAttribute("user",m);
		model.addAttribute("msg","로그인 성공하였습니다.");
		model.addAttribute("location","redirect:/");
		return "member/msg";
		//return "redirect:/";
		//return "member/memberLogin";
		//return "redirect:/member/goMyPage.do";
	}else {
		model.addAttribute("msg","로그인의 실패하였습니다.아이디와 비밀번호 확인해주세요.");
		model.addAttribute("location","/member/goLogin.do");
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
			mav.addObject("location","/");			
	}
		mav.setViewName("member/msg");
		
	return mav;
	
}
	//이메일인증 메일 보내는 로직
	@RequestMapping(value="/member/memberSendEmail.do")
	public void memberSendEmail(@RequestParam String email, HttpServletRequest request) {
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

		System.out.println("get.do 호출");
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
			response.getWriter().print(true);// 이메일이 중복된다.
		}else {
			response.getWriter().print(false);// 이메일이 중복되지 않는다.
		}
		
		
		
	}
	
	
	//로그아웃
	
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session, @SessionAttribute Member user)
	{	
		System.out.println("["+user.getUserId()+"] 로그아웃 ");
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	
	//아이디 찾기 로직
	@RequestMapping(value="/member/memberSearchId.do", method=RequestMethod.GET)
	public String memberSearchId(HttpServletRequest request,Model model,Member member) {
		
		
		
		System.out.println("SearchId 로직 정상 호출");
		System.out.println(member.toString());
		Member m = mService.searchId(member);
		
		if(m!=null)
		{   //이름과 이메일이 일치한다면 아이디 값을 보내준다.
			System.out.println("아이디 찾기 성공");
			model.addAttribute("userId",m.getUserId());
			model.addAttribute("enrollDate",m.getEnrollDate());
			return "member/memberSearchIdResult";
		}else {//아이디 찾기 실패할시
			model.addAttribute("msg","아이디 찾기 실패하였습니다.이메일과 이름을 확인해주세요.");
			model.addAttribute("location","/member/goMemberSearchId.do");
			return "member/msg";
		}
		
		}
	
	
		//비밀번호 찾기 로직
	  @RequestMapping(value="/member/memberSearchPwd.do", method=RequestMethod.POST)
	  public String memberSearchPwd(HttpServletRequest request,Model model,Member member) {
		  //1.입력한 아이디와 이메일을 받아오기
		  //2.두개가 일치한다면 이메일로 인증 코드 보내주기
		  //3.인증코드 확인하는 jsp페이지로 보내주기
		  
			System.out.println("SearchPwd 로직 정상 호출");
			System.out.println(member.toString());
			Member m = mService.searchPwd(member);
			
			
			if(m!=null)
			{   //이메일과 아이디가 일치한다면 인증코드를 비밀번호에 보내준다.
				System.out.println("아이디와 이메일 찾기 일치");
				model.addAttribute("msg","아이디와 이메일 일치.");
				model.addAttribute("userId",m.getUserId());
				model.addAttribute("email",m.getEmail());
				
				return "redirect:/member/goMemberSearchPwdResult.do";
			}else {//아이디 찾기 실패할시
				model.addAttribute("msg","비밀번호 찾기 실패하였습니다.이메일과 이름을 확인해주세요.");
				model.addAttribute("location","/member/goMemberSearchPwd.do");
				return "member/msg";
			} 
		  
	  }
	  
	  
	  
	  //비번 찾기시 이메일 본인 인증되면 비밀번호 재설정 페이지로 이동하는 로직
	  @RequestMapping(value="/member/goMemberSearchPwdResult.do")
	  public String goMemberSearchPwdResult(HttpServletRequest request,Model model) {
		  String userId =request.getParameter("userId");
		  model.addAttribute("userId",userId);
		  return "member/memberSearchPwdResult";

		  
	  }
	  
	  
	  //비밀번호 찾기 후 비번  변경하는 로직
	  @RequestMapping(value="/member/memberUpdatePassword.do")
	  public String resetPassword(HttpServletRequest request,Model model,Member member) throws IOException
	  {
		    //유저가 입력한 변경할 패스워드를 받는다.
		    System.out.println("updatePwd 로직 정상 호출");
			System.out.println(member.toString());
			int result = mService.resetPassword(member);

			
			 if(result>0)
			{	System.out.println("비밀번호 재설정 성공");
			    HttpSession session = request.getSession(true);
		    	session.setAttribute("PwdResult", true);
				model.addAttribute("msg","비밀번호 재설정에 성공하였습니다.로그인해주세요.");
				model.addAttribute("location","/member/goLogin.do");
				return "member/msg";

			}else
			{request.setAttribute("pwdResult",false);
			 model.addAttribute("msg","비밀번호 찾기 실패하였습니다.이메일과 이름을 확인해주세요.");
			 model.addAttribute("location","/member/goMemberSearchPwdResult.do");
			 return "member/msg";
			
			}
				

	  }
	  
	  
	  //마이페이지에서 이메일인증 후 변경하는 로직
	  @RequestMapping(value="/member/memberUpdateEmail.do")
	  public String memberUpdateEmail(HttpServletRequest request,Model model,@RequestParam String email) throws IOException
	  {
		    //유저가 입력한 변경할 패스워드를 받는다.
		    //System.out.println("UpdateEmail 로직 정상 호출");
			//System.out.println(member.toString());
			//int result = mService.memberUpdateEmail(member);
		  
		   HttpSession session = request.getSession();
		   Member m = (Member)session.getAttribute("user");
		   Map<String,String> Map = new HashMap<>();
		   Map.put("email", email);
		   Map.put("userId",m.getUserId());

			
		  int result = mService.memberUpdateEmail(Map);
		  
			 if(result>0)
			{	System.out.println("이메일 재설정 성공");
			    session = request.getSession(true);
			    session.removeAttribute("user");//
			    System.out.println(m.toString());
			    Member changeMember = mService.selectMemberById(m.getUserId());
		        session.setAttribute("user", changeMember);
		    	session.setAttribute("EmailResult", true);
				model.addAttribute("msg","이메일 변경에 성공하였습니다.");
				model.addAttribute("location","/member/goMypage.do");
				return "member/msg";

			}else
			{request.setAttribute("pwdResult",false);
			 model.addAttribute("msg","이메일 변경에 실패하였습니다.");
			 model.addAttribute("location","/member/goMemberUpdateEmail.do");
			 return "member/msg";
			
			}
				

	  }
	
	
	
	
	
	

	
	
	
    /**
     * 이미지 리사이징 업로드를 설명하기 위한 예시
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/member/imageUpload.do", method = RequestMethod.POST)
    public String imageUpload(HttpServletRequest request) throws IOException {
    	MemberProfile memberProfile = new MemberProfile();
    	HttpSession session = request.getSession();
		//session.getAttribute("");
		Member m = (Member)session.getAttribute("user");//
		System.out.println(m.toString());
		MemberProfile mf = mService.selcetMemberProfile(m);
		memberProfile.setUserId(m.getUserId());
		try {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "img", "profile");
        System.out.println(info.getFileName());
        memberProfile.setProfileName(info.getFileName());
        memberProfile.setProfileFilePath(info.getAbsolutePath());
        if(mf==null) 
        	mService.insertMemberProfile(memberProfile);//아이디로 올라온게 없으면 넣어주고
        else
        	mService.updateMemberProfile(memberProfile);//있으면 수정해준다.
        return "redirect:/member/goMyPage.do";
		}
		catch(Exception e) {
			return "redirect:/member/goMyPage.do";
		}
    }
    
    
    
      //마이페이지 비밀번호 변경
	  @RequestMapping(value="/member/goMypageUpdatePwd.do")
	  public String goMypageUpdatePwd() {
;
		   return "member/myPageUpdatePwd";

	  }
	  
	  
	  //마이 페이지에서 비밀번호 변경로직
	  @RequestMapping(value="/member/MypageUpdatePassword.do", method=RequestMethod.POST)
	  public String myPageUpdatePassword(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam String memberOriginalPass,@RequestParam String memberNewPass) throws IOException
	  {//memberOriginalPass,memberNewPass,“userPwd”
		  

		   HttpSession session = request.getSession();
		   Member m = (Member)session.getAttribute("user");
		   //System.out.println("비번변경시 갖고있는 데이터 : "+m);
		   HashMap<String,String> map = new HashMap<>();
		   map.put("userOriginalPass", memberOriginalPass);
		   map.put("userNewPass", memberNewPass);
		   map.put("userId",m.getUserId());
		   System.out.println("마이페이지 비밀번호 변경 컨트롤러 부분:"+map);
		   
		  int result = mService.myPageUpdatePassword(map);
		  
			if(result>0)
			{   
			System.out.println("비밀번호 재설정 성공");
			session = request.getSession(true);
		    session.setAttribute("MyPagePwdResult", true);
			model.addAttribute("msg","비밀번호 변경에 성공하였습니다.");
			model.addAttribute("location","/member/goMypage.do");//
			return "member/msg";
			}else
			{  System.out.println("비밀번호 재설정 실패");
			    model.addAttribute("msg","비밀번호 변경에 실패하였습니다.");
				return "redirect:/member/goMyPage.do";
			}
			
		   
	
	  }
	  
	  //마이 페이지에서 삭제 페이지로 가는 로직
	  @RequestMapping(value="/member/goMypageWithdraw.do")
	  public String goMypageWithdraw() {
		  
		  return "member/myPageWithdraw";

	  }
	  
	  
	  
	  	//마이 페이지에서 회원 삭제로직
		@RequestMapping(value="/member/memberWithdraw.do",method=RequestMethod.POST)
		public String memberWithDraw(HttpServletRequest request, Model model, @SessionAttribute Member user,
				HttpSession session)
		throws IOException
		{	
			System.out.println("회원삭제 로직 정상구동");
			
			String userPwd = request.getParameter("userPwd");
			
			if(userPwd == null)
			{
				return "member/myPageWithdraw";
			}
			
		
			String userId = user.getUserId();
			
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("userId", userId);
			map.put("userPwd", userPwd);
			
			System.out.println("삭제로직 컨틀롤러"+map);
			
			int result = mService.updateMemberWithdraw(map);
			
			if(result>0)
			{
				session.invalidate();
				
				model.addAttribute("msg","정상적으로 탈퇴 처리 되었습니다.");
				model.addAttribute("location","/");
				
			}else
			{
				model.addAttribute("msg", "비밀번호가 일치하지 않습니다. 재확인해주세요");
				model.addAttribute("location", "/member/goMypageWithdraw.do");
			}
			
			return "member/msg";
	
			
			
			
		}
		
	     //마이 페이지에서 닉네임 변경로직
		@RequestMapping(value="/member/goMemberUpdateNick.do")
		public String goMemberUpdateNick() {
			
			return "member/myPageUpdateNick";
		}
		
		
		
		 //마이 페이지에서 닉네임 변경로직
		  @RequestMapping(value="/member/myPageUpdateNick.do")
		  public String myPageUpdatePassword(HttpServletRequest request,HttpServletResponse response,Model model,@RequestParam String nick) throws IOException
		  {//memberOriginalPass,memberNewPass,“userPwd”
			  
			   HttpSession session = request.getSession();
			   Member m = (Member)session.getAttribute("user");
			   //System.out.println("비번변경시 갖고있는 데이터 : "+m);
			   Map<String,String> Map = new HashMap<>();
			   Map.put("nick", nick);
			   Map.put("userId",m.getUserId());
			   System.out.println(Map);
			   
			   
			  int result = mService.myPageUpdateNick(Map);
			  
				if(result>0)
				{   
				System.out.println("닉네임 재설정 성공");
				session = request.getSession(true);
				session.removeAttribute("user");//
				Member changeMember = mService.searchId(m);
			    session.setAttribute("nickResult", true);
			    session.setAttribute("user", changeMember);
				model.addAttribute("msg","닉네임 변경에 성공하였습니다.");
				model.addAttribute("location","/member/goMypage.do");
				return "member/msg";
				}else
				{  System.out.println("닉네임 재설정 실패");
					response.getWriter().print(false);
					return "/member/goMypage.do";
				}
				
			   
		
		  }

		  
		  
		  
    
    
}
