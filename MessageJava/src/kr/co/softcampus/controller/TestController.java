package kr.co.softcampus.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	//MessageSource를 주입받는다.
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1(Model model, Locale locale) {

		System.out.println(locale);
		
		String a1 = res.getMessage("aaa.a1", null, null);
		String b1 = res.getMessage("bbb.b1", null, null);
		
		// {} 부분에 셋팅할 값 배열 (2번째 매개변수)
		Object [] args = {30, "홍길동"};
		String a2 = res.getMessage("aaa.a2", args, null);
		
		String a3 = res.getMessage("aaa.a1", null, locale);
		
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(a2);
		System.out.println(a3);
		
		model.addAttribute("args",args);
		
		return "test1";
	}
}


// Properties 파일을 Message로 등록하게 되면 JSP에서도 사용할 수 있으며 다국어 처리도 가능하다.