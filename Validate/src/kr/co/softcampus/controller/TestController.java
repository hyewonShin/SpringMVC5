package kr.co.softcampus.controller;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.softcampus.beans.DataBean1;

@Controller
public class TestController {

	@GetMapping("/input_data")
	public String input_data() {

		return "input_data";
	}

	@PostMapping("/input_pro")
	public String input_pro(@Valid DataBean1 dataBean1, BindingResult result) { //ModelAttribute 생략 

		System.out.println(dataBean1.getData1());
		System.out.println(dataBean1.getData2());

		System.out.println(result);


		//유효성 검사에서 위반된 부분이 있다면...
		if(result.hasErrors()) {  
			// 유효성 위반 결과들 모두 가져온다.
			for(ObjectError obj : result.getAllErrors()){
				System.out.printf("메시지 : %s\n",obj.getDefaultMessage());
				System.out.printf("코드 : %s\n",obj.getCode());
				System.out.printf("object name : %s\n",obj.getObjectName());

				System.out.println("----------------------------------------------------");

				String [] codes = obj.getCodes();
				for(String c1 : codes) {
					System.out.println(c1);
				}

				if(codes[0].equals("Size.dataBean1.data1")) {
					System.out.println("data1은  2 ~ 10글자를 담을 수 있습니다.");
				} else if (codes[0].equals("Max.dataBean1.data2")){
					System.out.println("data2는 100 이하의 값만 담을 수 있습니다");
				}	

				System.out.println("----------------------------------------------------");
			}
			
			return "input_data";
		}

		return "input_success";
	}
}




// @Valid
// Controller의 메서드에서 주입 받는 Bean에 @Valid를 설정하면 유효성 검사를 실시합니다.
// 유효성 검사 결과를 사용하고자 한다면 BindingResult 객체를 주입받아야 합니다.
// 이 객체에는 유효성 검사를 실행한 결과 정보가 담겨있습니다.
// 이를 통해 Controller 에서 사용자가 입력한 값에 문제가 있는지 파악할 수 있습니다.
// 값은 제대로 출력된다. 틀렸다는 정보를 알려줄 뿐 