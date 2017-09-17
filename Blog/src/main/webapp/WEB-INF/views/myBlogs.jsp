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
	<h1>我的博客</h1>
	<h2><a href = "${pageContext.request.contextPath }/home">主页</a></h2>
	<table border="1px">
		<tr>
			<td>标题</td>
			<td>发表时间</td>
			
			<td>操作</td>
		</tr>

		<c:forEach var="blog" items="${blogs}">

			<tr>
				<td>${blog.title}</td>
				<td>${blog.date}</td>
				
				<td><a href="${pageContext.request.contextPath }/blogDetail/<c:out value = "${blog.blogid }" />">查看</a> <a href="${pageContext.request.contextPath }/deleteMyBlog/<c:out value = "${blog.blogid}" />">删除</a> <a href="${pageContext.request.contextPath }/updateBlogPage/<c:out value = "${blog.blogid}" />">修改</a></td>
			</tr>

		</c:forEach>
		<tr> <td><a href = "${pageContext.request.contextPath }/myBlogsPage/<c:out value = "${prePage }" />">上一页</a></td><td><a href = "${pageContext.request.contextPath }/myBlogsPage/<c:out value = "${nextPage }" />">下一页</a></td> </tr>

	</table>


</body>
</html>