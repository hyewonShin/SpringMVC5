package kr.co.softcampus.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestContoller {
	
	@GetMapping("/input_data")
	public String input_data(DataBean1 dataBean1) {
		
		return "input_data";
	}
	
	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) {
		
		if(result.hasErrors()) {
			return "input_data";
		}
		
		return "input_success";
	}
}



// BindingResult - org.springFramework.validation.BindingResult 
//: Errors의 하위 인터페이스로서 폼 값을 커맨드 객체에 바인딩한 결과를 저장하고 에러코드로 메세지를 가져온다.