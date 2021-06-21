package kr.co.softcampus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.softcampus.beans.DataBean;

@Controller
public class TestController {

	
	@GetMapping("/test1")
	public String test1(@RequestParam Map<String, String> map, 
			            @RequestParam List<String> data3) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		String data33 = map.get("data3");
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
		System.out.printf("data33 : %s\n", data33);
		
		for(String str : data3) {
			System.out.printf("data3 : %s\n", str);
		}
		
		return "result";
	}
	
	@GetMapping("/test2")
	public String test2(@ModelAttribute DataBean bean1,@ModelAttribute DataBean bean2) {
	
		System.out.printf("data1 : %d\n", bean1.getData1());
		System.out.printf("data2 : %d\n", bean1.getData2());
		
		for(int number1 : bean1.getData3()) {
			System.out.printf("data3 : %d\n", number1);
		}
		return "result";
	}
}




// %s : 문자열 형식으로 출력 
// map : 클라이언트가 전달 하는 모든 파라미터 데이터를 한번에 Map으로 받을 수 있다.
// 1) 동일 명으로 전달되는 2개 이상의 파라미터는 하나만 담기게 된다.
// 2) 동일 명으로 전달되는 파라미터가 2개 이상이라면 List로 주입 받아야 한다.
// map은 자동으로 형변환이 되지 않으므로, 파라미터가 정수형이더라도 무조건 String으로 받아야한다.

// @ModelAttribute
// ModelAttribute 어노테이션을 사용하면 파라미터를 객체로 주입받을 수 있다.
// 전달되는 파라미터의 이름과 동일한 프로퍼티에 자동으로 주입된다.
// 이 어노테이션은 생략이 가능하다.
// 이러한 객체를 커맨드 객체(Command Object)라고 부른다. 



