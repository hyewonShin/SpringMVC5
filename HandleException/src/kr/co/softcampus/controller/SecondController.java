package kr.co.softcampus.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

	@GetMapping("/test2")
	public String test2() {
		
		ArrayList<String> list = null;
		list.add("문자열");
		// list 에 null 값이 들어가있는 데, 문자열을 넣었기 때문에 오류가 발생한다.
		// NullPointerException 발생 
		
		return "test2";
	}
	
	//@ExceptionHandler(java.lang.NullPointerException.class)
	//public String exception2() {
	//	return "error2";
	//}
}

// 해당 Controller에 예외처리가 없어도, Global 예외처리로 에러 처리 됌.
