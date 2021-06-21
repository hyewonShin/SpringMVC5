package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import kr.co.softcampus.beans.DataBean3;
import kr.co.softcampus.beans.DataBean4;

@Controller
public class TestController {

	// config패키지 -> RootAppContext.java 클래스에서 빈 설정 해준다.
	
	@Autowired    // 타입으로 Bean 주입 
	DataBean1 sessionBean1;
	
	@Resource(name = "sessionBean2")   //이름으로 Bean 주입
	DataBean2 sessionBean2;
	
	
	// config -> ServletAppContext.java 클래스에서 @ComponentScan 
	            // 어노테이션으로 bean 패키지 설정해줌 
	
	@Autowired
	DataBean3 sessionBean3;
	
	@Resource(name = "sessionBean4")
	DataBean4 sessionBean4;
	
	
	
	@GetMapping("/test1")
	public String test1() {  //주입된 bean 객체에 데이터 저장하는 메서드
		
		sessionBean1.setData1("data1");
		sessionBean1.setData2("data2");
		
		sessionBean2.setData3("data3");
		sessionBean2.setData4("data4");
		
		sessionBean3.setData5("data5");
		sessionBean3.setData6("data6");
		
		sessionBean4.setData7("data7");
		sessionBean4.setData8("data8");
		
		return "test1";
	}  
	 //브라우저에서 테스트 시 test1 먼저 클리해줘야 데이터가 삽입된다.
	
	@GetMapping("/result1")
	public String result1(Model model) { 
		// jsp 에서 사용하려면 Model에 저장해주여야 한다. 
		
		System.out.println(sessionBean1.getData1());
		System.out.println(sessionBean1.getData2());
		
		System.out.println(sessionBean2.getData3());
		System.out.println(sessionBean2.getData4());
		
		System.out.println(sessionBean3.getData5());
		System.out.println(sessionBean3.getData6());
		
		System.out.println(sessionBean4.getData7());
		System.out.println(sessionBean4.getData8());
		
		model.addAttribute("sessionBean1",sessionBean1);
		model.addAttribute("sessionBean2",sessionBean2);
		model.addAttribute("sessionBean3",sessionBean3);
		model.addAttribute("sessionBean4",sessionBean4);
		
		return "result1";
	}
	
}
