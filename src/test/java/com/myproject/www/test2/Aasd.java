package com.myproject.www.test2;

import java.io.InputStream;


public abstract class Aasd {
	
//	public static void main(String[] args) {
//		String s = "asd阿萨德点的1122";
//		for (int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);
//			if(String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")){
//				System.out.println(c);
//			}
//		}
//	}
	
	public static void main(String[] args) {
		String s = "402880fa591b4a5801591b4c6db80001";
		String[] ss = s.split(",");
		System.out.println(ss.length);
		System.out.println(ss[1]);
		for (String string : ss) {
			System.out.println(string);
		}
	}
}
