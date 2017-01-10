package com.myproject.www.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.myproject.www.bean.MenuBean;
import com.myproject.www.utils.validate.ValidateUtils;


public class ValidateTest {
	public static void main(String[] args) throws Exception {
		
		MenuBean m = new MenuBean();
//		m.setName("asd");
		m.setIcon("asd");
		m.setPath("/asd");
		System.out.println(ValidateUtils.valid(m));
	}                                         
	
	
	
	 /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
                String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
                Pattern regex = Pattern.compile(check);
                Matcher matcher = regex.matcher(email);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
     
    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber){
        boolean flag = false;
        try{
                Pattern regex = Pattern.compile("^1[3,4,5,7,8]\\d{9}$");
                Matcher matcher = regex.matcher(mobileNumber);
                flag = matcher.matches();
            }catch(Exception e){
                flag = false;
            }
        return flag;
    }
     
}
