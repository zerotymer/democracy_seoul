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
	@RequestMapping(value="/discuss/link.do", method = RequestMethod.GET)
	public String discussLink() {
		return "/discuss/list.do";
	}
	
	//시민토론 목록 데이터 가져오기+페이징 처리(더보기)
	@RequestMapping(value="/discuss/list.do", method = RequestMethod.GET)
	public ModelAndView discussList(ModelAndView mav, @RequestParam int currentListPage) {
		//페이징 처리
		int pageSize=12;
		int totalCount=dService.discussTotalCount();
		if(currentListPage==0) currentListPage=1;
		
		//시민토론 목록 데이터 가져오기
		ArrayList<Discuss> list=dService.discussList(pageSize,currentListPage);
		
		mav.addObject("list",list);
		mav.addObject("currentListPage",currentListPage);
		mav.addObject("pageSize",pageSize);
		mav.addObject("pageCount",(int)Math.ceil((double)totalCount/pageSize));
		mav.setViewName("discuss/list");
		
		return mav;
	}
	
	//시민토론 게시글 하나 데이터 가져오기+댓글 페이징 처리(더보기)
	@RequestMapping(value="/discuss/onePost.do", method = RequestMethod.GET)
	public ModelAndView discussOne(ModelAndView mav, @RequestParam int discussNo, @RequestParam int currentCommentPage) {
		
		//페이징 처리
		int pageSize=5; //한번에 댓글 몇개씩 보여줄건지
		int totalCount=dService.commentTotalCount(discussNo); //해당 게시글에 댓글 총 갯수
		if(currentCommentPage==0) currentCommentPage=1; //게시글 로드할때마다 댓글은 첫 5개씩만 보여준다.
		
		//데이터 가져오기
		Discuss discuss=dService.discussOne(discussNo); //게시글 번호로 해당 게시글 찾기
		ArrayList<DiscussComment> proComment=dService.proComment(discussNo,pageSize,currentCommentPage); //게시글 번호로 해당 게시글의 찬성 댓글 목록 가져오기
		ArrayList<DiscussComment> conComment=dService.conComment(discussNo,pageSize,currentCommentPage); //게시글 번호로 해당 게시글의 반대 댓글 목록 가져오기
		ArrayList<DiscussFile> file=dService.file(discussNo); //게시글 번호로 해당 게시글의 파일 목록 가져오기
		
		mav.addObject("discuss",discuss);
		mav.addObject("pro",proComment);
		mav.addObject("con",conComment);
		mav.addObject("currentCommentPage",currentCommentPage);
		mav.addObject("pageSize",pageSize);
		mav.addObject("pageCount",(int)Math.ceil((double)totalCount/pageSize));
		mav.addObject("file",file);
		
		if(discuss!=null) mav.setViewName("discuss/post"); //해당 게시글을 찾아 게시글 페이지로 이동
		else mav.setViewName("discuss/error"); //해당 게시글을 찾지 못했을 경우 에러 페이지로 이동
		
		return mav;
	}
	
	//시민토론 게시글 작성 폼으로 이동(jsp)
	@RequestMapping(value="/discuss/writeForm.do", method = RequestMethod.GET)
	public String writeForm() {
		return "discuss/write";
	}
	
	//시민토론 게시글 작성
	@RequestMapping(value="/discuss/write.do", method = RequestMethod.GET)
	public ModelAndView write(ModelAndView mav) {
		
		
		return mav;
	}
		
}
