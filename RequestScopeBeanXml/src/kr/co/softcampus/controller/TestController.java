package kr.co.softcampus.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;
import kr.co.softcampus.beans.DataBean3;
import kr.co.softcampus.beans.DataBean4;

@Controller
public class TestController {

	@Autowired     // bean 자동주입 어노테이션 
	@Lazy
	DataBean1 requestBean1;  
	//타입으로 주입받겠다고 명시한 것. 
	//새로운 요청이 발생했을 때 주입됌(@RequestScope)
	//request에 주입되는 것이지 저장되는 건 아님.
	//주입된 빈을 저장해서 사용하기 위해서는 Model 객체를 사용하면 된다.
	
	
	@Resource(name = "requestBean2")
	@Lazy
	DataBean2 requestBean2;
	// @Resource : 네임으로 주입받겠다고 명시한 것. 
	//RootAppContext 에서 ("") 안에 이름 지어줌. 
	
	@Autowired
	@Lazy //어노테이션 set 부분 에러날 때 사용 
	DataBean3 requestBean3;
	
	@Resource(name = "requestBean4")
	@Lazy
	DataBean4 requestBean4; 
	
	@GetMapping("/test1") //test1을 요청하게 되면 자동으로 위에 bean1 객체가 주입됌.
	public String test1(){
		
		requestBean1.setData1("문자열1");
		requestBean1.setData2("문자열2");

		requestBean2.setData3("문자열3");
		requestBean2.setData4("문자열4");
		
		requestBean3.setData5("문자열5");
		requestBean3.setData6("문자열6");
		
		requestBean4.setData7("문자열7");
		requestBean4.setData8("문자열8");
	 
		return "forward:/result1";
	}

	
	@GetMapping("/result1") //위에서 forwarding하여 데이터 넘어와서 콘솔창에 데이터 입력됌.
	public String result1(Model model) {
		
		System.out.println(requestBean1.getData1());
		System.out.println(requestBean1.getData2());
		
		System.out.println(requestBean2.getData3());
		System.out.println(requestBean2.getData4());
		
		System.out.println(requestBean3.getData5());
		System.out.println(requestBean3.getData6());
		
		System.out.println(requestBean4.getData7());
		System.out.println(requestBean4.getData8());


		model.addAttribute("requestBean1", requestBean1);
		model.addAttribute("requestBean3", requestBean3);
		model.addAttribute("requestBean4", requestBean4);
		
		
		//WEB-INF -> config -> root-context
		//에서 xml로 이름을 설정하고 주입받을 경우에만 자동저장되서 model을 
		//사용하지 않는다.
		
		//WEB-INF -> config -> servlet-context
		//에서 component-scan을 사용하여 한 번에 해당 패키지 bean을 주입해준다.
		//사용하기 위해선 bean 클래스에서 @Component 어노테이션을 적용해야됌.
		
		//
		
		
		return "result1";
	}
}
