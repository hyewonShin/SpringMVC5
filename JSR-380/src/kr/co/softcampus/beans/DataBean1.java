package kr.co.softcampus.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

public class DataBean1 {
	
	@NotEmpty
	private String data1;
	
	@NotBlank
	private String data2;
	
	@Positive  //양수만 
	private int data3;
	
	@PositiveOrZero  // 0 또는 양수만 
	private int data4;
	
	@Negative
	private int data5;  //음수만
	
	@NegativeOrZero
	private int data6;  //0 또는 음수만 
	
	@Email  // 중간에 @가 있는지 정도만 체크 
	private String data7;
	
	public DataBean1(){  //생성자는 타입과 return값이 없다.
		this.data1 = "abcd";
		this.data2 = "abcd";
		this.data3 = 30;
		this.data4 = 30;
		this.data5 = -30;
		this.data6 = -30;
	}
	
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	public int getData3() {
		return data3;
	}

	public void setData3(int data3) {
		this.data3 = data3;
	}

	public int getData4() {
		return data4;
	}

	public void setData4(int data4) {
		this.data4 = data4;
	}

	public int getData5() {
		return data5;
	}

	public void setData5(int data5) {
		this.data5 = data5;
	}

	public int getData6() {
		return data6;
	}

	public void setData6(int data6) {
		this.data6 = data6;
	}

	public String getData7() {
		return data7;
	}

	public void setData7(String data7) {
		this.data7 = data7;
	}
	
	
}
