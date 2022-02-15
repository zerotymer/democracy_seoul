package kr.go.seoul.democracy.discuss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.go.seoul.common.FileTransferTemplate;
import kr.go.seoul.common.ImageResizeTemplate;
import kr.go.seoul.common.transfer.FileTransferInfo;
import kr.go.seoul.common.transfer.ImageTransferInfo;
import kr.go.seoul.democracy.admin.model.vo.Admin;
import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.discuss.model.service.DiscussService;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.discuss.model.vo.DiscussFile;

@Controller
public class DiscussController {
	@Autowired
	private DiscussService dService;
	
	@Autowired
	@Qualifier("basicImageTemplate")
    private ImageResizeTemplate imgTemplate;
	
	@Autowired
	@Qualifier("discussionImageTemplate")
	private ImageResizeTemplate thumbnailTemplate;
	
	@Autowired
	@Qualifier("fileTransferTemplate")
	private FileTransferTemplate fileTransferTemplate;

	//시민토론 목록 데이터 가져오기+페이징 처리(더보기)
	@RequestMapping(value="/discuss/list.do", method = RequestMethod.GET)
	public ModelAndView discussList(ModelAndView mav, @RequestParam(defaultValue="1") int currentListPage) {
		//페이징 처리
		int pageSize=12;
		int totalCount=dService.discussTotalCount();

		//시민토론 목록 데이터 가져오기
		ArrayList<Discuss> list=dService.discussList(pageSize,currentListPage);
		
		mav.addObject("list",list);
		mav.addObject("currentListPage",currentListPage);
		mav.addObject("pageSize",pageSize);
		mav.addObject("pageCount",(int)Math.ceil((double)totalCount/pageSize));
		mav.setViewName("discuss/board");
		
		return mav;
	}
	
