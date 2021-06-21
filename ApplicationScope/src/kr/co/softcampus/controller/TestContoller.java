package kr.co.softcampus.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestContoller {

	//매개변수에 HttpServletRequest를 쓰지 않아도 @Autowired로 주입 받을 수 있다.
	@Autowired
	ServletContext application;
	
	@GetMapping("/test1")
	//public String test1(HttpServletRequest request) {
	public String test1() {
		//ServletContext application = request.getServletContext();
		application.setAttribute("data1", "문자열1");
		
		DataBean1 bean1 = new DataBean1();  //DataBean1 클래스 호출
		bean1.setData1("데이터1");
		bean1.setData2("데이터2");
		
		//DataBean1 클래스 호출해서 안에 값 넣어준 다음에 
		//상단에 @Autowired로 주입해 놓은 application 객체에 bean1 넣어줌. 
		application.setAttribute("bean1", bean1);
		
		return "test1";
	}

	
	@GetMapping("/result1")
	//public String result1(HttpServletRequest request) {
	public String result1() {
		//ServletContext application = request.getServletContext();
		
		String data1 = (String)application.getAttribute("data1");
		
		System.out.println(data1);
		
		// tes1 메서드에서 application에 넣어둔 bean1 을 꺼냄.
		DataBean1 bean1 = (DataBean1)application.getAttribute("bean1");
		System.out.println(bean1.getData1());
		System.out.println(bean1.getData2());
		
		return "result1";
	}
}




 



// 서버가 가동될 때부터 서버가 종료되는 시점까지의 범위를 Appilcation Scope라고 부릅니다.
// Application Scope 동안 사용할 수 있는 메모리 영역이 만들어지며 ServletContext라는
// 클래스 타입의 객체로 관리됩니다.
// ServletContext에 저장된 데이터나 객체는 서버가 종료되기 전까지 서버는 웹브라우저에 
// 관계없이 동일한 메모리 공간을 사용하게 됩니다. 

// url을 다른 브라우저에 복사해서 실행해도 잘 실행된다.
// Application 영역에 저장하는 브라우저에 상관없이 사용 가능하다. 

// 처음요청 -> 응답결과 : requestScope
// 브라우저 최초요청 -> 브라우저 종료 : sessionScope
// 서버 가동 -> 서버 종료 : ApplicationScope

// ServletContext는 Controller에서 @Autowired로 주입 받을 수도 있다. 