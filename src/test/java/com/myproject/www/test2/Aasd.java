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
		String s = "E:/tomact/apache-tomcat-7.0.70/wtpwebapps/gcrcsUploadFile/loanPhoto/2017/01/20/020605/73be5ac347b547c18503cf43cd80ae07.jpg";
		String ss = s.split("\\.")[s.split("\\.").length-1];
		System.out.println(ss);
	}
}
