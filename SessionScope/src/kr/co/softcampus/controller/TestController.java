package kr.co.softcampus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.softcampus.beans.DataBean1;

@Controller
@SessionAttributes("sessionBean1") 
//이 클래스에서 sessionBean1 이라는 이름으로 ModelAttribute를 통해 주입받는 객체는 
//request가 아닌 Session 영역으로 저장된다는 것을 명시하는 어노테이션이다. 
public class TestController {

	//객체를 만들어서 반환하는 메서드 (test5 와 연결)
	@ModelAttribute("sessionBean1") //session 객체에 저장할 수 있도록 model사용 
	public DataBean1 sessionBean1() {
		return new DataBean1();
	}
	
	@ModelAttribute("sessionBean1") //session 객체에 저장할 수 있도록 model사용 
	public DataBean1 sessionBean2() {
		return new DataBean1();
	}

	@GetMapping("/test5")
	public String test5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
						@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {

		sessionBean1.setData1("문자열6");
		sessionBean1.setData2("문자열7");
		
		sessionBean2.setData1("문자열8");
		sessionBean2.setData2("문자열9");
				
		return "test5";
	}

	@GetMapping("/test1")
	public String test1(HttpSession session) {
		//public String test1(HttpServletRequest request) {  //servlet 방식
		//HttpSession session = request.getSession();
		session.setAttribute("data1", "문자열1");

		return "test1";
	}

	@GetMapping("/test2")
	public String test2(HttpSession session) {
		session.setAttribute("data2", "문자열2");
		return "redirect:/result1";  //브라우저에서 요청하기에 uri 변경됌
	}

	@GetMapping("/test3")
	public String teset3(HttpSession session) {

		session.setAttribute("data3", "문자열3");
		return "forward:/result1";  //서버에서 이동하는거라 uri 변경안됌 
	}



	@GetMapping("/result1")
	//스프링에서는 이와같이 더 간단히 바로 session을 이용할 수 있다. 
	public String result1(HttpSession session) { 

		// 아래는 서블렛에서의 방식과 동일하다 
		//public String result1(HttpServletRequest request) {
		//HttpSession session = request.getSession();

		String data1 = (String)session.getAttribute("data1");
		System.out.printf(data1);

		String data2 = (String)session.getAttribute("data2");
		System.out.println(data2);

		String data3 = (String)session.getAttribute("data3");
		System.out.println(data3);

		return "result1";
	}


	@GetMapping("/test4")
	//최초에 session에 저장을 할 때는 HttpSession 을 사용하여 데이터를 넣어줘야된다.
	public String test4(HttpSession session) {

		DataBean1 bean1 = new DataBean1();

		bean1.setData1("문자열4");
		bean1.setData2("문자열5");

		session.setAttribute("bean1", bean1);

		return "test4";
	}


	@GetMapping("/result4")
	//위에 메서드와 같이 미리 session에 데이터를 넣어준 다음에는 
	// @SessionAttribute를 사용하여 Bean 클래스 객체를 생성하지 않고 추출할 수 있다.
	//@SessionAttribute : 해당 bean 클레스의 빈들을 자동으로 주입해준다.  
	public String result4(@SessionAttribute("bean1") DataBean1 bean1) {

		System.out.println(bean1.getData1());
		System.out.println(bean1.getData2());

		return "result4";
	}

	
	@GetMapping("/result5")
	public String result5(@ModelAttribute("sessionBean1") DataBean1 sessionBean1,
							@ModelAttribute("sessionBean2") DataBean1 sessionBean2) {
		
		System.out.println(sessionBean1.getData1());
		System.out.println(sessionBean1.getData2());
		
		System.out.println(sessionBean2.getData1());
		System.out.println(sessionBean2.getData2());
	
		return "result5";
	}


	//session은 redirect와 forward 상관없이 브라우저가 종료될 때까지 데이터가 저장된다.
	//request는 redirect는 브라우저에서 새로 요청되기 때문에 데이터가 넘어가지 았았다.

	//@SessionAttribute 어노테이션은 Bean 클래스 객체의 빈을 메서드에 자동으로 주입해준다. 

}


//@SessionAttributes
//: @ModelAttribute를 통해 주입 받는 Bean은 자동으로 request 영역에 저장되고 Request 
//  영역으로부터 주입을 받게 된다.
//: 이때 @ModelAttribute를 통해 주입받는 Bean을 @SessionAttributes으로 지정해 놓으면 
//  request 영역이 아닌 session 영역에 저장되고 session 영역으로부터 주입 받을 수 있다.
//: 주의할 점은 @ModelAttiribute를 활용하여 객체를 생성해 반환하는 메서드를 반드시 작성해 줘야 한다.

