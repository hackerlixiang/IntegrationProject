package com.myproject.www.test;

import java.io.File;



public class Xml2MapTest {
	public static void main(String[] args) throws Exception {
		//取得根目录路径  
	    String rootPath=Xml2MapTest.class.getResource("/").getFile().toString();  
	    System.out.println(rootPath);
	    File file = new File("E:/development_environment/eclipse/workspaces/IntegrationProject/target/test-classes/message/message.xml");
	    System.out.println(file.exists());
	}
}
