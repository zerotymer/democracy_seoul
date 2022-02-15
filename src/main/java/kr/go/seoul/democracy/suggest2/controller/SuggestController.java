package kr.go.seoul.democracy.suggest2.controller;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.suggest2.model.service.SuggestService;
import kr.go.seoul.democracy.suggest2.model.vo.Suggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class SuggestController {
    /// FIELDs
    private SuggestService service;

    /// CONSTRUCTOR
    @Autowired
    public SuggestController(@Qualifier("suggestService") SuggestService service) {
        this.service = service;
    }

    /// METHODs

    /**
     * 게시글(제안)을 작성하기 위한 페이지로 이동한다.
     * @param response
     * @param member 현재 로그인한 사용자 정보
     * @param suggestNo 수정할 게시글 번호. 0(기본값) 일 경우 새로운 글을 작성한다.
     * @param mav
     * @return
     * @throws IOException
     * @author 신현진
     */
    @RequestMapping(value="/suggest2/writePost.do", method=RequestMethod.GET)
    public ModelAndView moveNewPostPage(HttpServletResponse response,
                                        @SessionAttribute("user") Member member,
                                        @RequestParam(defaultValue = "0") int suggestNo,
                                        ModelAndView mav) throws IOException {
        response.setCharacterEncoding("UTF-8");

        if (member == null) {
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인이 필요합니다.'); location.href='/member/goLogin.do';</script>");
            out.close();
            mav.setViewName("");
            return mav;
        }

        if (suggestNo != 0) {
            Suggest suggest = service.selectPost(suggestNo);
            mav.addObject("suggest", suggest);
            if (!suggest.getUserId().equals(member.getUserId())) {
                PrintWriter out = response.getWriter();
                out.println("<script>alert('작성자만 수정이 가능합니다.'); location.href='/suggest/suggest.do';</script>");
                out.close();
                mav.setViewName("");
                return mav;
            }
        }
        else mav.addObject("suggest", new Suggest());

        mav.addObject("suggestNo", suggestNo);
        mav.setViewName("suggest2/suggestForm");
        return mav;
    }

    /**
     * 게시글(제안)을 수정한다.
     * @param response
     * @param member 현재 로그인한 사용자 정보
     * @param suggest 수정할 게시글 정보
     * @throws IOException
     * @author 신현진
     */
    @RequestMapping(value="/suggest2/update.do", method=RequestMethod.POST)
    public void createPost(HttpServletResponse response,
                                   @SessionAttribute("user") Member member,
                                   Suggest suggest) throws IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        if (member == null) {
            out.println("<script>alert('로그인이 필요합니다.'); location.href='/member/goLogin.do';</script>");
            out.close();
        }

        suggest.setUserId(member.getUserId());
        // Business 로직
        boolean result = false;
        if (suggest.getSuggestNo() == 0) result = service.insertPost(suggest);
        else result = service.updatePost(suggest);

        if (result) out.println("<script>alert('저장되었습니다.'); location.href='/suggest/suggest.do';</script>");
        else out.println("<script>alert('저장에 실패하였습니다.'); history.back();</script>");
        out.close();
    }

    /**
     * 게시글 목록(제안-완료)을 조회한다.
     * @param response
     * @param mav
     * @return
     * @throws IOException
     * @author 신현진
     */
    @RequestMapping(value="/suggest2/listExpired.do", method=RequestMethod.GET)
    public ModelAndView moveDoneListPage(HttpServletResponse response,
                                         @RequestParam(defaultValue = "1") int currentPage,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         ModelAndView mav) throws IOException {

        mav.addObject("list", service.selectDonePost(currentPage, pageSize));
        mav.addObject("currentPage", currentPage);
        mav.addObject("pageSize", pageSize);
        mav.setViewName("suggest2/suggestList");
        return mav;
    }

    /**
     * 게시글 목록(제안-완료)을 조회한다.
     * @param response
     * @param currentPage
     * @param pageSize
     * @param mav
     * @return
     * @throws IOException
     * @author 신현진
     */
    @ResponseBody
    @RequestMapping(value="/suggest2/listExpired.ajax", method=RequestMethod.GET)
    public ArrayList<HashMap<String, Object>> moveDoneListPage(HttpServletResponse response,
                                               @RequestParam(defaultValue = "1") int currentPage,
                                               @RequestParam(defaultValue = "10") int pageSize) throws IOException {

        return service.selectDonePost(currentPage, pageSize);
    }


}
