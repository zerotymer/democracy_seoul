package kr.go.seoul.democracy.main.controller;

import kr.go.seoul.democracy.main.model.service.MainService;
import kr.go.seoul.democracy.main.model.vo.KeywordType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MainController {
    /// FIELDs
    private MainService service;

    /// CONSTRUCTROs
    @Autowired
    public MainController(@Qualifier("mainService") MainService service) {
        this.service = service;
    }

    /// METHODs
    @RequestMapping(value="/main/introduce.do", method = RequestMethod.GET)
    public String moveIntroduce() {
        return "main/introduce";
    }
    
    @RequestMapping(value="/main/moveSearch.do", method = RequestMethod.GET)
    public String moveSearch() {
    	return "main/search";
    }
    
    @RequestMapping(value="/main/search.go", method = RequestMethod.GET)
    public String search() {
    	return "main/search";
    }




    @RequestMapping("/main/list.do")
    public ModelAndView getList(ModelAndView mav) {
        ArrayList<HashMap<String, Object>> list = service.selectLatestSuggest(4);
        list.addAll(service.selectLatestDiscuss(4));
        list.addAll(service.selectLatestProposal(4));
        mav.setViewName("index");
        mav.addObject("list", list);
        return mav;
    }

    @ResponseBody
    @RequestMapping("/main/list.ajax")
    public ArrayList<HashMap<String, Object>> getListAjax() {
        ArrayList<HashMap<String, Object>> list = service.selectLatestSuggest(4);
        list.addAll(service.selectLatestDiscuss(4));
        list.addAll(service.selectLatestProposal(4));
        return list;
    }

    @RequestMapping(value="/main/search.do", method = RequestMethod.GET)
    public ModelAndView getSearch(ModelAndView mav,
                                  @RequestParam (defaultValue="") String keyword,
                                  @RequestParam (defaultValue="1") int currentPage,
                                  @RequestParam (defaultValue="3") int pageSize) {
        ArrayList<HashMap<String, Object>> suggest;
        ArrayList<HashMap<String, Object>> proposal;

        // 키워드 길이 제한
        if (keyword.length() >= 2) {
            suggest = service.selectSearchKeyword(currentPage, pageSize, keyword, KeywordType.SUGGEST);
            proposal = service.selectSearchKeyword(currentPage, pageSize, keyword, KeywordType.PROPOSAL);
        }
        else {
            suggest = new ArrayList<HashMap<String, Object>>();
            proposal = new ArrayList<HashMap<String, Object>>();
        }

        // 키워드 강조 및 추가
        suggest.stream().forEach(item -> {
            item.put("TITLE", ((String)item.get("TITLE")).replaceAll(keyword, String.format("<strong>%s</strong>", keyword)));
            item.put("CONTENT", ((String)item.get("CONTENT")).replaceAll(keyword, String.format("<strong>%s</strong>", keyword)));
            item.put("URL", String.format("/suggest/suggestview.do?sugNum=%s", item.get("BOARDNO")));
        });
        proposal.stream().forEach(item -> {
            item.put("TITLE", ((String)item.get("TITLE")).replaceAll(keyword, String.format("<strong>%s</strong>", keyword)));
            item.put("CONTENT", ((String)item.get("CONTENT")).replaceAll(keyword, String.format("<strong>%s</strong>", keyword)));
            item.put("URL", String.format("/proposal/post.do?proposalNo=%s", item.get("BOARDNO")));
        });

        mav.setViewName("main/search");
        mav.addObject("suggest", suggest);
        mav.addObject("proposal", proposal);
        mav.addObject("count", service.selectCountKeyword(keyword));
        mav.addObject("keyword", keyword);
    	return mav;
    }

    @ResponseBody
    @RequestMapping("/main/search.ajax")
    public ArrayList<HashMap<String, Object>> getSearchAjax(
            @RequestParam (defaultValue="") String keyword) {

        if (keyword.length() < 2) return new ArrayList<HashMap<String, Object>>();

        ArrayList<HashMap<String, Object>> list = service.selectSearchKeyword(keyword);
        // 키워드 강조 및 추가
        list.stream().forEach(item -> {
            item.put("TITLE", ((String)item.get("TITLE")).replaceAll(keyword, String.format("<strong>%s</strong>", keyword)));
            item.put("CONTENT", ((String)item.get("CONTENT")).replaceAll(keyword, String.format("<strong>%s</strong>", keyword)));
            switch(item.get("CATEGORY").toString()) {
                case "SUGGEST":
                    item.put("URL", String.format("/suggest/suggestview.do?sugNum=%s", item.get("BOARDNO")));
                    break;
                case "PROPOSAL":
                    item.put("URL", String.format("/proposal/post.do?proposalNo=%s", item.get("BOARDNO")));
                    break;
            }
        });
        return list;
    }
}
