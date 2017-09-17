<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎您:${user.username}</h1>
<a href = "${pageContext.request.contextPath }/blogsPage/1">博客</a>
<a href = "${pageContext.request.contextPath }/writeBlogPage">写博客</a>
<a href = "${pageContext.request.contextPath }/myBlogsPage/1">我的博客</a>
</body>
</html>