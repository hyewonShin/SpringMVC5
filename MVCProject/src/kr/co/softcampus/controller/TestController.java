package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.service.TestService;

//service에서 구현해놓은 메서드들을 호출해서 controller에서 사용.
//component를 사용하여 bean으로 등록한것은 동일하지만 controller의 역할이라고 명시해주는 어노테이션이다.
@Controller 
public class TestController {
	
	@Autowired
	private TestService testService;

	@GetMapping("/test1")
	public String test1(Model model){
		
			String str = testService.testMethod();
			model.addAttribute("str", str);
		
		return "test1";
	}
}


