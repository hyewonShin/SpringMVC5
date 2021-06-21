package kr.co.softcampus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//하위 경로 통합 

@Controller
@RequestMapping("/sub2")
public class Sub2Controller {
	@RequestMapping(value = "/test5", method = RequestMethod.GET)
	public String sub1Test5() {
		return "sub2/test5";
	}
	@RequestMapping(value = "/test6", method = RequestMethod.GET)
	public String sub1Test6() {
		return "sub2/test6";
		
	}
}