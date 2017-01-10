package com.myproject.www.test;

public class IdCardTest {
	public static void main(String[] args) {
		String reg = "^([1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3})|([1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}(x|X)))$";
		String idCard = "370802940244002";
		System.out.println(idCard.matches(reg));
	}
}
