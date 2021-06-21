package kr.co.softcampus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import kr.co.softcampus.beans.DataBean1;
import kr.co.softcampus.beans.DataBean2;

// 프로젝트 작업시 사용할 bean을 정의하는 클래스
@Configuration   // bean 설정 어노테이션 
public class RootAppContext {
	
	@Bean
	@RequestScope  //새로운 요청이 주입됐을 때 bean이 주입됌.
	public DataBean1 dataBean1() {
		return new DataBean1();
	}
	
	@Bean("requestBean2")   //Bean 이름 설정 
	@RequestScope
	public DataBean2 dataBean2() {
		return new DataBean2();
	}
}

