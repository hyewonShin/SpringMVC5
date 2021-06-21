package kr.co.softcampus.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/save_cookie")
	//브라우저로 응답결과를 보내는거라 response 사용 
	public String save_cookie(HttpServletResponse response) {
		
		// 한글 사용할 때 인코딩 
		try {
			String data1 = URLEncoder.encode("문자열","UTF-8");
			String data2 = URLEncoder.encode("문자열222","UTF-8");
	
			Cookie cookie1 = new Cookie("cookie1", data1);
			Cookie cookie2 = new Cookie("cookie2", data2);
			
			//cookie의 수명 정해줌 
			cookie1.setMaxAge(365 * 24 * 60 * 60);
			cookie2.setMaxAge(365 * 24 * 60 * 60);
			
			//브라우저로 보낼 응답결과에 cookie 정보 담아주기 
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "save_cookie";
	}

	@GetMapping("/load_cookie")
	//요청정보에 담겨져 넘어오기 때문에 request 사용해야 된다.
	public String load_cookie(HttpServletRequest request) {
		
		//쿠키 추출
		//인코딩 되어 있으니 다시 한국어로 복원하기 위해서 디코딩 해야된다.
		// Servlet/JSP방식으로 쿠키 정보를 배열로 받아 사용한다.(불편)
		try {
			
			Cookie [] cookies = request.getCookies();
			
			for(Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(), "UTF-8");
				
				if(cookie.getName().equals("data1")) {
					System.out.println(str);
				}else if(cookie.getName().equals("cookie2")) {
					System.out.println(str);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "load_cookie";
	}

	// SpringMVC에서는 쿠키 정보를 주입 받아 사용할 수 있다.(편함)
	@GetMapping("/load_cookie2")
	public String load_cookie2(@CookieValue("cookie1") String cookie1,
							   @CookieValue("cookie2") String cookie2) {
	
		System.out.println(cookie1);
		System.out.println(cookie2);
		
		return "load_cookie2";
	}
	
}


// 서버에서 브라우저로 응답결과를 보낼 때 쿠키정보도 같이 보내주면 브라우저가 저장한다.
// 한글문자를 보낼 때는 반드시 인코딩 해줘야한다.  

// Cookie 읽어오기
// cookie 정보는 브라우저가 요청을 발생 시켰을 때 요청 정보에 같이 담아서 서버로 전달해 준다.
// Servlet/JSP에서는 쿠키 정보를 배열로 받아 사용할 수 있다.( 불편 )
// SpringMVC에서는 쿠키 정보를 주입 받아 사용할 수 있다.

