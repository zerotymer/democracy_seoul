package kr.go.seoul.democracy.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    /// FIELDs

    /// CONSTRUCTROs
    public MainController() {

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
}
