<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="login" method="post">
username:<input type="text" name = "username" /><br/>
password:<input type="text" name = "password" /><br/>
<input type="submit" value = "登陆" />
</form>
<br/>
<a href = "registPage" >注册</a><br/>
<span>${message}</span>

</body>
</html>