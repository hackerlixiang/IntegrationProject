package com.myproject.www.test;

public class PatternTest {
	public static void main(String[] args) {
		String reg = "^(?![^A-Za-z]+$)(?![^0-9]+$)[0-9a-zA-Z_]+$";
		String str = "LX445";
		System.out.println(str.matches(reg));
	}
}
