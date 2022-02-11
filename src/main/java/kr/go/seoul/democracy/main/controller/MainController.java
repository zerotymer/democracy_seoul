package kr.go.seoul.democracy.main.controller;

import kr.go.seoul.democracy.main.model.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @RequestMapping("/main/introduce.do")
    public String moveIntroduce() {
        return "main/introduce";
    }
    
    @RequestMapping("/main/moveSearch.do")
    public String moveSearch() {
    	return "main/search";
    }
    
    @RequestMapping("/main/search.do")
    public String search() {
    	return "";
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

    /// AJAX
    @ResponseBody
    @RequestMapping("/main/list.ajax")
    public ArrayList<HashMap<String, Object>> getList() {
        ArrayList<HashMap<String, Object>> list = service.selectLatestSuggest(4);
        list.addAll(service.selectLatestDiscuss(4));
        list.addAll(service.selectLatestProposal(4));
        return list;
    }
}
