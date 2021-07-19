package kr.co.softcampus.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(Model model) {
		
//		int[] array1 = {10,20,30};
//		//model.addAttribute("array1",array1[0]);
//		model.addAttribute("array1",array1[10]);
//		
		ArrayList<String> list = null;
		list.add("문자열");
		// NullPointerException 발생 
		
		return "test1";
	}
	
	
	//오류가 났을 때 jsp 화면에서 보여 줄 페이지 매핑 
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String exeception1() {
		return "error1";
	}
	
}


// @ExceptionHandler
// 해딩 오류가 났을 때 보여줄 페이지로 전환 

// @Global Exception Handler
// Controller에 정의한 ExceptionHandler 중에 해당 오류에 대한 것이 없다면 
// Global Exception Handler로 이동하여 예외에 관련된 처리를 해주게 됩니다. 
// Controller에 관계없이 사용 가능한 예외처리이다.