package kr.go.seoul.democracy.discuss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.go.seoul.common.ImageResizeTemplate;
import kr.go.seoul.common.transfer.ImageTransferInfo;
import kr.go.seoul.democracy.admin.model.vo.Admin;
import kr.go.seoul.democracy.discuss.model.service.DiscussService;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Controller
public class DiscussController {
	@Autowired
	private DiscussService dService;
	
	@Autowired
	@Qualifier(value="basicImageTemplate")
    private ImageResizeTemplate imgTemplate;

	//시민토론 목록 페이지로 이동
	@RequestMapping(value="/discuss/link.do", method = RequestMethod.GET)
	public String discussLink() {
		return "/discuss/list.do";
	}
	
	//시민토론 목록 데이터 가져오기+페이징 처리(더보기)
	@RequestMapping(value="/discuss/list.do", method = RequestMethod.GET)
	public ModelAndView discussList(ModelAndView mav, @RequestParam(defaultValue="1") int currentListPage) {
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
		mav.setViewName("discuss/board");
		
		return mav;
	}
	
	//시민토론 게시글 하나 데이터 가져오기+댓글 페이징 처리(더보기)
	@RequestMapping(value="/discuss/onePost.do", method = RequestMethod.GET)
	public ModelAndView discussOne(ModelAndView mav,@RequestParam int discussNo,@RequestParam int currentCommentPage) {
		//페이징 처리
		int pageSize=5; //한번에 댓글 몇개씩 보여줄건지
		int totalCount=dService.commentTotalCount(discussNo); //해당 게시글에 댓글 총 갯수
		if(currentCommentPage==0) currentCommentPage=1; //게시글 로드할때마다 댓글은 첫 5개씩만 보여준다.
		
		//데이터 가져오기
		Discuss discuss=dService.discussOne(discussNo); //게시글 번호로 해당 게시글 찾기
		ArrayList<HashMap<String, Object>> proComment = dService.proComment(discussNo,pageSize,currentCommentPage);
		ArrayList<HashMap<String, Object>> conComment=dService.conComment(discussNo,pageSize,currentCommentPage); //게시글 번호로 해당 게시글의 반대 댓글 목록 가져오기
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
	
	@RequestMapping(value="/discuss/writeComment.do", method = RequestMethod.GET)
	public ModelAndView writeComment(ModelAndView mav,
									@RequestParam int discussNo,
									@RequestParam String userId,
									@RequestParam String commentContent,
									@RequestParam char commentVote) {
		
		HashMap<String,Object> comment=new HashMap<>();
		comment.put("discussNo", discussNo);
		comment.put("userId",userId);
		comment.put("commentContent",commentContent);
		comment.put("commentVote",commentVote);
		
		return mav;
	}
	
	//시민토론 게시글 작성 폼으로 이동(jsp)
	@RequestMapping(value="/discuss/writeForm.do", method = RequestMethod.GET)
	public String writeForm() {
		return "discuss/write";
	}
	
	//시민토론 게시글 작성
	@RequestMapping(value="/discuss/write.do", method = RequestMethod.GET)
	public ModelAndView write(ModelAndView mav,
							@SessionAttribute Admin admin,
							@RequestParam String title,
							@RequestParam String content,
							@RequestParam String thumbnailName,
							@RequestParam String thumbnailPath) {
		String userId=admin.getAdminId();
		
		Discuss discuss=new Discuss(userId,title,content,thumbnailName,thumbnailPath);
		
		int result=dService.write(discuss);
		if(result>0) mav.setViewName("/discuss/link.do");
		else mav.setViewName("/discuss/error");
		
		return mav;
	}
	
	@RequestMapping(value = "/discuss/imageUpload.do", method = RequestMethod.POST)
    public void ajaxImageUpload(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "upload", "discussImg");

        JsonObject json = new JsonObject();
        String url = "/upload/discussImg/" + info.getFileName();

        json.addProperty("url", url);
        json.addProperty("uploaded", 1);
        json.addProperty("fileName", info.getOriginalFileName());
        new Gson().toJson(json, response.getWriter());
        System.err.println("img transfer");
        System.err.println(info);
    }
		
}
