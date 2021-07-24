package kr.co.softcampus.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.softcampus.beans.DataBean;

@RestController
public class RestTestController {

	@GetMapping("/test2")
	public ResponseEntity<ArrayList<DataBean>>test2() {
		
		DataBean bean1 = new DataBean("문자열1", 100, 11.11, false);
		DataBean bean2 = new DataBean("문자열2", 200, 22.11, true);
		DataBean bean3 = new DataBean("문자열3", 300, 33.11, false);
		
		ArrayList<DataBean> list = new ArrayList<DataBean>();
		list.add(bean1);
		list.add(bean2);
		list.add(bean3);
		
		//브라우저한테 지금 보내는 데이터가 정상적이라는 것을 알려주는 것
		ResponseEntity<ArrayList<DataBean>> entry = new ResponseEntity<ArrayList<DataBean>>(list, HttpStatus.OK);
		
		return entry;  
	}
}


// RestController은 응답결과로 jsp 페이지가 아닌 데이터 자체를 반환한다. 
// "test2" jpg 페이지가 없어도 test2라는 값이 반환되는 것을 확인할 수 있다.