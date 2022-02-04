package kr.go.seoul.democracy.discuss.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.go.seoul.democracy.discuss.model.service.DiscussService;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussComment;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Controller
public class DiscussController {
	@Autowired
	private DiscussService dService;
	
	//시민토론 목록 페이지로 이동
	@RequestMapping(value="/discuss/link.do", method = RequestMethod.POST)
	public String discussLink() {
		return "discuss/list";
	}
	
	//시민토론 목록 데이터 가져오기
	@RequestMapping(value="/discuss/list.do", method = RequestMethod.POST)
	public ModelAndView discussList(ModelAndView mav) {
		ArrayList<Discuss> list=dService.discussList();
		
		mav.addObject("list",list);
		mav.setViewName("discuss/list");
		
		return mav;
	}
	
	//시민토론 게시글 하나 데이터 가져오기
	@RequestMapping(value="/discuss/onePost.do", method = RequestMethod.POST)
	public ModelAndView discussOne(ModelAndView mav, @RequestParam int discussNo) {
		Discuss discuss=dService.discussOne(discussNo); //게시글 번호로 해당 게시글 찾기
		ArrayList<DiscussComment> proComment=dService.proComment(discussNo); //게시글 번호로 해당 게시글의 찬성 댓글 목록 가져오기
		ArrayList<DiscussComment> conComment=dService.conComment(discussNo); //게시글 번호로 해당 게시글의 반대 댓글 목록 가져오기
		ArrayList<DiscussFile> file=dService.file(discussNo); //게시글 번호로 해당 게시글의 파일 목록 가져오기
		
		mav.addObject("discuss",discuss);
		mav.addObject("pro",proComment);
		mav.addObject("con",conComment);
		mav.addObject("file",file);
		
		if(discuss!=null) mav.setViewName("discuss/post"); //해당 게시글을 찾아 게시글 페이지로 이동
		else mav.setViewName("discuss/error"); //해당 게시글을 찾지 못했을 경우 에러 페이지로 이동
		
		return mav;
	}
	
}
