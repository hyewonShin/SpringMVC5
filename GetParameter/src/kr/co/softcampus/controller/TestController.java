package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");  
		// "data1"은 jsp에서 name의 값을 가져오는 것이다. 
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		//cnosole창에 jsp에서 받은 값을 출력하는 것 
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for(String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		
		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		if(data3 != null) {
			for(String str1 : data3) {
				System.out.println("data3 : " + str1);
			}
		}
		return "result";
	}
	
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		
		String data1 = request.getParameter("data1");  
		String data2 = request.getParameter("data2");
		String [] data3 = request.getParameterValues("data3");
		
		//cnosole창에 jsp에서 받은 값을 출력하는 것 
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		
		for(String str1 : data3) {
			System.out.println("data3 : " + str1);
		}
		
		return "result";
	}
	
	@GetMapping("/test4/{data1}/{data2}/{data3}")
	public String test4(@PathVariable int data1,
					   @PathVariable int data2,
					   @PathVariable int data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
	
		int add = data1 + data2 + data3;
		System.out.println("add : " + add);
		
		return "result";
	}
	
	@GetMapping("/test5")
	public String test5(@RequestParam int data1,
						@RequestParam int data2,
						@RequestParam int [] data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		for(int a1 : data3) {
			System.out.println("data3 : " + a1);
		}
		
		return "result";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam(value = "data1") int value1,
						@RequestParam(value = "data2") int value2,
						@RequestParam(value = "data3") int [] data3) {
		System.out.println("data1 : " + value1);
		System.out.println("data2 : " + value2);
		for(int a1 : data3) {
			System.out.println("data3 : " + a1);
		}
		return "result";
	}
	
	@GetMapping("/test7")
	public String test7(@RequestParam int data1,
						@RequestParam (required = false) String data2,
						@RequestParam (defaultValue = "0") String data3) {
		System.out.println("data1 : " + data1);
		System.out.println("data2 : " + data2);
		System.out.println("data3 : " + data3);
		
		return "result"; 
	}
}



//WebRequest와 HttpServletRequest의 사용법은 같다. 
//WebRequest는 좀 더 확장된 개념으로 spring에서 제공하는 것. 
//(required = false) jsp에서 데이터의 값이 null 일 때 에러나지 않게 처리해주는 것.
//(defaultValue = "0") jsp에서 데이터가 없을 때 기본 값 미리 설정해주는 것.