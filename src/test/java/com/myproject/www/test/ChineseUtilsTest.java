package com.myproject.www.test;

import com.myproject.www.utils.ChineseUtils;

/**
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月15日 下午6:09:13
 */
public class ChineseUtilsTest {
	public static void main(String[] args) {
		System.out.println(ChineseUtils.isChinese('啊'));
		System.out.println(ChineseUtils.getChineseByStr("asdasd阿萨德aa1111d的"));
	}
	
}

