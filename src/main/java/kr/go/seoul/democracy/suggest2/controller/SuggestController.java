package kr.go.seoul.democracy.suggest2.controller;

import kr.go.seoul.democracy.common.model.vo.Member;
import kr.go.seoul.democracy.suggest2.model.service.SuggestService;
import kr.go.seoul.democracy.suggest2.model.vo.Suggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

}
