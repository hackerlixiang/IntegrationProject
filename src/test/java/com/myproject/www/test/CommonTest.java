package com.myproject.www.test;

import com.myproject.www.utils.AbbreviateUtils;

public class CommonTest {
	public static void main(String[] args) {
		System.out.println(AbbreviateUtils.abbrUsername("abcde"));
		System.out.println(AbbreviateUtils.abbrMobile("15982440792"));
		System.out.println(AbbreviateUtils.abbrIdCard("510124199107034911"));
	}
}
