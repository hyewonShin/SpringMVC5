package kr.co.softcampus.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.test.Bean1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		
		request.setAttribute("data1", "문자열1");
		
		return "forward:/result1";
	}
	
	
	@GetMapping("/result1")
	public  String result1(HttpServletRequest request) {
		
		String data1 = (String)request.getAttribute("data1");
		System.out.printf("data1 : %s\n", data1);
		
		return "result1";
	}
	
	
	@GetMapping("/test2")
	public String test2(Model model) {
		
		//Model 객체에 저장하면 request 객체에 저장됌 
		//so 이동한 메서드에서 해당 데이터를 받기위해선 이동한 데이터에서 request 객체를 사용해야됌(model은 데이터 이동 x)).
		model.addAttribute("data2","문자열2");
		
		return"forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(HttpServletRequest request) {
		
		String data2 = (String)request.getAttribute("data2");
		System.out.printf("data2 : %s\n", data2);
		
		return "result2";
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		
		//ModelAndView를 이용헤 데이터를 저장해주면 request 객체에 저장된다.
		//데이터타입도 ModelAndView로 맞춰줘야된다. 
		mv.addObject("data3","문자열3");
		mv.setViewName("forward:/result3");
		
		return mv;
	}

	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		
		String data3 = (String)request.getAttribute("data3");
		System.out.printf("data3 : %s\n", data3);
		
		return "result3";
	}

	@GetMapping("/test4")
	public String test4(Model model) {
		
		DataBean1 bean1 = new DataBean1();  //databean 클래스 객체 생성(bean 쓰려고)
		bean1.setData1("문자열4");
		bean1.setData2("문자열5");
		
		model.addAttribute("bean1", bean1);
		
		return "forward:/result4";
	}

	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		System.out.println(bean1);
		
		return "result4";
	}


	@GetMapping("/test5")
	public String test5(@ModelAttribute("bean1") DataBean1 bean1) {
		
		bean1.setData1("문자열6");
		bean1.setData2("문자열7");
		
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
	//public String result5(@ModelAttribute("bean1") DataBean1 bean1) {  -> 데이터가 연결되지 못해 null 값 뜸 
	public String result5(HttpServletRequest request)  {
		
		DataBean1 bean1 = (DataBean1)request.getAttribute("bean1");
		
		System.out.println(bean1.getData1());
		System.out.println(bean1.getData2());
		
		return "result5";
	}

}



//redirect : uri 바뀜 ( 브라우저에서 요청, session이 유지되지 않음 )
//forward : uri 안버뀜 ( 코드의 흐름을 서버상에서만 이동/브라우저는 다른곳으로 흐름이 
//                     이동되었다는 것을 알 수 없기 때문에 주소창의 주소는 변경되지 않는다.
//					   session이 유지된다.)


// request 영역에 저장하는 목적 
// 1) jsp에서 해당 데이터를 사용하기 위해 ( EL태그 )
// 2) forwarding 했을 때 다른 메서드로 데이터의 흐름이 이동될 때 해당 데이터를 가져가기 위해 