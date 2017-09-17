<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="">

标题:<input type="text" value="${blog.title}"  readonly="readonly"/><br/>
作者:<input type="text" value="${blog.user.username}"  readonly="readonly"/><br/>
<textarea rows="10" cols="40" readonly="readonly">
${blog.content}
</textarea>

</form>
<br/>
<a href = "${pageContext.request.contextPath }/home">返回</a>



</body>
</html>