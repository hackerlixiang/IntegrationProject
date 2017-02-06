package com.myproject.www.test;

import org.apache.commons.codec.digest.DigestUtils;

import com.myproject.www.utils.encryption.Base64Utils;

public class DigestUtilsTest {
	public static void main(String[] args) throws Exception {
		 String result3 = DigestUtils.sha512Hex("asd");
	     System.out.println(result3);
	     
	     String s = Base64Utils.encode("asd".getBytes());
	     System.out.println("--");
	     System.out.println(s);
	     System.out.println("--");
	     byte[] ss = Base64Utils.decode(s);
	     System.out.println("--");
	     System.out.println(new String(ss));
	     System.out.println("--");
	}
}
