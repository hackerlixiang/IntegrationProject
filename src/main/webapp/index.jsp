<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.myproject.www.utils.SpringUtils"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%	
		//String baseUrl = "http://"+request.getLocalAddr()+":"+request.getLocalPort()+request.getContextPath();
		String baseUrl = SpringUtils.getProperty("baseUrl").toString();
		response.sendRedirect(baseUrl+"/system/index/index");
	%>
</body>
</html>