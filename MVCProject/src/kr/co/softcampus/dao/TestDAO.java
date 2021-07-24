package kr.co.softcampus.dao;

import org.springframework.stereotype.Repository;

//component를 사용하여 bean으로 등록한것은 동일하지만 Repository의 역할이라고 명시해주는 어노테이션이다.
@Repository
public class TestDAO {
	
	public String testDaoMethod() {
		return "문자열";
	}

}