	//댓글 더보기
	@RequestMapping(value="/discuss/getList.ajax", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Discuss> getList(@RequestParam(defaultValue="1") int currentListPage){
		currentListPage++;
		int pageSize=12;
		
		ArrayList<Discuss> list=dService.getList(currentListPage,pageSize);
		
		return list;
	}
	
	//시민토론 게시글 하나 데이터 가져오기+댓글 페이징 처리(더보기)
	@RequestMapping(value="/discuss/onePost.do", method = RequestMethod.GET)
	public ModelAndView discussOne(ModelAndView mav,
								@RequestParam int discussNo,
								HttpServletRequest request) {
		//페이징 처리
		int pageSize=5; //한번에 댓글 몇개씩 보여줄건지
		int totalCount=dService.commentTotalCount(discussNo); //해당 게시글에 댓글 총 갯수
		int currentCommentPage=1;

		//데이터 가져오기
		Discuss discuss=dService.discussOne(discussNo); //게시글 번호로 해당 게시글 찾기
		ArrayList<HashMap<String, Object>> proComment = dService.proComment(discussNo,pageSize,currentCommentPage);
		ArrayList<HashMap<String, Object>> conComment=dService.conComment(discussNo,pageSize,currentCommentPage); //게시글 번호로 해당 게시글의 반대 댓글 목록 가져오기
		ArrayList<DiscussFile> file=dService.file(discussNo); //게시글 번호로 해당 게시글의 파일 목록 가져오기
		HashMap<String,Object> vote=dService.getVote(discussNo);
		
		mav.addObject("discuss",discuss);
		mav.addObject("pro",proComment);
		mav.addObject("con",conComment);
		if(vote!=null) mav.addObject("vote",vote);
		mav.addObject("totalCount",totalCount);
		//mav.addObject("currentCommentPage",currentCommentPage);
		//mav.addObject("pageSize",pageSize);
		//mav.addObject("pageCount",(int)Math.ceil((double)totalCount/pageSize));
		mav.addObject("file",file);
		
		HttpSession session=request.getSession();
		Member user=(Member)session.getAttribute("user");
		HashMap<String, Object> comment=null;
		if(user!=null) {
			String userId=user.getUserId();
			comment=dService.myComment(discussNo,userId);
		}
		if(comment!=null) mav.addObject("my",comment);
		
		if(discuss!=null) mav.setViewName("discuss/post"); //해당 게시글을 찾아 게시글 페이지로 이동
		else mav.setViewName("discuss/error"); //해당 게시글을 찾지 못했을 경우 에러 페이지로 이동
		
		return mav;
	}
	
	//투표하기
	@RequestMapping(value="/discuss/vote.ajax", method = RequestMethod.GET)
	@ResponseBody
	public int vote(@RequestParam int discussNo,
					@RequestParam(defaultValue="0") int votePro,
					@RequestParam(defaultValue="0") int voteCon){
		HashMap<String,Object> vote=new HashMap<String,Object>();
		vote.put("discussNo", discussNo);
		vote.put("votePro", votePro);
		vote.put("voteCon", voteCon);
		int result=dService.vote(vote);
		
		return result;
	}
	
	//댓글 더보기
	@RequestMapping(value="/discuss/getComment.ajax", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<HashMap<String, Object>> getComment(@RequestParam int discussNo,
									@RequestParam(defaultValue="1") int currentCommentPage){
		currentCommentPage+=1;
		int pageSize=5;
		
		ArrayList<HashMap<String, Object>> comment=dService.getComment(discussNo,currentCommentPage,pageSize);
		
		return comment;
	}
	
	//댓글 작성
	@ResponseBody
	@RequestMapping(value="/discuss/writeComment.ajax", method = RequestMethod.GET)
	public int writeComment(@SessionAttribute Member user,
							@RequestParam int discussNo,
							@RequestParam String commentContent,
							@RequestParam String vote) {
		
		String userId=user.getUserId();
		char commentVote=vote.charAt(0);
		
		HashMap<String,Object> comment=new HashMap<>();
		comment.put("discussNo", discussNo);
		comment.put("userId",userId);
		comment.put("commentContent",commentContent);
		comment.put("commentVote",commentVote);

		int result=dService.writeComment(comment);
		
		return result;
	}
	
	//시민토론 게시글 작성 폼으로 이동(jsp)
	@RequestMapping(value="/discuss/writeForm.do", method = RequestMethod.GET)
	public String writeForm() {
		return "discuss/write";
	}
	
	//시민토론 게시글 작성
	@RequestMapping(value="/discuss/write.do")
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
	
	//게시글  작성 시 이미지 불러오기
	@RequestMapping(value = "/discuss/imageUpload.ajax", method = RequestMethod.POST)
    public void ajaxImageUpload(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "upload", "discuss");

        JsonObject json = new JsonObject();
        String url = "/upload/discuss/" + info.getFileName();

        json.addProperty("url", url);
        json.addProperty("uploaded", 1);
        json.addProperty("fileName", info.getOriginalFileName());
        new Gson().toJson(json, response.getWriter());
    }
	
	//썸네일 업로드
	@RequestMapping(value = "/discuss/thumbnailUpload.ajax", method = RequestMethod.POST)
    public void thumbnailUpload(HttpServletRequest request,HttpServletResponse response) throws IOException {
        ImageTransferInfo info = (ImageTransferInfo) imgTemplate.fileTransfer(request, "img", "discuss");
        JsonObject json = new JsonObject();
        json.addProperty("fileName", info.getFileName());
        json.addProperty("imgUrl", "/upload/discuss/"+info.getFileName("thumbnail"));
        new Gson().toJson(json,response.getWriter());
    }
	
	//파일 업로드
	@RequestMapping(value = "/discuss/fileUpload.ajax", method = RequestMethod.POST)
    public void fileUpload(HttpServletRequest request,HttpServletResponse response) throws IOException {
		FileTransferInfo info = (FileTransferInfo) fileTransferTemplate.fileTransfer(request, "file", "discuss");
        String name=info.getFileName();
        String path=info.getAbsolutePath();
        String originalName=info.getOriginalFileName();
        int result=dService.fileUpload(name,path);
        JsonObject json = new JsonObject();
        json.addProperty("result",result);
        json.addProperty("originalName",originalName);
		new Gson().toJson(json,response.getWriter());
    }
}
