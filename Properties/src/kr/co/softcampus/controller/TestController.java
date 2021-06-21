package kr.co.softcampus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 첫번째 방법
//@PropertySource("/WEB-INF/properties/data1.properties")  //사용할 properties 파일을 지정해준다.
//@PropertySource("/WEB-INF/properties/data2.properties")  //사용할 properties 파일을 지정해준다.

// 두번째 방법
//@PropertySource(value = { "/WEB-INF/properties/data1.properties",
//						  "/WEB-INF/properties/data2.properties" })

//세번째 방법
@PropertySources({
	@PropertySource("/WEB-INF/properties/data1.properties"),
	@PropertySource("/WEB-INF/properties/data2.properties")
})

public class TestController {

	@Value("${aaa.a1}")
	private int al;
	
	@Value("${aaa.a2}")
	private String a2;
	
	@Value("${bbb.b1}")
	private int b1;
	
	@Value("${bbb.b2}")
	private String b2;
	
	@Value("${ccc.c1}")
	private int c1;
	
	@Value("${ccc.c2}")
	private String c2;
	
	@Value("${ddd.d1}")
	private int d1;
	
	@Value("${ddd.d2}")
	private String d2;
	
	
	
	@GetMapping("/test1")
	public String test1() {

		System.out.println(al);
		System.out.println(a2);

		System.out.println(b1);
		System.out.println(b2);
		
		System.out.println(c1);
		System.out.println(c2);
		
		System.out.println(d1);
		System.out.println(d2);
		
		return "test1";
	}
	
}


// 프로그램 실행 중 변하지 않는 값이 있다면 properties 파일에 정의해서 사용할 수 있다.

// Properties 파일에 한글을 작성하면 유니코드 형식의 문자열로 변경됩니다.
// 이는 Property Editor 설치로 해결할 수 있습니다.
// Help - install - http"//~  

// properties 파일은 WEB-INF 파일 안에만 있으면 된다.
// properties 파일은 new - file 로 만들어준다. 
