package kr.co.softcampus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.softcampus.dao.TestDAO;

//service클래스 : 어떠한 요청이 발생했을 때, 처리할 코드들을 만들어놓는 클래스
//기능 하나를 처리 할 메서드를 만들어준다
//component를 사용하여 bean으로 등록한것은 동일하지만 service의 역할이라고 명시해주는 어노테이션이다.
@Service  
public class TestService {

	@Autowired
	private TestDAO dao;
	
	public String testMethod() {
		
		String str = dao.testDaoMethod();
		
		return str;
	}
}
