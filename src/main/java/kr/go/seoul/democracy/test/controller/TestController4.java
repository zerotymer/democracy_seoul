package kr.go.seoul.democracy.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController4 {
	@RequestMapping("/test/onePost.do")
    public String test() {
        return "discuss/testPost";
    }
}
